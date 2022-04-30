package com.memduhtutus.bilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeScreen extends AppCompatActivity {
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  FirebaseUser user = auth.getCurrentUser();
        /*if(user != null) {
            Intent intent = new Intent(WelcomeScreen.this, LogInScreen.class);
            startActivity(intent);
            finish();

        }*/
    }

    public void signUpClicked(View view){
        Intent intent = new Intent(WelcomeScreen.this, SignUpScreen.class);
        startActivity(intent);
        finish();

    }
    public void logInClicked(View view){
        Intent intent = new Intent(WelcomeScreen.this, LogInScreen.class);
        startActivity(intent);
        finish();

    }
}
