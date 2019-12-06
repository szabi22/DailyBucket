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
    int[] mMyPostList;

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
        mMyPostList = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6,
                R.drawable.a7, R.drawable.a8};


        MyPostAdapter myAdapter = new MyPostAdapter(getContext(), mMyPostList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
