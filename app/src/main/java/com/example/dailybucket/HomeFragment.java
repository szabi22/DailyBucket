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

/**
 * Created by Belal on 1/23/2018.
 */

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mRecyclerView = getView().findViewById(R.id.feed_recycler);
        GridLayoutManager mGridLayoutManager;
        mGridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        int[] mPostList = new int[]{R.drawable.clujnapoca, R.drawable.bucharest, R.drawable.budapest, R.drawable.london, R.drawable.seoul, R.drawable.sydney,
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

        MyPostAdapter myAdapter = new MyPostAdapter(getContext(), mPostList, postTitleList, postBodyList);
        mRecyclerView.setAdapter(myAdapter);
    }
}