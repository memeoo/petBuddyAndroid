package project.pb.petbuddy.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.FacebookSdk;

import project.pb.petbuddy.R;

public class SignUpActivity extends Activity {

    private EditText edEmail;
    private EditText edId;
    private EditText edPass;
    private EditText edRePass;
    private Button btnConfirm;

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
        String id = edId.getText().toString();
        String pass = edPass.getText().toString();
        String rePass = edRePass.getText().toString();

    }


}
