package com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.Activities.LoginActivity;
import com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.Activities.MainActivity;
import com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.Utils.Utils;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences prefer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefer = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this,LoginActivity.class);
        Intent intentMain = new Intent(this,MainActivity.class);
        if (!TextUtils.isEmpty(Utils.getEmail(prefer))&&!TextUtils.isEmpty(Utils.getPass(prefer))){
            startActivity(intentMain);
        }else{
            startActivity(intentLogin);
        }
    }
}
