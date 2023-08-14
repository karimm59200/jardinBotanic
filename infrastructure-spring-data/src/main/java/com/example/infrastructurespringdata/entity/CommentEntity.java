package com.example.infrastructurespringdata.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    @Column (name = "idComment", nullable = false)
    private int id;

    private String title;

    private LocalDateTime date;

    private String commentType;

    @ManyToOne
    @JoinColumn(name = "idPlant")
    private PlantEntity plant;
}
