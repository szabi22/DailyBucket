package com.petadev.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "UserActivities")
public final class UserActivity {
    @DatabaseField(generatedId = true)
    private int userActivityID;

    @DatabaseField(canBeNull = false, foreign = true)
    private User user;

    @DatabaseField(canBeNull = false,foreign = true)
    private Activity activity;

    public UserActivity() {
    }

    public UserActivity(final User user, final Activity activity) {
        this.user = user;
        this.activity = activity;
    }

    public int getUserActivityID() {
        return userActivityID;
    }

    public User getUser() {
        return user;
    }

    public Activity getActivity() {
        return activity;
    }


}
