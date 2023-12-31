package org.example.serviceImpl;

import org.example.entity.Plant;
import org.example.port.repository.PlantRepository;
import org.example.port.service.PlantService;

import java.util.List;

public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }



    @Override
    public Plant createPlant(String name, String description, int growthLevel, String imageUrl, String details) {
        return null;
    }

    @Override
    public Plant getPlantById(int id) {
        return null;
    }

    @Override
    public Plant getPlantByName(String name) {
        return null;
    }

    @Override
    public Plant updatePlant(Plant plant) {
        return null;
    }

    @Override
    public void deletePlant(Plant plant) {

    }

    @Override
    public List<Plant> getAllPlants() {
        return null;
    }

    @Override
    public Plant deletePlantById(int id) {
        return null;
    }
}
