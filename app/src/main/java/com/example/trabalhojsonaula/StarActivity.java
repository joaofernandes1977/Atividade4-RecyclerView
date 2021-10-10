package com.example.trabalhojsonaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class StarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        ImageView imageView = findViewById(R.id.starVw);
        String url = "https://waie.com.br/starwars/Anakin_Skywalker_RotS.png";
        Picasso.get().load(url).into(imageView);
    }
}