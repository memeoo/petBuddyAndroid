package project.pb.petbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.facebook.FacebookSdk;

import project.pb.petbuddy.R;

public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_loading);



        Handler handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {

                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();


                super.handleMessage(msg);
            }

        };

        handler.sendEmptyMessageDelayed(0, 1000);
    }


}
