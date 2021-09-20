package com.example.trabalhojsonaula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.trabalhojsonaula.adapters.PhotosAdapter;
import com.example.trabalhojsonaula.adapters.TodoAdapter;
import com.example.trabalhojsonaula.adapters.UserAdapter;
import com.example.trabalhojsonaula.model.Photos;
import com.example.trabalhojsonaula.model.Todo;
import com.example.trabalhojsonaula.model.User;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PhotosActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    private List<Photos> photos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        buscaJason();


    }
    private void buscaJason(){
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/photos",
                null, (Response.Listener<JSONArray>) this, this);
        queue.add(requisicao);
    }


    @Override
    public void onResponse(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scroll);
        //LinearLayout ll = findViewById(R.id.leiauteVertical);
        photos.clear();
        //ed.setText(response.toString());
        try {
            //for (int x = 0; x < 10; x++){
            for (int i = 0; i < response.length(); i++) {
                photos.add(new Photos(response.getJSONObject(i)));
            }
            //}

            RecyclerView rv = findViewById(R.id.photosRw);
            PhotosAdapter adapter = new PhotosAdapter(photos);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            LinearLayoutManager llm1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);

            rv.setLayoutManager(sglm);
            rv.setAdapter(adapter);

            //ImageView iv = findViewById(R.id.imageView);
            //Picasso.get().load("https://via.placeholder.com/150/92c952").into(iv);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "deu certo" + error.getMessage(), Toast.LENGTH_LONG).show();


    }
}

