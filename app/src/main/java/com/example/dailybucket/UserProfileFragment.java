package com.example.dailybucket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UserProfileFragment extends Fragment {
    RecyclerView mRecyclerView;
    //List<Post> mPostList;
    int[] mPostList;

    public UserProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.userprofile, container, false);
    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView profilePicture = getView().findViewById(R.id.imageView5);
        EditText userName = getView().findViewById(R.id.user_name_profile);


        userName.setText(AuthenticationManager.userName);
        profilePicture.setImageResource(R.drawable.profile2);

        mRecyclerView = getView().findViewById(R.id.user_recyclerview);
        GridLayoutManager mGridLayoutManager;
        mGridLayoutManager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mPostList = new int[]{R.drawable.clujnapoca, R.drawable.bucharest, R.drawable.budapest, R.drawable.london, R.drawable.seoul, R.drawable.sydney,
                R.drawable.tokyo, R.drawable.la};

        String[] postTitleList = new String[]{
                "This is a post!",
                "This is a second post!",
                "This is a post again!",
                "Wow, such a wonderful post!",
                "Mom, I'm on facebook!",
                "This is a post again!",
                "This is a post again!",
                "This is a post again!"
        };

        String[] postBodyList = new String[]{
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices laoreet ipsum, in tempus nulla gravida sit amet.",
                "Aliquam rhoncus magna nec mattis fermentum. In non porta justo, in congue mauris.",
                "Nullam sit amet lectus sed tellus dapibus convallis. Fusce malesuada tellus vitae libero pharetra, sed mollis diam consequat.",
                "Phasellus in cursus erat, quis pulvinar enim. Quisque imperdiet nunc sed mauris dictum, non rutrum urna vehicula.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultrices laoreet ipsum, in tempus nulla gravida sit amet.",
                "Aliquam rhoncus magna nec mattis fermentum. In non porta justo, in congue mauris.",
                "Nullam sit amet lectus sed tellus dapibus convallis. Fusce malesuada tellus vitae libero pharetra, sed mollis diam consequat.",
                "Phasellus in cursus erat, quis pulvinar enim. Quisque imperdiet nunc sed mauris dictum, non rutrum urna vehicula."
        };
        //mPostList.get(0).setPostImage(R.drawable.clujnapoca);
        //mPostList.get(1).setPostImage(R.drawable.bucharest);


        //List<Post> valtozo = new ArrayList<>();
        //valtozo.add(new Post());
        MyPostAdapter myAdapter = new MyPostAdapter(getContext(), mPostList, postTitleList, postBodyList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
