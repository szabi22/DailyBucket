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
        int[] mPostList = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6,
                R.drawable.a7, R.drawable.a8};

        String[] postTitleList = new String[]{
                "Sátorozz az osztályban",
                "Lesd meg a naplementét",
                "Tábortűz",
                "Twister délután",
                "Probalj ki egy új stílust",
                "Barátkozz meg egy külföldivel",
                "Selfiz egyet",
                "Billiárd est"
        };

        String[] postBodyList = new String[]{
                "Hűha! Majdnem a magaviseletünk bánta",
                "Életem legszebb naplementéje",
                "Éneklés a tábortűz körül. Remek volt!",
                "Nyaktekerészeti mellfekvenc",
                "Ezentúl ilyen szemüvegeket fogok horDANI",
                "Konicsivá",
                "hmmm",
                "hole in one"
        };

        PostAdapter myAdapter = new PostAdapter(getContext(), mPostList, postTitleList, postBodyList);
        mRecyclerView.setAdapter(myAdapter);
    }
}