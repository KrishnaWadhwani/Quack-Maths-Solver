package com.learning.quack;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class chat extends AppCompatActivity {
    RecyclerView recview;
    ArrayList<model> datalist;
    PostAdapter adapter;
    private Context context;

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private View view;
    private int position;

    public void createpost(View view){
        Intent intent = new Intent(this, createpost.class);
        startActivity(intent);
    }


    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        recview = (RecyclerView)findViewById(R.id.recyclerView);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();
        adapter=new PostAdapter(datalist);
        recview.setAdapter(adapter);
        db.collection("Posts")
                .orderBy("timeStamp", Query.Direction.DESCENDING).get()

                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            model obj = d.toObject(model.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }

                });
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recview = (RecyclerView)findViewById(R.id.recyclerView);
                recview.setLayoutManager(new LinearLayoutManager(chat.this));
                datalist=new ArrayList<>();
                adapter=new PostAdapter(datalist);
                recview.setAdapter(adapter);
                db.collection("Posts")
                        .orderBy("timeStamp", Query.Direction.DESCENDING).get()

                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                                for(DocumentSnapshot d:list)
                                {
                                    model obj = d.toObject(model.class);
                                    datalist.add(obj);
                                }
                                adapter.notifyDataSetChanged();
                            }


                        });
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }

        });
    }
}