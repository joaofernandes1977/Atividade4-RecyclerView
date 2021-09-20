package com.example.trabalhojsonaula.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhojsonaula.R;
import com.example.trabalhojsonaula.model.Todo;
import com.example.trabalhojsonaula.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    private List<User> dados1;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public UserAdapter(List<User> users) {
        this.dados1 = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_layout, parent, false);
        return new ViewHolder(view);
    }



    @Override
    //coloca os dados dentro do ViwHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = dados1.get(position);

        TextView tv = holder.view.findViewById(R.id.tvTodoTitulo);
        tv.setText(user.getName());

        TextView tv2 = holder.view.findViewById(R.id.tvTodoTitulo2);
        tv2.setText(user.getEmail());

        TextView tv3 = holder.view.findViewById(R.id.userName);
        tv3.setText(user.getUsername());

        //TextView tv2 = holder.view.findViewById(R.id.tvTodoTitulo);
        //tv2.setText(dados.get(position).getTitle());
        //View tv1 = holder.view.findViewById(R.id.tNumber);
        //tv1.setId(dados.get(position).getUser_id());


    }


    @Override
    public int getItemCount() {

        return dados1.size();
    }


}
