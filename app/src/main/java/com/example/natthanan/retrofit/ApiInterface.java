package com.example.natthanan.retrofit;

import com.example.natthanan.retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by natthanan on 3/14/2018.
 */

public interface ApiInterface {

    @GET("posts/")
    Call<List<Post>> findAllPosts();

    @GET("posts/{id}")
    Call<Post> findPost(@Path("id") String id);

    @POST("posts/")
    Call<Post> createPost(@Body Post post);
}
