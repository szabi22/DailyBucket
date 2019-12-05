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

public class UserProfileFragment extends Fragment {
    RecyclerView mRecyclerView;
    int[] mPostList;
    public UserProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPostList = new int[]{R.drawable.profile2};

        return inflater.inflate(R.layout.userprofile, container, false);
    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mRecyclerView = getView().findViewById(R.id.user_recyclerview);
        GridLayoutManager mGridLayoutManager;
        mGridLayoutManager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        //mPostList = new int[0];
        List<Post> valtozo = new ArrayList<Post>;
        valtozo.add(new Post());
        MyPostAdapter myAdapter = new MyPostAdapter(getContext(), valtozo);
        mRecyclerView.setAdapter(myAdapter);
    }
}
