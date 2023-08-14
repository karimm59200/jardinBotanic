package org.example.port.repository;

import org.example.entity.Plant;

import java.util.List;

public interface PlantRepository {

    Plant save(Plant plant);

    Plant findById(int id);

    Plant findByName(String name);

    List<Plant> findAll();

    void delete(Plant plant);


}
