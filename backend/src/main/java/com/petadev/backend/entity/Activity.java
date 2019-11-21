package com.petadev.backend.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.petadev.backend.Difficulty;

@DatabaseTable(tableName = "Activities")
public final class Activity {

    @DatabaseField(generatedId = true)
    private Integer activityId;

    @DatabaseField
    private String activityName;

    @DatabaseField(dataType = DataType.ENUM_TO_STRING)
    private Difficulty difficultyLevel;

    @DatabaseField
    private String description;

    @DatabaseField
    private float plusAppTime;


    // empty constructor needed by Spring
    public Activity() {
    }

    // constructor used by developer
    public Activity(final String activityName, final Difficulty difficultyLevel, final String description, final float plusAppTime) {
        this.activityName = activityName;
        this.difficultyLevel = difficultyLevel;
        this.description = description;
        this.plusAppTime = plusAppTime;

    }

    // because fields are private, we need public getters. This way we can't modify our object run-time...
    // we must always create a new instance if data is updated.
    public String getActivityName() {
        return activityName;
    }

    public Difficulty getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getDescription() {
        return description;
    }

    public float getPlusAppTime() {
        return plusAppTime;
    }

    public Integer getActivityId() {
        return activityId;
    }
}
