package com.example.trabalhojsonaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class PostsActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/posts",
                null, (Response.Listener<JSONArray>) this, this);
        queue.add(requisicao);
    }



    @Override
    public void onResponse(JSONArray response) {
        EditText ed = findViewById(R.id.posts);
        ed.setText(response.toString());
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"deu certo"+error.getMessage(),Toast.LENGTH_LONG).show();



    }
}