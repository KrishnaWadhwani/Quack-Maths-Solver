package com.learning.quack;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class createpost extends AppCompatActivity {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createpost);
    }
    public void post(View view){
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        Uri personPhoto = acct.getPhotoUrl();
        String personImage = personPhoto.toString();
        EditText epost = findViewById(R.id.postInput);
        String post = epost.getText().toString();
        if (post.isEmpty()){
            Toast.makeText(this, "Write Your Post First", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();

                Map<String, Object> postdata = new HashMap<>();
                postdata.put("name", personName);
                postdata.put("given_name", personGivenName);
                postdata.put("family_name", personFamilyName);
                postdata.put("email", personEmail);
                postdata.put("image", personImage);
                postdata.put("account_id", personId);
                postdata.put("timeStamp", Calendar.getInstance().getTime());
                postdata.put("post", post);
                db.collection("Posts").add(postdata)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(createpost.this, "Post Created", Toast.LENGTH_SHORT).show();
                                Intent chat = new Intent(createpost.this, chat.class);
                                startActivity(chat);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(createpost.this, "Some Error Occurred Please Try Again Later", Toast.LENGTH_SHORT).show();
                            }
                        });
            }

            else{
                Intent intent = new Intent(this, login.class);
                startActivity(intent);
            }
        }
    }

}