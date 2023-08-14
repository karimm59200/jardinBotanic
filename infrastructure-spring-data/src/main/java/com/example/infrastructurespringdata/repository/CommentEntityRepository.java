package com.example.infrastructurespringdata.repository;

import com.example.infrastructurespringdata.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentEntityRepository extends CrudRepository<CommentEntity, Integer> {

    List<CommentEntity> findAllByIdPlant(int idPlant);

    List<CommentEntity> findAllByIdUser(int idUser);
}
