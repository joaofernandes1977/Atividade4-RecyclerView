package com.example.trabalhojsonaula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaResultado extends AppCompatActivity {


        private Button chamada1;
        //private Button chamada2;
        //private Button chamada3;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tela_resultado);

            IniciarComponentes();
            chamada1 = findViewById(R.id.todos1);
            chamada1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(TelaResultado.this, TodosActivity.class);
                    startActivity(intent);
                }
            }
            );
            chamada1 =findViewById(R.id.usuarios);
            chamada1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(TelaResultado.this, UserActivity.class);
                    startActivity(intent);
                }
            } );
            chamada1 = findViewById(R.id.posts);
            chamada1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(TelaResultado.this, PostsActivity.class);
                    startActivity(intent);
                }
            } );
            chamada1 = findViewById(R.id.photos);
            chamada1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(TelaResultado.this, PhotosActivity.class);
                    startActivity(intent);
                }
            } );
            chamada1 = findViewById(R.id.star);
            chamada1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(TelaResultado.this, StarActivity.class);
                    startActivity(intent);
                }
            } );

        }
        private void IniciarComponentes(){
            //chamada1 = findViewById(R.id.todos);
            //chamada1 = findViewById(R.id.usuarios);
            //chamada1 = findViewById(R.id.posts);
        }


    }

