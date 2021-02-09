package com.learning.quack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class shapesquare extends AppCompatActivity {
    public void home(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
    public void perimeter(View view){
        Intent peri = new Intent(this, shapesquareperimeter.class);
        startActivity(peri);
    }
    public void area(View view){
        Intent area = new Intent(this, shapesquarearea.class);
        startActivity(area);
    }
    public void back(View view){
        Intent back = new Intent(this, quad.class);
        startActivity(back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shapesquare);
    }
}