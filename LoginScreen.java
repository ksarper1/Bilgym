package com.memduhtutus.bilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.memduhtutus.tryingbilgym.databinding.ActivityLogInScreenBinding;
import com.memduhtutus.tryingbilgym.databinding.ActivitySignUpScreenBinding;

public class LogInScreen extends AppCompatActivity {
    ActivityLogInScreenBinding binding;
    FirebaseAuth auth;
    SignUpScreen object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityLogInScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
    }
    public void LogInButtonClicked(View view){
        String email = binding.editTextMailInput.getText().toString();
        String password = binding.editTextPasswordInput.getText().toString();
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(LogInScreen.this, MainScreen.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LogInScreen.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
