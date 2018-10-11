package com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.Utils;

import android.content.SharedPreferences;

public class Utils {

    public static String getEmail(SharedPreferences preferences){
        return preferences.getString("email","");
    }

    public static String getPass(SharedPreferences preferences){
        return preferences.getString("pass","");
    }

    public static void removeSharedPreferends(SharedPreferences preferences){
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("email");
        editor.remove("pass");
        editor.apply();
    }

}
