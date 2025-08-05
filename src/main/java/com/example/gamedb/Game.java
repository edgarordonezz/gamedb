package com.example.gamedb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    String platform;
    private Double mainStory;
    private Double mainPlusSides;
    private Double completionist;
    private Double singlePlayer;
    private Double coop;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public Double getMainStory() {
        return mainStory;
    }
    public void setMainStory(Double mainStory) {
        this.mainStory = mainStory;
    }
    public Double getMainPlusSides() {
        return mainPlusSides;
    }
    public void setMainPlusSides(Double mainPlusSides) {
        this.mainPlusSides = mainPlusSides;
    }
    public Double getCompletionist() {
        return completionist;
    }
    public void setCompletionist(Double completionist) {
        this.completionist = completionist;
    }
    public Double getSinglePlayer() {
        return singlePlayer;
    }
    public void setSinglePlayer(Double singlePlayer) {
        this.singlePlayer = singlePlayer;
    }
    public Double getCoop() {
        return coop;
    }
    public void setCoop(Double coop) {
        this.coop = coop;
    }

    
}
