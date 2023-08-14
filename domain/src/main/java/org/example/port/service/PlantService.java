package org.example.port.service;

import org.example.entity.Plant;
import java.util.List;

public interface PlantService {
    Plant createPlant(String name, String description, int growthLevel, String imageUrl, String details);
    Plant getPlantById(int id);

    Plant getPlantByName(String name);

    Plant updatePlant(Plant plant);

    void deletePlant(Plant plant);

    List<Plant> getAllPlants();

    Plant deletePlantById(int id);
}
