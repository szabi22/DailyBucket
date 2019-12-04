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

public class UserProfileFragment extends Fragment {
    public UserProfileFragment() {
    }
    RecyclerView mRecyclerView;
    int[] mPostList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.userprofile, container, false);
    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        mRecyclerView = mRecyclerView.findViewById(R.id.user_recyclerview);
        GridLayoutManager mGridLayoutManager;
        mGridLayoutManager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mPostList = new int[]{R.drawable.clujnapoca, R.drawable.bucharest, R.drawable.budapest, R.drawable.london, R.drawable.seoul, R.drawable.sydney,
                R.drawable.tokyo, R.drawable.la};

        //mPostList = new int[0];

        MyPostAdapter myAdapter = new MyPostAdapter(getContext(), mPostList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
