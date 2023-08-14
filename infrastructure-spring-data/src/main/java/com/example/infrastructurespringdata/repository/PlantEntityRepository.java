package com.example.infrastructurespringdata.repository;

import com.example.infrastructurespringdata.entity.PlantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantEntityRepository extends CrudRepository<PlantEntity, Integer> {
    List<PlantEntity> findAll();

    List<PlantEntity> findByIdUser(int idUser);

    Optional<PlantEntity> findByName(String name);
}
