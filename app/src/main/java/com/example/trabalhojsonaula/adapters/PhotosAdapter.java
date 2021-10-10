package com.example.trabalhojsonaula.adapters;

import static com.example.trabalhojsonaula.R.layout.photos_layout;

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

        TextView img = holder.view.findViewById(R.id.urlCaminho);
        img.setText(photos.getUrl());

        ImageView iv = holder.view.findViewById(R.id.imagePhotos);
        Picasso.get().load(photos.getUrl()).into(iv);

        //PASSANDO A MESMA URL "IMAGEM"
        //Picasso.get().load("https://loja.uniritteronline.com.br/media/logo/stores/35/UNIRITTER.png").into(iv);

        //PASSANDO AS URLs DIFERENTES OBS: NÃO DA ERRO QUANDO COMPILA SO NÃO APARECE NENHUMA IMAGEM
        //ImageView iv = holder.view.findViewById(R.id.imagePhotos);
        //Picasso.get().load(String.valueOf(img)).into(iv);


    }


    @Override
    public int getItemCount() {

        return dados3.size();
    }


}
