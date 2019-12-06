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

public class PostAdapter extends Adapter<PostAdapter.PostViewHolder> {

    private Context mContext;
    //private List<Post> posts;
    private int[] posts;
    private String[] postTitles;
    private String[] postBodies;

    public PostAdapter(Context mContext, int[] posts, String[] postTitles, String[] postBodies) {
        this.mContext = mContext;
        this.postBodies = postBodies;
        this.postTitles = postTitles;
        this.posts = posts;
    }

    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_items,
                parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PostViewHolder holder, int position) {
        holder.bind(posts[position], postTitles[position], postBodies[position]); // na legalabb itt6

        holder.postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("Image", posts[holder.getAdapterPosition()]);
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.length;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        private ImageView postImage;
        private TextView postTitleView;
        private TextView postBodyView;


        private PostViewHolder(View itemView) {
            super(itemView);
            postImage = itemView.findViewById(R.id.post_image);
            postTitleView = itemView.findViewById(R.id.post_title);
            postBodyView = itemView.findViewById(R.id.post_post);
        }

        private void bind(int postImageId, String postTitle, String postBody) {
            postImage.setImageResource(postImageId);
            postTitleView.setText(postTitle);
            postBodyView.setText(postBody);
        }
    }
}