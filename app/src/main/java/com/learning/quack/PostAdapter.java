package com.learning.quack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.myviewholder>{
    ArrayList<model> datalist;
    private Context context;

    public PostAdapter(ArrayList<model> datalist) {
        this.datalist = datalist;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.username.setText(datalist.get(position).getName());
        holder.email.setText(datalist.get(position).getEmail());
        holder.post.setText(datalist.get(position).getPost());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView username, email, post;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            post = itemView.findViewById(R.id.post);
        }
    }
}