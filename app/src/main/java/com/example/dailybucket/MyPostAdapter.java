package com.example.dailybucket;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MyPostAdapter extends Adapter<MyPostAdapter.MyPostViewHolder> {

    private Context mContext;
    //private List<Post> posts;
    private int[] posts;
    private String[] postTitles;
    private String[] postBodies;

    public MyPostAdapter(Context mContext, int[] posts, String[] postTitles, String[] postBodies) {
        this.mContext = mContext;
        this.postBodies = postBodies;
        this.postTitles = postTitles;
        this.posts = posts;
    }

    @Override
    public MyPostAdapter.MyPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myposts_item,
                parent, false);
        return new MyPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyPostViewHolder holder, int position) {
        holder.bind(posts[position], postTitles[position], postBodies[position]); // na legalabb itt6

        holder.postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("Image",posts[holder.getAdapterPosition()]);
                mContext.startActivity(mIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return posts.length;
    }

    public class MyPostViewHolder extends RecyclerView.ViewHolder {

        private ImageView postImage;
        private TextView postTitleView;
        private TextView postBodyView;


        private MyPostViewHolder(View itemView) {
            super(itemView);
            postImage = itemView.findViewById(R.id.mypost);
            postTitleView = itemView.findViewById(R.id.mypost_title);
            postBodyView = itemView.findViewById(R.id.mypost_post);
        }

        private void bind(int postImageId, String postTitle, String postBody) {
            postImage.setImageResource(postImageId);
            postTitleView.setText(postTitle);
            postBodyView.setText(postBody);
        }
    }
}