package com.example.dailybucket;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private MenuItem menuItem;
    private DrawerLayout drawerLayout;

    @Override
    public void onCreate(Bundle savedInstanseState) {
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_main);

        if (!AuthenticationManager.isLoggedIn()) {
            Intent redirectToLoginActivityIntent = new Intent(this, LoginActivity.class);
            startActivity(redirectToLoginActivityIntent);
        }

        Map<String, String> usageMap = this.getUsageInTimeOfCurrentApp();

        for (String pkgName : usageMap.keySet()) {
            Log.d(this.getClass().getCanonicalName(), pkgName);
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_home);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void openActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public Map<String, String> getUsageInTimeOfCurrentApp() {
        Map<String, String> usageMap = new HashMap<>();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Log.d(getClass().getCanonicalName(), "!@#$ if kezdet");
            // intentionally using string value as Context.USAGE_STATS_SERVICE was
            // strangely only added in API 22 (LOLLIPOP_MR1)
            @SuppressWarnings("WrongConstant")
            UsageStatsManager usm = (UsageStatsManager) getSystemService("usagestats");
            long time = System.currentTimeMillis();
            List<UsageStats> appList = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY,
                    time - 1000 * 1000, time);

            Log.d(getClass().getCanonicalName(), "!@#$ " + appList.size());
            if (appList != null && appList.size() > 0) {
                SortedMap<Long, UsageStats> mySortedMap = new TreeMap<>();


                for (UsageStats usageStats : appList) {
                    mySortedMap.put(usageStats.getLastTimeUsed(),
                            usageStats);
                    usageMap.put(usageStats.getPackageName(), "" + usageStats.getTotalTimeInForeground());
                }
            }
        }
        return usageMap;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        Log.d(getClass().getCanonicalName(), drawerLayout + "");

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_profile:
                fragment = new UserProfileFragment();
                break;
            case R.id.navigation_search:
                fragment = new SearchFragment();
                break;
            case R.id.navigation_options:
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                    drawerLayout.bringToFront();
                }
                break;
            case R.id.navigation_tasks:
                fragment = new TasksFragment();
                break;

        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    public class PostFragment extends Fragment {
        RecyclerView mRecyclerView;
        //List<Post> mPostList;
        int[]mPostList;
        public PostFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_main, container, false);
        }

        @Nullable
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            mRecyclerView = getView().findViewById(R.id.feed);
            GridLayoutManager mGridLayoutManager;
            mGridLayoutManager = new GridLayoutManager(getContext(), 3);
            mRecyclerView.setLayoutManager(mGridLayoutManager);
            mPostList = new int[]{R.drawable.clujnapoca, R.drawable.bucharest, R.drawable.budapest, R.drawable.london, R.drawable.seoul, R.drawable.sydney,
                    R.drawable.tokyo, R.drawable.la};
            //mPostList.get(0).setPostImage(R.drawable.clujnapoca);
            //mPostList.get(1).setPostImage(R.drawable.bucharest);


            //List<Post> valtozo = new ArrayList<>();
            //valtozo.add(new Post());
            PostAdapter myAdapter = new PostAdapter(getContext(),mPostList);
            mRecyclerView.setAdapter(myAdapter);
        }
    }
}