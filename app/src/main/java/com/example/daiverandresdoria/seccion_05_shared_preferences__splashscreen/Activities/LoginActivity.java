package com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.R;
import com.example.daiverandresdoria.seccion_05_shared_preferences__splashscreen.Utils.Utils;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences prefer;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchRemember;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefer = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        bindUI();
        setCredencialsIfExist();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String pass = editTextPassword.getText().toString();
                if (Login(email,pass)){
                    goToMain();
                    savePreferences(email,pass);
                }
            }
        });
    }

    private void bindUI(){
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPass);
        switchRemember = findViewById(R.id.switchRemember);
        btnLogin = findViewById(R.id.buttonLogin);
    }

    private void setCredencialsIfExist() {
        String email = Utils.getEmail(prefer);
        String pass = Utils.getPass(prefer);
        if (!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(pass)){
            editTextEmail.setText(email);
            editTextPassword.setText(pass);
            switchRemember.setChecked(true);
        }
    }

    private boolean Login(String email,String pass){
        if (!validEmail(email)){
            Toast.makeText(this,"the email no is valid, please try again",Toast.LENGTH_SHORT).show();
            return false;
        }else if (!validPassword(pass)){
            Toast.makeText(this,"the password no is valid. 4 characters or more, please try again",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    private void savePreferences(String email,String pass){
        if (switchRemember.isChecked()){
            SharedPreferences.Editor editor = prefer.edit();
            editor.putString("email",email);
            editor.putString("pass",pass);
            editor.apply();
        }
    }

    private boolean validEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validPassword(String pass){
        return pass.length()>=4;
    }

    private void goToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK  | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
