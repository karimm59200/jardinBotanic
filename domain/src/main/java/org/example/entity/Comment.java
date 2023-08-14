package org.example.entity;

import java.time.LocalDateTime;


public class Comment {

    private int id;

    private String title;

    private LocalDateTime date;

    // commentaires, astuces, questions, anecdotes
     private String commentType;

    public Comment() {
    }

    public Comment(int id, String title, LocalDateTime date, String commentType) {
        this(title, date, commentType);
        this.id = id;
    }

    public Comment(String title, LocalDateTime date, String commentType) {
        this.title = title;
        this.date = date;
        this.commentType = commentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }
}
