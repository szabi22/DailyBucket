package com.example.dailybucket;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.MyPostViewHolder> {

    private Context mContext;
    private int[] mPost;

    public class MyPostViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPost;

        private MyPostViewHolder(View itemView) {
            super(itemView);

            mPost = itemView.findViewById(R.id.mypost);
        }

        private void bind(int postImage) {
            mPost.setImageResource(postImage);
        }
    }

    public MyPostAdapter(Context mContext, int[] mPostList) {
        this.mContext = mContext;
        this.mPost = mPostList;

    }

    @Override
    public MyPostAdapter.MyPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myposts_item,
                parent, false);
        return new MyPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyPostViewHolder holder, int position) {
        holder.bind(mPost[position]);

        holder.mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("Image", mPost[holder.getAdapterPosition()]);
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPost.length;
    }
}