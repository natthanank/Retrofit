package com.example.natthanan.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by natthanan on 3/14/2018.
 */

public class Post {

    @SerializedName("userID")
    private long userId;
    @SerializedName("id")
    private long id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public Post(String title, String body) {
        userId = 1000;
        id = 1000;
        this.title = title;
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
