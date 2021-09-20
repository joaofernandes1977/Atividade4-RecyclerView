package com.example.trabalhojsonaula.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhojsonaula.R;
import com.example.trabalhojsonaula.model.Posts;
import com.example.trabalhojsonaula.model.Todo;
import com.example.trabalhojsonaula.model.User;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {


    private List<Posts> dados2;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PostsAdapter(List<Posts> posts) {
        this.dados2 = posts;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.posts_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //coloca os dados dentro do ViwHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Posts posts = dados2.get(position);

        TextView tv = holder.view.findViewById(R.id.idPost);
        tv.setText(posts.getId());

        tv = holder.view.findViewById(R.id.titlePosts);
        tv.setText(posts.getTitle());

        tv = holder.view.findViewById(R.id.bodyPosts);
        tv.setText(posts.getBody());




        //TextView tv2 = holder.view.findViewById(R.id.tvTodoTitulo2);
        //tv2.setText(dados.get(position).getId());

        //TextView tv2 = holder.view.findViewById(R.id.tvTodoTitulo);
        //tv2.setText(dados.get(position).getTitle());
        //View tv1 = holder.view.findViewById(R.id.tNumber);
        //tv1.setId(dados.get(position).getUser_id());


    }


    @Override
    public int getItemCount() {

        return dados2.size();
    }


}
