package com.example.trabalhojsonaula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.trabalhojsonaula.adapters.PostsAdapter;
import com.example.trabalhojsonaula.adapters.UserAdapter;
import com.example.trabalhojsonaula.model.Posts;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PostsActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    private List<Posts> posts = new ArrayList<>();
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
        posts.clear();
        //ed.setText(response.toString());
        try {
            //for (int x = 0; x < 10; x++){
            for (int i = 0; i < response.length(); i++) {
                posts.add(new Posts(response.getJSONObject(i)));
            }
            //}
            RecyclerView rv = findViewById(R.id.posts);
            PostsAdapter adapter = new PostsAdapter(posts);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            LinearLayoutManager llm1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);

            rv.setLayoutManager(sglm);
            rv.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"deu certo"+error.getMessage(),Toast.LENGTH_LONG).show();



    }
}