package com.petadev.dailybucket.list_adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.petadev.dailybucket.R;
import com.petadev.dailybucket.RetrievePostFeedTask;
import com.petadev.dailybucket.entity.Post;
import com.petadev.dailybucket.entity.PostType;

import java.util.List;

public class PostListAdapter extends ArrayAdapter<Post> {
    private final Activity activity;
    private final List<Post> posts;

    public PostListAdapter(final @NonNull Activity activity, final List<Post> posts) {
        super(activity, R.layout.appselect_list_entry, posts);
        this.activity = activity;
        this.posts = posts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.post_list_entry, parent, false);

            viewHolder.postedAt = convertView.findViewById(R.id.post_date);
            viewHolder.fullName = convertView.findViewById(R.id.user_full_name);
            viewHolder.postTitle = convertView.findViewById(R.id.post_title);
            viewHolder.postBody = convertView.findViewById(R.id.post_body);
            viewHolder.postImage = convertView.findViewById(R.id.post_image);
            viewHolder.profilePicture = convertView.findViewById(R.id.user_profile_picture);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Post post = this.posts.get(position);

        viewHolder.postedAt.setText(post.getPostedAt().toString());
        viewHolder.fullName.setText(String.format("%s %s", post.getUser().getFirstName(), post.getUser().getLastName()));
        viewHolder.postTitle.setText(post.getHeader());
        viewHolder.postBody.setText(post.getBody());

        if (post.getPostType() == PostType.IMAGE) {
            new RetrievePostFeedTask(drawable -> viewHolder.postImage.setImageDrawable(drawable)).execute(post.getPictureUrl());
        } else {
            viewHolder.postImage.setVisibility(View.INVISIBLE);
        }
        new RetrievePostFeedTask(drawable -> viewHolder.profilePicture.setImageDrawable(drawable)).execute(post.getUser().getProfilePicture());

        return convertView;
    }

    private static class ViewHolder {
        private TextView postedAt;
        private TextView fullName;
        private TextView postTitle;
        private TextView postBody;
        private ImageView postImage;
        private ImageView profilePicture;
    }
}
