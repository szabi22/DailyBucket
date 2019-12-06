package com.example.dailybucket;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dailybucket.R;

public class DetailActivity extends AppCompatActivity {

    ImageView mPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        mPost = findViewById(R.id.mypost_image);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mPost.setImageResource(mBundle.getInt("Image"));
        }
    }
}
