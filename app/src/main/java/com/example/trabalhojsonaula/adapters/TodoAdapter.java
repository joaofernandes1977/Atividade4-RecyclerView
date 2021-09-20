package com.example.trabalhojsonaula.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhojsonaula.R;
import com.example.trabalhojsonaula.model.Todo;
import com.example.trabalhojsonaula.model.User;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {


    private List<Todo> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public TodoAdapter(List<Todo> todos) {
        this.dados = todos;
    }

    @NonNull
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //coloca os dados dentro do ViwHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Todo todo = dados.get(position);

        TextView tv = holder.view.findViewById(R.id.tvTodoTitulo);
        tv.setText(todo.getTitle());

        tv = holder.view.findViewById(R.id.tvTodoTitulo2);
        tv.setText(""+todo.getUser_id());

        Switch sw = holder.view.findViewById(R.id.swTodoComplete);
        sw.setChecked((todo.isCompleted()));

        tv = holder.view.findViewById(R.id.userName);
        tv.setText(""+todo.getId());



        //TextView tv2 = holder.view.findViewById(R.id.tvTodoTitulo2);
        //tv2.setText(dados.get(position).getId());

        //TextView tv2 = holder.view.findViewById(R.id.tvTodoTitulo);
        //tv2.setText(dados.get(position).getTitle());
        //View tv1 = holder.view.findViewById(R.id.tNumber);
        //tv1.setId(dados.get(position).getUser_id());


    }


    @Override
    public int getItemCount() {

        return dados.size();
    }


}
