package com.learning.quack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth mAuth;
    private FirebaseAnalytics mFirebaseAnalytics;
    public void square(View view){
        String cs = "SquareX2";
        Bundle bundle = new Bundle();
        Intent insquare = new Intent(this, square.class);
        startActivity(insquare);
        mFirebaseAnalytics.logEvent(cs, bundle);
    }
    public void cube(View view){
        String csc = "CubeX3";
        Bundle bundle = new Bundle();
        Intent incube = new Intent(this, cube.class);
        startActivity(incube);
        mFirebaseAnalytics.logEvent(csc, bundle);
    }
    public void percent(View view){
        String csp = "Percent";
        Bundle bundle = new Bundle();
        Intent percent = new Intent(this, percent.class);
        startActivity(percent);
        mFirebaseAnalytics.logEvent(csp, bundle);
    }
    public void coc(View view){
        String cscoc = "COC";
        Bundle bundle = new Bundle();
        Intent coc = new Intent(this, coc.class);
        startActivity(coc);
        mFirebaseAnalytics.logEvent(cscoc, bundle);
    }
    public void home(View view){
        String cshome = "Home";
        Bundle bundle = new Bundle();
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
        mFirebaseAnalytics.logEvent(cshome, bundle);
    }
    public void quad(View view){
        String csquad = "Quad";
        Bundle bundle = new Bundle();
        Intent quad = new Intent(this, quad.class);
        startActivity(quad);
        mFirebaseAnalytics.logEvent(csquad, bundle);
    }
    public void root(View view){
        String csroot = "Root";
        Bundle bundle = new Bundle();
        Intent root = new Intent(this, root.class);
        startActivity(root);
        mFirebaseAnalytics.logEvent(csroot, bundle);
    }
    public void moreformulas(View view){
        String csmf = "MoreFormulas";
        Bundle bundle = new Bundle();
        Intent moref = new Intent(this, moreformulas.class);
        startActivity(moref);
        mFirebaseAnalytics.logEvent(csmf, bundle);
    }
    public void logout(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Logout From Quack?");
        // alert.setMessage("Message");

        alert.setPositiveButton("Yes, Logout", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                Intent login = new Intent(MainActivity.this, login.class);
                startActivity(login);
            }
        });
        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent home = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(home);
                    }
                });

        alert.show();
    }
    public void chat(View view){
        String cschat = "Chat";
        Bundle bundle = new Bundle();
        Intent quad = new Intent(this, chat.class);
        startActivity(quad);
        mFirebaseAnalytics.logEvent(cschat, bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("QuackNotifications","QuackNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "QuackNotifications")
                .setSmallIcon(R.drawable.undraw_awesome_rlvy__1_)
                .setContentTitle("Welcome To Quack")
                .setContentText("Nice To Meet You")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(999, builder.build());
    }
}