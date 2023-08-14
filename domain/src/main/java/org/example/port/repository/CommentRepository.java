package org.example.port.repository;

import org.example.entity.Comment;

import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);

    Comment findById(int id);

    List<Comment> findAll();

    void delete(Comment comment);


    List<Comment> findByIdPlant(int idPlant);
}
