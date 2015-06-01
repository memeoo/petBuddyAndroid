package project.pb.petbuddy.activities;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import project.pb.petbuddy.R;
import project.pb.petbuddy.base.PetBuddyApplication;

public class LogInActivity extends Activity {

    private EditText edId;
    private EditText edPass;
    private Button btnLogin;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    private static final int REQUEST_CODE_GENERAL_SIGNUP = 1000;
    private static final int REQUEST_CODE_FACEBOOK_SIGNUP = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);


        edId = (EditText)findViewById(R.id.inputId);
        edPass = (EditText)findViewById(R.id.password);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("meme", " FaceBook Login Success !!");
                String userId = loginResult.getAccessToken().getUserId();
                Log.d("meme", " UserID = " + userId);


                ParseUser user = new ParseUser();
                user.setUsername(userId);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null){

                            PetBuddyApplication.savePreferences("loginOK", true);
                            Intent goMain = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(goMain);
                            finish();
                        }
                    }
                });
            }

            @Override
            public void onCancel() {
                Log.d("meme", " FaceBook Login Canceled !!");
            }

            @Override
            public void onError(FacebookException exception) {
                Log.d("meme", " FaceBook Login Some Errors !!");
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_GENERAL_SIGNUP){
            edId.setText(data.getStringExtra("id"));
            edPass.setText(data.getStringExtra("pass"));
        }

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void onClickLogin(View v){
        String id = edId.getText().toString();
        String pass = edPass.getText().toString();

        if(id.equals("")){
            Toast.makeText(getBaseContext(), "ID를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(pass.equals("")){
            Toast.makeText(getBaseContext(), "Password를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        ParseUser user = new ParseUser();
        user.logInInBackground(id, pass, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if(e == null){
                    Log.d("meme", " Login Succeed !!");
                    PetBuddyApplication.savePreferences("loginOK", true);
                    Intent goBackMain = new Intent();
                    goBackMain.putExtra("id", parseUser.getUsername());
                    setResult(1, goBackMain);
                    finish();
                    Toast.makeText(getBaseContext(),"로그인 성공 !!" , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(), "ID 또는 Password를 다시 입력해 주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void onClickSignUp(View v){
         Intent goSignUp = new Intent(this, SignUpActivity.class);
         startActivityForResult(goSignUp, REQUEST_CODE_GENERAL_SIGNUP);
    }


}
