package com.example.dailybucket;


import java.util.Date;


public final class Post {

    private int postId;

    private String user;

    private Date createdAt;

    private String postBody;

    public Post() {
    }

    public Post( final String user,final Date createdAt, final String postBody) {

        this.createdAt = createdAt;
        this.postBody = postBody;
        this.user=user;
    }

    public int getPostId() {
        return postId;
    }

public String getUser(){return user;}


    public Date getCreatedAt() {
        return createdAt;
    }
//az xml?? nem fut le?nem mert van egy ilyen kakija is
    public String getPostBody() {
        return postBody;
    }
}
