package project.pb.petbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;


import com.parse.ParseObject;
import com.parse.ParseUser;

import project.pb.petbuddy.R;

public class LogInActivity extends Activity {

    private EditText edId;
    private EditText edPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        edId = (EditText)findViewById(R.id.inputId);
        edPass = (EditText)findViewById(R.id.password);

    }

    public void onClickLogin(View v){
        String id = edId.getText().toString();
        String pass = edPass.getText().toString();

    }

    public void onClickSignUp(View v){

    }


}
