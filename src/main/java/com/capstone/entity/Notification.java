package com.capstone.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "notification")
@CrossOrigin("*")
public class Notification {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numberOfSuspects")
    private Integer numberOfSuspects;

    @Column(name = "race")
    private String race;

    @Column(name = "gender")
    private String gender;

    @Column(name = "shirtColor")
    private String shirtColor;

    @Column(name = "pantColor")
    private String pantColor;

    @Column(name = "weapon")
    private String weapon;

    @Column(name = "floor")
    private String floor;

    @Column(name = "buildingLocation")
    private String buildingLocation;

    @Column(name = "dateCreated")
    LocalDateTime dateCreated = LocalDateTime.now();

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Notification() {
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfSuspects() {
        return numberOfSuspects;
    }

    public void setNumberOfSuspects(Integer numberOfSuspects) {
        this.numberOfSuspects = numberOfSuspects;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getShirtColor() {
        return shirtColor;
    }

    public void setShirtColor(String shirtColor) {
        this.shirtColor = shirtColor;
    }

    public String getPantColor() {
        return pantColor;
    }

    public void setPantColor(String pantColor) {
        this.pantColor = pantColor;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }



    @Override
    public String toString() {
        return "Notification [id=" + id + ", numberOfSuspects=" + numberOfSuspects + ", race=" + race + ", gender="
                + gender + ", shirtColor=" + shirtColor + ", pantColor=" + pantColor + ", weapon=" + weapon + ", floor="
                + floor + ", buildingLocation=" + buildingLocation + ", dateCreated=" + dateCreated + ", lat=" + lat
                + ", lng=" + lng + "]";
    }

    public String getBuildingLocation() {
        return buildingLocation;
    }

    public void setBuildingLocation(String buildingLocation) {
        this.buildingLocation = buildingLocation;
    }
    
}
