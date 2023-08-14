package org.example.entity;

public class Plant {

    private int id;
    private String name;
    private String description;

    private int growthLevel;
    private String imageUrl;
    private String details;

    public Plant() {

    }

    public Plant(int id, String name, String description, int growthLevel, String imageUrl, String details) {
        this(name, description, growthLevel, imageUrl, details);
        this.id = id;
    }

    public Plant(String name, String description, int growthLevel, String imageUrl, String details) {
        this.name = name;
        this.description = description;
        this.growthLevel = growthLevel;
        this.imageUrl = imageUrl;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getGrowthLevel() {
        return growthLevel;
    }

    public void setGrowthLevel(int growthLevel) {
    }
}
