package com.example.dailybucket;


import java.util.Date;


public final class Post {
    // hol a kep??
    private int postId;

    private String user;

    private Date createdAt;

    private String postBody;

    private int postImage;

    public Post() {
    }

    public Post(final String user, final Date createdAt, final String postBody, final int postImage) {

        this.createdAt = createdAt;
        this.postBody = postBody;
        this.user = user;
        this.postImage = postImage;
    }

    public int getPostId() {
        return postId;
    }

    public String getUser() {
        return user;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    //az xml?? nem fut le?nem mert van egy ilyen kakija is
    public String getPostBody() {
        return postBody;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }
}
