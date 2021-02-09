package com.learning.quack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class moreformulas extends AppCompatActivity {

    public void home(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
    public void log(View view) {
        Intent log = new Intent(this, log.class);
        startActivity(log);
    }
    public void nb2(View view){
        Intent nb2 = new Intent(this, nb2.class);
        startActivity(nb2);
    }
    public void pt(View view){
        Intent pt = new Intent(this, pt.class);
        startActivity(pt);
    }

    public void back(View view){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moreformulas);
    }
}