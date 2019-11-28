package com.example.dailybucket;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    private final Object MenuItem
    BottomAppBar bar = findViewById(R.id.bar);

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

    BottomAppBar bar = findViewById(R.id.bar);

bar.setOnMenuItemClickListener(new
    BottomAppBar bar = findViewById(R.id.bar);)

    public MainActivity(Object menuItem) {
        MenuItem = menuItem;
    }

    MainActivity() {

        @Override
        public boolean onMenuItemClick (android.view.MenuItem) Object Object item;
        Object itcem;
        item){
            // Handle actions based on the menu item
            boolean b = true;

            return b;
        }
    }

    setSupportActionBar(bar);
bar.setNavigationOnClickListener(new

    OnClickListener() {
        @Override
        public void onClick (View v){
            // Handle the navigation click by showing a BottomDrawer etc.
        }
    })
}