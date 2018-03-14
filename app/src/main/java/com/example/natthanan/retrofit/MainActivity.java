package com.example.natthanan.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.natthanan.retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText title, body;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ApiInterface service = ApiClient.getClient().create(ApiInterface.class);

        // Get
        Call<Post> call = service.findPost("20");
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                Log.i("post_title", post.getTitle());
                Log.i("post_body", post.getBody());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("result", "error");
            }
        });

        Call<List<Post>> postList = service.findAllPosts();
        postList.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                for (Post post: posts) {
                    Log.i("posts", post.getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("result", "error");
            }
        });

        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleString = title.getText().toString();
                String bodyString = body.getText().toString();

                // Post
                Post newPost = new Post(titleString, bodyString);
                Call<Post> newpost = service.createPost(newPost);
                newpost.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Log.i("created", Long.toString(response.body().getId()));
                        Log.i("created", Long.toString(response.body().getUserId()));
                        Log.i("created", response.body().getTitle());
                        Log.i("created", response.body().getBody());
                        Log.i("created", Boolean.toString(response.isSuccessful()));
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {

                    }
                });
            }
        });

    }
}
