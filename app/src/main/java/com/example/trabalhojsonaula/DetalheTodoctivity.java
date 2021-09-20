package com.example.trabalhojsonaula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.trabalhojsonaula.model.Todo;

public class DetalheTodoctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_todoctivity);
        Intent intent = getIntent();
        TextView tv = findViewById(R.id.tvId);
        //int i = intent.getIntExtra("id", -1);
        Todo todo = intent.getParcelableExtra("obj");
        tv.setText(""+todo.getId());
        //tv.setText(intent.getIntExtra("id", -1));
        tv = findViewById(R.id.tvTitulo);
        tv.setText(todo.getTitle());
    }
}