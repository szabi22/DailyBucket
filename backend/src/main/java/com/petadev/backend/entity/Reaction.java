package com.petadev.backend.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.petadev.backend.ReactionType;

@DatabaseTable(tableName = "Reactions")
public final class Reaction {
    @DatabaseField(generatedId = true)
    private int reactionID;

    @DatabaseField(canBeNull = false, foreign = true)
    private User user;

    @DatabaseField(canBeNull = false,foreign = true)
    private Post post;

    @DatabaseField(canBeNull = false, dataType = DataType.ENUM_TO_STRING)
    private ReactionType reactionType;

    public Reaction() {
    }

    public Reaction(final User user, final Post post, final ReactionType reactionType) {

        this.user = user;
        this.post = post;
        this.reactionType = reactionType;
    }

    public int getReactionID() {
        return reactionID;
    }

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return post;
    }

    public ReactionType getReactionType() {
        return this.reactionType;
    }
}
