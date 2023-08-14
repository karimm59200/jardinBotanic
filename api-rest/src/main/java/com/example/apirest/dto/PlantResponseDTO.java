package com.example.apirest.dto;

import com.example.infrastructurespringdata.entity.CommentEntity;
import com.example.infrastructurespringdata.entity.UserAppEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlantResponseDTO {

    private int id;

    private String name;

    private String description;

    private int growthLevel;

    private String imageUrl;

    private String details;

    private UserAppEntity user;

    private List<CommentEntity> comments;
}
