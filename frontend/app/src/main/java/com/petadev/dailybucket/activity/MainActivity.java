package com.petadev.dailybucket.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.petadev.dailybucket.R;
import com.petadev.dailybucket.entity.Post;
import com.petadev.dailybucket.entity.PostType;
import com.petadev.dailybucket.entity.User;
import com.petadev.dailybucket.list_adapter.PostListAdapter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ListView postList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        this.postList = findViewById(R.id.post_list);

        User user = new User(
                "alphazoner",
                "Albert",
                "Ferencz",
                "https://picsum.photos/500",
                new Timestamp(SystemClock.currentThreadTimeMillis())
        );

        Post post1 = new Post(
                user,
                "This is a post",
                "My post is a very nice post!",
               "https://picsum.photos/500",
                PostType.IMAGE,
                new Timestamp(SystemClock.currentThreadTimeMillis())
        );

        Post post2 = new Post(
                user,
                "This is a second post",
                "My post is also very nice post!",
                "https://picsum.photos/500",
                PostType.SIMPLE,
                new Timestamp(SystemClock.currentThreadTimeMillis())
        );

        PostListAdapter postListAdapter = new PostListAdapter(this, Arrays.asList(post1, post2));
        this.postList.setAdapter(postListAdapter);
    }
}
