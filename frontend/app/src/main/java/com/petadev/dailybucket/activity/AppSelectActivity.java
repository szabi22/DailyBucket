package com.petadev.dailybucket.activity;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.petadev.dailybucket.R;
import com.petadev.dailybucket.entity.AppData;
import com.petadev.dailybucket.list_adapter.AppSelectListAdapter;
import com.petadev.dailybucket.logic.AppManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppSelectActivity extends AppCompatActivity {
    private AppManager appManager;
    private Map<String, Boolean> selectedMap = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appselect_activity);

        requestUsageStatsPermission();

        ListView appSelectListView = findViewById(R.id.app_select_list);

        this.appManager = new AppManager(this);
        List<AppData> appUsageStats = this.appManager.getAppUsageStats();

        for (AppData appUsageStat : appUsageStats) {
            selectedMap.put(appUsageStat.getCanonicalName(), false);
        }

        AppSelectListAdapter appSelectListAdapter = new AppSelectListAdapter(this, appUsageStats, selectedMap);
        appSelectListView.setAdapter(appSelectListAdapter);
    }

    public void onNextClick(final View view) {
        Intent intent = new Intent(this, TimeLimitActivity.class);
        intent.putExtra("selectedMap", new Gson().toJson(selectedMap));
        intent.putExtra("usageStats", new Gson().toJson(this.appManager.getAppUsageStats()));
        startActivity(intent);
    }

    private void requestUsageStatsPermission() {
        if (!areUsageStatsPermitted()) {
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            startActivity(intent);
        }
    }

    private boolean areUsageStatsPermitted() {
        try {
            PackageManager packageManager = this.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.getPackageName(), 0);
            AppOpsManager appOpsManager = (AppOpsManager) this.getSystemService(Context.APP_OPS_SERVICE);
            int mode = appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, applicationInfo.uid, applicationInfo.packageName);
            return (mode == AppOpsManager.MODE_ALLOWED);

        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
