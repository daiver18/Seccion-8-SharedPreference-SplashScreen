package com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.R;
import com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.Utils.Utils;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefers = getSharedPreferences("preferences", Context.MODE_PRIVATE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.LogOut:
                logOut();
                return true;
            case R.id.Forgot_LogOut:
                Utils.removeSharedPreferends(prefers);
                logOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logOut(){
        Intent intent = new Intent(this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
