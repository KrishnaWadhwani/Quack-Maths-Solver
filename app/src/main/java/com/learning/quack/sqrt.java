package com.learning.quack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class sqrt extends AppCompatActivity {

    public void sqrt(View view){
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
        EditText input1 = findViewById(R.id.input1);
        String inputstr = input1.getText().toString();
        if (inputstr.matches("")){
            Toast.makeText(this, "Please First Enter A Value To Get √", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            share.setVisibility(View.VISIBLE);
            double finalvalue = Integer.parseInt(inputstr);
            TextView ans = findViewById(R.id.ans);
            ans.setText("√: "+Math.sqrt(finalvalue));
            Toast.makeText(this, "√: " + Math.sqrt(finalvalue) , Toast.LENGTH_SHORT).show();
        }
    }
    public void share(View view){
        EditText input1 = findViewById(R.id.input1);
        String inputstr = input1.getText().toString();
        int finalvalue = Integer.parseInt(inputstr);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Square Root(√"+finalvalue+") Of "+finalvalue+" = "+Math.sqrt(finalvalue)+" Answer By Quack Maths Homework Solver, Download Quack Maths Homework Solver Now https://play.google.com/store/apps/details?id=com.learning.quack");
        sendIntent.setType("text/*");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
    public void home(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    public void back(View view){
        Intent back = new Intent(this, root.class);
        startActivity(back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqrt);
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
    }
}