package com.learning.quack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pt extends AppCompatActivity {
    public void pt(View view){
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
        EditText input1 = findViewById(R.id.input1);
        String inputstr = input1.getText().toString();
        if (inputstr.matches("")){
            Toast.makeText(this, "Please Enter The Value Of 2m", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            share.setVisibility(View.VISIBLE);
            double finalvalue = Integer.parseInt(inputstr);
            double m = finalvalue/2;
            double msqmi1 = m*m-1;
            double msqmad1 = m*m+1;
            TextView ans = findViewById(R.id.ans);
            TextView ans1 = findViewById(R.id.ans1);
            TextView ans2 = findViewById(R.id.ans2);
            ans.setText("2m: "+finalvalue);
            ans1.setText("m^2-1: "+msqmi1);
            ans2.setText("m^2+1: "+msqmad1);
            Toast.makeText(this, "2m: "+finalvalue+",m^2-1: "+msqmi1+", m^2+1:"+msqmad1, Toast.LENGTH_SHORT).show();
        }
    }
    public void share(View view){
        EditText input1 = findViewById(R.id.input1);
        String inputstr = input1.getText().toString();
        double finalvalue = Integer.parseInt(inputstr);
        double m = finalvalue/2;
        double msqmi1 = m*m-1;
        double msqmad1 = m*m+1;
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Pythagorean Triplet: 2m="+m+" & m^2-1="+msqmi1+" & m^2+1="+msqmad1+" Answer By Quack Maths Homework Solver, Download Quack Maths Homework Solver Now https://play.google.com/store/apps/details?id=com.learning.quack");
        sendIntent.setType("text/*");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
    public void home(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    public void back(View view){
        Intent back = new Intent(this, moreformulas.class);
        startActivity(back);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pt);
        EditText input1 = findViewById(R.id.input1);
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
    }
}