package org.example.port.service;

import org.example.entity.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface CommentService {
    Comment createComment( String title, LocalDateTime date, String commentType);

    List<Comment> getAllComments();

    Comment getCommentById(int id);

    Comment updateComment(int id, Comment comment);

    void deleteComment(int id);

}
