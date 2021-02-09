package com.learning.quack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class shaperectperimeter extends AppCompatActivity {

    public void perimeter(View view){
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        String inputstr1 = input1.getText().toString();
        String inputstr2 = input2.getText().toString();
        if (inputstr1.matches("")){
            Toast.makeText(this, "Please Enter Length To Get Perimeter", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (inputstr2.matches("")){
            Toast.makeText(this, "Please Enter Width To Get Perimeter", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            share.setVisibility(View.VISIBLE);
            double l = Integer.parseInt(inputstr1);
            double b = Integer.parseInt(inputstr2);
            double p = l+b+l+b;
            TextView ans = findViewById(R.id.ans);
            ans.setText("Perimeter: "+p);
            Toast.makeText(this, "Perimeter: "+p, Toast.LENGTH_SHORT).show();
        }
    }
    public void share(View view){
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        String inputstr1 = input1.getText().toString();
        String inputstr2 = input2.getText().toString();
        double l = Integer.parseInt(inputstr1);
        double b = Integer.parseInt(inputstr2);
        double p = l+b+l+b;
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Perimeter Of Rectangle(l="+l+",b="+b+") = "+p+""+" Answer By Quack Maths Homework Solver, Download Quack Maths Homework Solver Now https://play.google.com/store/apps/details?id=com.learning.quack");
        sendIntent.setType("text/*");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
    public void home(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    public void back(View view){
        Intent back = new Intent(this, shaperect.class);
        startActivity(back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shaperectperimeter);
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
    }
}