package com.example.yassin.streetglide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }
    public void continu(View view){
        startActivity(new Intent(this,RunnerDashbord.class));


    }
    public void back(View view){

        startActivity(new Intent(this,Welcome.class));
    }
}
