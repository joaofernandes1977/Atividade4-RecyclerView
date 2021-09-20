package com.example.trabalhojsonaula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.trabalhojsonaula.adapters.TodoAdapter;
import com.example.trabalhojsonaula.model.Todo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class TodosActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener {
    private List<Todo> todos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        buscaJason();
    }
    private void buscaJason(){
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos",
                null, (Response.Listener<JSONArray>) this, this);
        queue.add(requisicao);
    }


    @Override
    public void onResponse(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scroll);
        //LinearLayout ll = findViewById(R.id.leiauteVertical);
        todos.clear();
        //ed.setText(response.toString());
        try {
            //for (int x = 0; x < 10; x++){
            for (int i = 0; i < response.length(); i++) {
                todos.add(new Todo(response.getJSONObject(i)));
            }
            //}
            RecyclerView rv = findViewById(R.id.rvTodos);
            TodoAdapter adapter = new TodoAdapter(todos);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            LinearLayoutManager llm1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.HORIZONTAL);

            rv.setLayoutManager(sglm);
            rv.setAdapter(adapter);

          /*  String txt = "";
            //for (int i = 0; i < 10; i++){
            for ( Todo td : todos){
                Button btn = new Button(this);
                btn.setText("ID "+td.getId());
                txt += td.toString();
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), DetalheTodoctivity.class);
                        //intent.putExtra("id", td.getId());
                        //intent.putExtra("titulo", td.getTitle());

                        intent.putExtra( "obj",(Parcelable) td);
                        startActivity(intent);
                    }
                });
                ll.addView(btn);
            }
           // }
*/
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "deu certo" + error.getMessage(), Toast.LENGTH_LONG).show();


    }
}