package com.example.trabalhojsonaula.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Todo implements Parcelable {
    //todos
    private String id;
    private  String user_id;
    private String title;
    private boolean completed;
    //users



    public Todo(String id, String user_id, String title, boolean completed, String name, String username, String email){
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.completed = completed;


    }
    public Todo(JSONObject json) {
        super();
        try {
            this.id = json.getString("id");
            this.user_id = json.getString("userId");
            this.title = json.getString("title");
            this.completed = json.getBoolean("completed");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Todo(Parcel in) {
        id = in.readString();
        user_id = in.readString();
        title = in.readString();
        completed = in.readByte() != 0;


    }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    @Override
    public String toString(){
        return "id: "+id+"\n"+
                "Id usuario: "+user_id+"\n"+
                "Titulo:" + title+"\n-------------------\n";

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }


    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo that = (Todo) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.user_id);
        parcel.writeString(this.title);
        parcel.writeBoolean(this.completed);


    }
}

