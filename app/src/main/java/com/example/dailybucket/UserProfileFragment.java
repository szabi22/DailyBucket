package com.example.dailybucket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserProfileFragment extends Fragment {
    RecyclerView mRecyclerView;
    //List<Post> mPostList;
    int[]mPostList;
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
        mRecyclerView = getView().findViewById(R.id.user_recyclerview);
        GridLayoutManager mGridLayoutManager;
        mGridLayoutManager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        //mPostList = new int[0]; /// s ez nem kell ez csak ures volt, ehelyett kell a drawables tomb
        // itt kellene betenni a kepeket a userprofilehoz
        // a post is recyclerviewvel mukodik? ugy tudom pill vagy nem is ez mas gep whoops
        mPostList = new int[]{R.drawable.clujnapoca, R.drawable.bucharest, R.drawable.budapest, R.drawable.london, R.drawable.seoul, R.drawable.sydney,
                R.drawable.tokyo, R.drawable.la}; /// igy kell kepeket, s be kell oket tenni a darawableba
        //mPostList.get(0).setPostImage(R.drawable.clujnapoca);
        //mPostList.get(1).setPostImage(R.drawable.bucharest);


        //List<Post> valtozo = new ArrayList<>();
        //valtozo.add(new Post());
        MyPostAdapter myAdapter = new MyPostAdapter(getContext(),mPostList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
