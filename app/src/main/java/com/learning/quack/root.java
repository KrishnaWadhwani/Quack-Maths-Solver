package com.learning.quack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class root extends AppCompatActivity {

    public void home(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
    public void sqrt(View view){
        Intent sqrt = new Intent(this, sqrt.class);
        startActivity(sqrt);
    }
    public void cbrt(View view){
        Intent cbrt = new Intent(this, cbrt.class);
        startActivity(cbrt);
    }
    public void back(View view){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root);
    }
}