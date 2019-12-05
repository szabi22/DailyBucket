package com.example.dailybucket;


import java.util.Date;


public final class Post {

    private int postId;



    private Date createdAt;


    private String postBody;

    public Post() {
    }

    public Post( final Date createdAt, final String postBody) {

        this.createdAt = createdAt;
        this.postBody = postBody;
    }

    public int getPostId() {
        return postId;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public String getPostBody() {
        return postBody;
    }
}
