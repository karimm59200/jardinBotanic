package com.example.infrastructurespringdata.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idPlant", nullable = false)
    private int id;

    private String name;

    private String description;

    private int growthLevel;

    private String imageUrl;

    private String details;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserAppEntity user;

    @OneToMany(mappedBy = "plant")
    private List<CommentEntity> comments;


}
