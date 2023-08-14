package com.example.apirest.controller;

import com.example.apirest.dto.PlantRequestDTO;
import com.example.apirest.dto.PlantResponseDTO;
import org.example.entity.Plant;
import org.example.port.service.PlantService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/plant")
@RestController
public class PlantController {

    private final PlantService plantService;

    private final ModelMapper modelMapper;

    public PlantController(PlantService plantService, ModelMapper modelMapper) {
        this.plantService = plantService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<PlantResponseDTO> post(@RequestBody PlantRequestDTO plantRequestDTO) {
        return ResponseEntity.ok(
                modelMapper.map(
                        plantService.createPlant(
                                plantRequestDTO.getName(),
                                plantRequestDTO.getDescription(),
                                plantRequestDTO.getGrowthLevel(),
                                plantRequestDTO.getImageUrl(),
                                plantRequestDTO.getDetails()),
                        PlantResponseDTO.class)
        );
    }

    @GetMapping("")
    public ResponseEntity<List<PlantResponseDTO>> get() {
        return ResponseEntity.ok(convertToListPlants(plantService.getAllPlants()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(modelMapper.map(plantService.getPlantById(id), PlantResponseDTO.class));
    }

    private List<PlantResponseDTO> convertToListPlants(List<Plant> allPlants) {
        List<PlantResponseDTO> plantResponseDTOList = new ArrayList<>();
        allPlants.forEach(plant -> plantResponseDTOList.add(modelMapper.map(plant, PlantResponseDTO.class)));
        return plantResponseDTOList;
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<PlantResponseDTO> deleteById(@PathVariable int id) {
            return ResponseEntity.ok(modelMapper.map(plantService.deletePlantById(id), PlantResponseDTO.class));
        }

        @PutMapping("/{id}")
        public ResponseEntity<PlantResponseDTO> put(@PathVariable int id, @RequestBody PlantRequestDTO plantRequestDTO) {
            Plant plant = plantService.getPlantById(id);
            plant.setName(plantRequestDTO.getName());
            plant.setDescription(plantRequestDTO.getDescription());
            plant.setGrowthLevel(plantRequestDTO.getGrowthLevel());
            plant.setImageUrl(plantRequestDTO.getImageUrl());
            plant.setDetails(plantRequestDTO.getDetails());
            return ResponseEntity.ok(modelMapper.map(plantService.updatePlant(plant), PlantResponseDTO.class));
        }


    }



