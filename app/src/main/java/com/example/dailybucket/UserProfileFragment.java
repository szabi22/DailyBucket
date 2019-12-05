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

        //mPostList = new int[0]; /// s ez nem kell ez csak ures volt, ehelyett kell a drawables tomb
        // itt kellene betenni a kepeket a userprofilehoz
        // a post is recyclerviewvel mukodik? ugy tudom pill vagy nem is ez mas gep whoops
        mPostList = new int[]{R.drawable.clujnapoca, R.drawable.bucharest, R.drawable.budapest, R.drawable.london, R.drawable.seoul, R.drawable.sydney,
                R.drawable.tokyo, R.drawable.la}; /// igy kell kepeket, s be kell oket tenni a darawableba

        mCityNameList = new String[]{"Cluj-Napoca", "Bucharest", "Budapest", "London", "Seoul", "Sydney", "Tokyo", "Los Angeles"};
        /// s ha a posthoz akatok szoveget az igy

        // meg itt vagytok? persze
        //oh hi , Szabi here hello. na akkor ez megvann? be kell tenni a drawableba a kepeket amiket kuldtem es ki
        //aztan a cimmet be kell helyetesiteni azok helyet ugye reni??
        // aha
        //okes amugy avval a mypost adapterrel nem tudod mi a kaki van??
        List<Post> valtozo = new ArrayList<Post>;
        valtozo.add(new Post());
        MyPostAdapter myAdapter = new MyPostAdapter(getContext(), valtozo);
        mRecyclerView.setAdapter(myAdapter);
    }
}
