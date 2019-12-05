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
    private List<Post> posts;


    public MyPostAdapter(Context mContext, List<Post> posts) {
        this.mContext = mContext;
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
        holder.bind(posts.get(position)); // na legalabb itt6

        holder.postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("Image",posts.get(holder.getAdapterPosition())); // nice megrosszabb lett 4444466 miert kell a get oda??
                mContext.startActivity(mIntent);//mi a szep elet????  mit csinalna ez pontosabban? feltolti az activityt psotokkal azt hiszem
            }
        });
    }
//kocsog ez a programozas :((444444444
    // kell menjek meg irok este szia\
    //TED BE TOLTENI TESSS itt mi a foss van ?? amugy ennek nincs loginja?? ez valami mas i guess ennek kellene legyen
    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class MyPostViewHolder extends RecyclerView.ViewHolder {

        private ImageView postImage;
        private TextView postTitle;

        private MyPostViewHolder(View itemView) {
            super(itemView);

            postImage = itemView.findViewById(R.id.mypost);
            postTitle = itemView.findViewById(R.id.postTitle);
        }//meg ezt FERi fent vanvan

        private void bind(Post post) {
            postImage.setImageResource(post.getPostImage());
            postTitle.setText(post.getPostTitle());
        }//ezt
    }
}