package com.petadev.dailybucket.entity;

import android.app.usage.UsageStats;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

public final class AppData implements Serializable {
    private final UsageStats usageStats;
    private final ApplicationInfo applicationInfo;
    private final String canonicalName;
    private final Drawable icon;

    public AppData(UsageStats usageStats, ApplicationInfo applicationInfo, String canonicalName, Drawable icon) {
        this.usageStats = usageStats;
        this.applicationInfo = applicationInfo;
        this.canonicalName = canonicalName;
        this.icon = icon;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public UsageStats getUsageStats() {
        return usageStats;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }
}
