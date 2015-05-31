package project.pb.petbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import project.pb.petbuddy.R;

public class SignUpActivity extends Activity {

    private EditText edEmail;
    private EditText edId;
    private EditText edPass;
    private EditText edRePass;
    private Button btnConfirm;

    private String id;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_signup);

        edEmail = (EditText)findViewById(R.id.edEmail);
        edId = (EditText)findViewById(R.id.edId);
        edPass = (EditText)findViewById(R.id.edPass);
        edRePass = (EditText)findViewById(R.id.edRePass);


    }

    public void onClickConfirm(View v){
        String email = edEmail.getText().toString();
        id = edId.getText().toString();
        pass = edPass.getText().toString();
        String rePass = edRePass.getText().toString();


        if(!pass.equals(rePass)) {
            Toast.makeText(getBaseContext(),"Password를 다시 입력해 주세요", Toast.LENGTH_SHORT).show();
            edPass.setText("");
            edRePass.setText("");
            return;
        }

        if(pass.equals("")){
            Toast.makeText(getBaseContext(),"Password을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if(email.equals("")){
            Toast.makeText(getBaseContext(),"Email을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if(id.equals("")){
            Toast.makeText(getBaseContext(),"사용하실 ID를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        ParseUser user = new ParseUser();
        user.setEmail(email);
        user.setUsername(id);
        user.setPassword(pass);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Log.d("meme", " Sign up Succeed !!");
                    Intent backIntent = new Intent();
                    backIntent.putExtra("id", id);
                    backIntent.putExtra("pass", pass);
                    setResult(1,backIntent);

                }else{
                    Toast.makeText(getBaseContext(),"죄송합니다. 회원 가입시 오류가 발생했습니다. 다시 가입해 주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
