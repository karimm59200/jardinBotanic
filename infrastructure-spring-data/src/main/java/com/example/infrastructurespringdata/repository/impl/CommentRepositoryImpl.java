package com.example.infrastructurespringdata.repository.impl;

import com.example.infrastructurespringdata.entity.CommentEntity;
import com.example.infrastructurespringdata.exception.NotFoundException;
import com.example.infrastructurespringdata.repository.CommentEntityRepository;
import org.example.entity.Comment;
import org.example.port.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final CommentEntityRepository commentEntityRepository;

    private final ModelMapper modelMapper;

    public CommentRepositoryImpl(CommentEntityRepository commentEntityRepository, ModelMapper modelMapper) {
        this.commentEntityRepository = commentEntityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Comment save(Comment comment) {
        CommentEntity commentEntity = modelMapper.map(comment, CommentEntity.class);
        return modelMapper.map(commentEntityRepository.save(commentEntity), Comment.class);
    }

    @Override
    public Comment findById(int id) {
     Optional<CommentEntity> optionalcommentEntity = commentEntityRepository.findById(id);
        if (optionalcommentEntity.isPresent()) {
            return modelMapper.map(optionalcommentEntity.get(), Comment.class);
        }
       throw new NotFoundException();
    }

    @Override
    public List<Comment> findAll() {
       return convertToListComments((List<CommentEntity>) commentEntityRepository.findAll());
    }

    private List<Comment> convertToListComments(List<CommentEntity> all) {
        List<Comment> comments = new ArrayList<>();
        for (CommentEntity commentEntity : all) {
            comments.add(modelMapper.map(commentEntity, Comment.class));
        }
        return comments;
    }

    @Override
    public void delete(Comment comment) {
        commentEntityRepository.delete(modelMapper.map(comment, CommentEntity.class));
    }

    @Override
    public List<Comment> findByIdPlant(int idPlant) {
        return null;
    }
}
