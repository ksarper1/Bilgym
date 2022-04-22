package com.memduhtutus.bilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupScreen extends AppCompatActivity {

    private EditText nameSurname,email,bilkentID,password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        nameSurname = (EditText) findViewById(R.id.editTextTextPersonName);
        email = (EditText) findViewById(R.id.EditTextEmailAddress);
        bilkentID = (EditText) findViewById(R.id.EditTextBilkentID);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        mAuth = FirebaseAuth.getInstance();

    }

    public void signUpFinalClicked(View view){

        String nameSur = nameSurname.getText().toString();
        String email1 = email.getText().toString();
        String bilkentID1 = bilkentID.getText().toString();
        int bilkentIDFire = Integer.parseInt(bilkentID1);
        String password1 = password.getText().toString();

        if(!TextUtils.isEmpty(nameSur) && !TextUtils.isEmpty(email1) && !TextUtils.isEmpty(bilkentID1) && !TextUtils.isEmpty(password1)){
                mAuth.createUserWithEmailAndPassword(email1,password1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent intent = new Intent(SignupScreen.this, MainScreen.class);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignupScreen.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        }
        else{
            Toast.makeText(this, "Please enter some value", Toast.LENGTH_LONG).show();
        }
    }
}