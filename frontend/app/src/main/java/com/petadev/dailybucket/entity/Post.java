package com.petadev.dailybucket.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public final class Post implements Serializable {
    private final User user;
    private final String header;
    private final String body;
    private final String pictureUrl;
    private final PostType postType;
    private final Timestamp postedAt;

    public Post(User user, String header, String body, String pictureUrl, PostType postType, Timestamp postedAt) {
        this.user = user;
        this.header = header;
        this.body = body;
        this.pictureUrl = pictureUrl;
        this.postType = postType;
        this.postedAt = postedAt;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public PostType getPostType() {
        return postType;
    }

    public User getUser() {
        return user;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public Timestamp getPostedAt() {
        return postedAt;
    }
}
