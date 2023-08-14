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
public class UserAppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", nullable = false)
    private int id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<PlantEntity> plants = new java.util.ArrayList<>();


}
