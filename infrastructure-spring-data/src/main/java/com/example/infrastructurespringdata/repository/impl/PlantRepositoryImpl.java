package com.example.infrastructurespringdata.repository.impl;

import com.example.infrastructurespringdata.entity.PlantEntity;
import com.example.infrastructurespringdata.exception.NotFoundException;
import com.example.infrastructurespringdata.repository.PlantEntityRepository;
import org.example.entity.Plant;
import org.example.port.repository.PlantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlantRepositoryImpl implements PlantRepository {

    private final PlantEntityRepository plantEntityRepository;

    private final ModelMapper modelMapper;

public PlantRepositoryImpl(PlantEntityRepository plantEntityRepository, ModelMapper modelMapper) {
        this.plantEntityRepository = plantEntityRepository;
        this.modelMapper = modelMapper;
}

    @Override
    public Plant save(Plant plant) {
        PlantEntity plantEntity = modelMapper.map(plant, PlantEntity.class);
        return modelMapper.map(plantEntityRepository.save(plantEntity), Plant.class);
    }

    @Override
    public Plant findById(int id) {
        Optional<PlantEntity> optionalPlantEntity = plantEntityRepository.findById(id);
        if (optionalPlantEntity.isPresent()) {
            return modelMapper.map(optionalPlantEntity.get(), Plant.class);
        }
       throw new NotFoundException();
    }

    @Override
    public Plant findByName(String name) {
    Optional<PlantEntity> optionalPlantEntity = plantEntityRepository.findByName(name);
        if (optionalPlantEntity.isPresent()) {
            return modelMapper.map(optionalPlantEntity.get(), Plant.class);
        }
       throw new NotFoundException();
    }

    @Override
    public List<Plant> findAll() {
      return convertToListPlants((List<PlantEntity>) plantEntityRepository.findAll());
    }

    private List<Plant> convertToListPlants(List<PlantEntity> all) {
        List<Plant> plants = new ArrayList<>();
        for (PlantEntity plantEntity : all) {
            plants.add(modelMapper.map(plantEntity, Plant.class));
        }
        return plants;
    }

    @Override
    public void delete(Plant plant) {
        plantEntityRepository.delete(modelMapper.map(plant, PlantEntity.class));
    }
}
