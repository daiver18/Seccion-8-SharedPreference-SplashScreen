package com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.App;

import android.app.Application;
import android.os.SystemClock;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
