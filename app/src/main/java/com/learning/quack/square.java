package com.learning.quack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class square extends AppCompatActivity {
    public void insquare(View view){
        EditText input1 = findViewById(R.id.input1);
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
        String inputstr = input1.getText().toString();
        if (inputstr.matches("")){
            Toast.makeText(this, "Please First Enter A Value To Get X^2", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            share.setVisibility(View.VISIBLE);
            int finalvalue = Integer.parseInt(inputstr);
            TextView ans = findViewById(R.id.ans);
            ans.setText(finalvalue + "^2 = "+finalvalue*finalvalue);
            Toast.makeText(this, finalvalue + "^2 = "+finalvalue*finalvalue, Toast.LENGTH_SHORT).show();
        }
    }
    public void share(View view){
        EditText input1 = findViewById(R.id.input1);
        String inputstr = input1.getText().toString();
        int finalvalue = Integer.parseInt(inputstr);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Square("+finalvalue+"^2) Of "+finalvalue+" = "+finalvalue*finalvalue+" Answer By Quack Maths Homework Solver, Download Quack Maths Homework Solver Now https://play.google.com/store/apps/details?id=com.learning.quack");
        sendIntent.setType("text/*");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
    public void home(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
    public void back(View view){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.square);
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
    }
}