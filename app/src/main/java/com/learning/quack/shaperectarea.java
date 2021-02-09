package com.learning.quack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class shaperectarea extends AppCompatActivity {

    public void area(View view){
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        String inputstr1 = input1.getText().toString();
        String inputstr2 = input2.getText().toString();
        if (inputstr1.matches("")){
            Toast.makeText(this, "Please Enter Length To Get Area", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (inputstr2.matches("")){
            Toast.makeText(this, "Please Enter Width To Get Area", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            share.setVisibility(View.VISIBLE);
            int l = Integer.parseInt(inputstr1);
            int b = Integer.parseInt(inputstr2);
            TextView ans = findViewById(R.id.ans);
            ans.setText("Area: "+l*b);
            Toast.makeText(this, "Area: "+l*b, Toast.LENGTH_SHORT).show();
        }
    }
    public void share(View view){
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        String inputstr1 = input1.getText().toString();
        String inputstr2 = input2.getText().toString();
        int l = Integer.parseInt(inputstr1);
        int b = Integer.parseInt(inputstr2);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Rectangle Area(l="+l+",b="+b+") Of "+l*b+" = "+l*b+" Answer By Quack Maths Homework Solver, Download Quack Maths Homework Solver Now https://play.google.com/store/apps/details?id=com.learning.quack");
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
        setContentView(R.layout.shaperectarea);
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
    }
}