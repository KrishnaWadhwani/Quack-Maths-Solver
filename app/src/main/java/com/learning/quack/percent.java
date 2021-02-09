package com.learning.quack;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class percent extends AppCompatActivity {
    public void inper(View view){
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        String instr1 = input1.getText().toString();
        String instr2 = input2.getText().toString();
        if (instr1.matches("")){
            Toast.makeText(this,"Please Fill Input-1",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(instr2.matches("")){
            Toast.makeText(this,"Please Fill Input-2",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            share.setVisibility(View.VISIBLE);
            double finalvalue1 = Integer.parseInt(instr1);
            double finalvalue2 = Integer.parseInt(instr2);
            TextView ans = findViewById(R.id.ans);
            double percent = finalvalue1 * 100 / finalvalue2;
            ans.setText(finalvalue1+" Is "+percent+"% Of "+ finalvalue2);
            Toast.makeText(this,finalvalue1+" Is "+percent+"% Of "+ finalvalue2,Toast.LENGTH_SHORT).show();
        }

    }
    public void share(View view){
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        String instr1 = input1.getText().toString();
        String instr2 = input2.getText().toString();
        double finalvalue1 = Integer.parseInt(instr1);
        double finalvalue2 = Integer.parseInt(instr2);
        double percent = finalvalue1 * 100 / finalvalue2;
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, finalvalue1+" Is "+percent+"% Of "+ finalvalue2+" Answer By Quack Maths Homework Solver, Download Quack Maths Homework Solver Now https://play.google.com/store/apps/details?id=com.learning.quack");
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
        setContentView(R.layout.percent);
        Button share;
        share = findViewById(R.id.shareanswer);
        share.setVisibility(View.GONE);
    }
}