package com.petadev.dailybucket.logic;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.petadev.dailybucket.entity.AppData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppManager {
    private final Context context;
    private final UsageStatsManager usageStatsManager;
    private final Calendar today;

    public AppManager(final Context context) {
        this.context = context;
        this.usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
        this.today = Calendar.getInstance();
        this.today.set(Calendar.HOUR, 0);
        this.today.set(Calendar.SECOND, 0);
        this.today.set(Calendar.MINUTE, 0);
        this.today.set(Calendar.MILLISECOND, 0);
    }

    public List<ApplicationInfo> getAllApps() {
        return this.context.getPackageManager().getInstalledApplications(0);
    }

    public List<ApplicationInfo> getAllInstalledApps() {
        List<ApplicationInfo> installedApps = new ArrayList<>();

        for (ApplicationInfo anApp : this.getAllApps()) {
            if (isExternallyInstalledApp(anApp)) {
                installedApps.add(anApp);
            }
        }

        return installedApps;
    }

    public String getCanonicalAppName(final ApplicationInfo applicationInfo) {
        return (String) this.context.getPackageManager().getApplicationLabel(applicationInfo);
    }

    public Drawable getAppIcon(final ApplicationInfo applicationInfo) {
        return this.context.getPackageManager().getApplicationIcon(applicationInfo);
    }

    public List<AppData> getAppUsageStats() {
        List<AppData> appDataList = new ArrayList<>();
        Map<String, ApplicationInfo> allInstalledAppsMap = new HashMap<>();

        for (ApplicationInfo installedApp: this.getAllInstalledApps()) {
            allInstalledAppsMap.put(installedApp.packageName, installedApp);
        }


        Log.d(this.getClass().getCanonicalName(), Calendar.getInstance().getTimeInMillis() - 1000 * 60 * 60 * 2 + " " + Calendar.getInstance().getTimeInMillis());

        for (UsageStats usageStats: this.usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, Calendar.getInstance().getTimeInMillis() - 1000 * 60 * 60 * 2, Calendar.getInstance().getTimeInMillis())) {
            if (allInstalledAppsMap.containsKey(usageStats.getPackageName())) {
                ApplicationInfo applicationInfo = allInstalledAppsMap.get(usageStats.getPackageName());

                AppData appData = new AppData(usageStats,
                        applicationInfo,
                        getCanonicalAppName(applicationInfo),
                        getAppIcon(applicationInfo)
                );

                appDataList.add(appData);
            }
        }

        return appDataList;
    }

    private boolean isExternallyInstalledApp(final ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0
                && (applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) == 0
                || (applicationInfo.packageName.toLowerCase().contains("com.google.android.apps")
                && !applicationInfo.packageName.toLowerCase().contains("apps.restore")
                && !applicationInfo.packageName.toLowerCase().contains("apps.wallpaper")
                && !applicationInfo.packageName.toLowerCase().contains("apps.inputmethod")
                && !applicationInfo.packageName.toLowerCase().contains("apps.pixelmigrate")
                && !applicationInfo.packageName.toLowerCase().contains("apps.enterprise"));
    }
}
