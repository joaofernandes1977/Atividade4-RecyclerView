package com.example.trabalhojsonaula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicio extends AppCompatActivity {


    private Button chamada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);

        IniciarComponentes();

    chamada.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(TelaInicio.this, TelaResultado.class);
            startActivity(intent);
        }
    });

    }
    private void IniciarComponentes(){
        chamada = findViewById(R.id.login);
    }
}