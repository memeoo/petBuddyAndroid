package project.pb.petbuddy.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.parse.Parse;

import project.pb.petbuddy.R;

/**
 * Created by meme on 15. 5. 16..
 */
public class PetBuddyApplication extends Application{
    public static SharedPreferences pref;

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));

        pref = getBaseContext().getSharedPreferences("pref", getBaseContext().MODE_PRIVATE);
        Log.d("meme", " Application Created !!");

    }

    // 값 불러오기
    public static String getPreferencesString(String key){
        return pref.getString(key, "defVal");
    }

    public static boolean getPreferencesBoolean(String key){
        return pref.getBoolean(key, false);
    }

    // 값 저장하기
    public static void savePreferences(String key, String value){
//        pref = context.getSharedPreferences("pref", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    // 값 저장하기
    public static void savePreferences(String key, boolean value){
//        pref = context.getSharedPreferences("pref", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    // 값(Key Data) 삭제하기
    public static void removePreferences(String key){
//        pref = context.getSharedPreferences("pref", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.commit();
    }

    // 값(ALL Data) 삭제하기
    public static void removeAllPreferences(){
//        pref = activity.getSharedPreferences("pref", activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
