package com.memduhtutus.bilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }
    public void gymAppoClicked(View view){

    }

    public void persProgClicked(View view){

    }
    public void matchmakingClicked(View view){

    }
    public void aboutUsClicked(View view){

        Intent intent = new Intent(MainScreen.this, AboutUs.class);
        startActivity(intent);

    }
    public void setButtonClicked(View view){

        Intent intent = new Intent(MainScreen.this, SetScreen.class);
        startActivity(intent);

    }
    public void logOutClicked (View view){

    }
}
