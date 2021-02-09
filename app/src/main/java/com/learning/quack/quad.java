package com.learning.quack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class quad extends AppCompatActivity {
    public void square(View view){
        Intent square = new Intent(this, shapesquare.class);
        startActivity(square);
    }
    public void rect(View view){
        Intent rect = new Intent(this, shaperect.class);
        startActivity(rect);
    }
    public void back(View view){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }
    public void home(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quad);
    }
}