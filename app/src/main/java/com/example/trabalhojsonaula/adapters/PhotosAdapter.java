package com.example.trabalhojsonaula.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhojsonaula.R;
import com.example.trabalhojsonaula.model.Photos;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {


    private List<Photos> dados3;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PhotosAdapter(List<Photos> posts) {
        this.dados3 = posts;
    }

    @NonNull
    @Override
    public PhotosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photos_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //coloca os dados dentro do ViwHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photos photos = dados3.get(position);

        TextView tv = holder.view.findViewById(R.id.photoId);
        tv.setText(photos.getId());

        tv = holder.view.findViewById(R.id.tituloPhotos);
        tv.setText(photos.getTitle());



       // tv = holder.view.findViewById(R.id.bodyPosts);
        //tv.setText(photos.getUrl());




        //TextView tv2 = holder.view.findViewById(R.id.tvTodoTitulo2);
        //tv2.setText(dados.get(position).getId());

        //TextView tv2 = holder.view.findViewById(R.id.tvTodoTitulo);
        //tv2.setText(dados.get(position).getTitle());
        //View tv1 = holder.view.findViewById(R.id.tNumber);
        //tv1.setId(dados.get(position).getUser_id());


    }




    @Override
    public int getItemCount() {

        return dados3.size();
    }


}
