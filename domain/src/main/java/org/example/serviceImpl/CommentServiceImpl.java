package org.example.serviceImpl;

import org.example.entity.Comment;
import org.example.port.repository.CommentRepository;
import org.example.port.service.CommentService;

import java.time.LocalDateTime;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private String title;
    private LocalDateTime date;
    private String commentContent;
    private String commentType;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @Override
    public Comment createComment(String title, LocalDateTime date, String commentContent,  String commentType) {

        Comment comment = new Comment(title, LocalDateTime.now(), commentContent, commentType);
      return commentRepository.save(comment);
    }



    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment updateComment(int id, Comment comment) {
        try{
            Comment commentToUpdate = commentRepository.findById(id);
            commentToUpdate.setTitle(comment.getTitle());
            commentToUpdate.setDate(comment.getDate());
            commentToUpdate.setCommentType(comment.getCommentType());
            return commentRepository.save(commentToUpdate);
        } catch (Exception e) {
            throw new RuntimeException("Comment not found");
        }
    }

    @Override
    public void deleteComment(int id) {
        try {
            Comment commentToDelete = commentRepository.findById(id);
            commentRepository.delete(commentToDelete);
        } catch (Exception e) {
            throw new RuntimeException("Comment not found");
        }
    }

    @Override
    public List<Comment> getCommentByIdPlant(int idPlant) {
        try {
           return commentRepository.findByIdPlant(idPlant);

        } catch (Exception e) {
            throw new RuntimeException("Comment not found");
        }
    }
}
