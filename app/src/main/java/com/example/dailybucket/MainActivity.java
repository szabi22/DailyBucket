package com.example.dailybucket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanseState) {
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_main);

        String currentApp = "";

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
                    if (usageStats.getPackageName().toLowerCase().contains("facebook")) {
                        Log.d(getClass().getCanonicalName(), "" + usageStats.getPackageName() + " " + usageStats.getTotalTimeInForeground() + "" + usageStats.);
                    }
                }

                if (mySortedMap != null && !mySortedMap.isEmpty()) {
                    currentApp = mySortedMap.get(
                            mySortedMap.lastKey()).getPackageName();
                }
            }
        } else {
            ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> tasks = am
                    .getRunningAppProcesses();
            currentApp = tasks.get(0).processName;
        }

        Log.d(this.getClass().getCanonicalName(), "!@#$% " + currentApp);
    }


    public void openActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
