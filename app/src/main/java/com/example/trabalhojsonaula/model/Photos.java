package com.example.trabalhojsonaula.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Photos implements Parcelable {
    //todos
    private String id;
    private String title;
    private String url;

    //users

    public Photos(String id, String title, String url){
        this.id = id;
        this.title = title;
        this.url = url;

    }
    public Photos(JSONObject json) {
        super();
        try {
            this.id = json.getString("id");
            this.title = json.getString("title");
            this.url = json.getString("url");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Photos(Parcel in) {
        id = in.readString();
        title = in.readString();
        url = in.readString();
    }

    public static final Creator<Photos> CREATOR = new Creator<Photos>() {
        @Override
        public Photos createFromParcel(Parcel in) {
            return new Photos(in);
        }

        @Override
        public Photos[] newArray(int size) {
            return new Photos[size];
        }
    };

    @Override
    public String toString(){
        return "id: "+id+"\n"+
                "Id usuario: "+url+"\n"+
                "Titulo:" + title+"\n-------------------\n";

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photos that = (Photos) o;
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
        parcel.writeString(this.title);
        parcel.writeString(this.url);
    }
}
