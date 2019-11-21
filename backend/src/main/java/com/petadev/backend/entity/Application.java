package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Applications")
public final class Application {
    @DatabaseField(generatedId = true)
    private Integer applicationId;

    @DatabaseField
    private String applicationName;

    @DatabaseField
    private String packages;

    // empty constructor needed by Spring
    public Application() {
    }

    public Application(String applicationName, String packages) {
        this.applicationName = applicationName;
        this.packages = packages;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getPackages() {
        return packages;
    }
}
