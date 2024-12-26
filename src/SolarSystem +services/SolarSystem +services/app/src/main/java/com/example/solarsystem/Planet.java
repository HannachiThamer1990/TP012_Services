package com.example.solarsystem;

import java.io.Serializable;

public class Planet implements Serializable {
    private String name;
    private int imageResId;
    private double distanceFromSun; // En millions de km
    private double mass; // En kg
    private double revolutionPeriod; // En jours terrestres
    private int numberOfSatellites;
    private double diameter; // En kilomètres
    private double gravity; // En m/s²
    private String atmosphere; // Composition de l'atmosphère
    private double minTemperature; // Température minimale
    private double maxTemperature; // Température maximale
    private int musicResId;

    public Planet(String name, int imageResId, double distanceFromSun, double mass,
                  double revolutionPeriod, int numberOfSatellites, double diameter,
                  double gravity, String atmosphere, double minTemperature, double maxTemperature,int musicResId) {
        this.name = name;
        this.imageResId = imageResId;
        this.distanceFromSun = distanceFromSun;
        this.mass = mass;
        this.revolutionPeriod = revolutionPeriod;
        this.numberOfSatellites = numberOfSatellites;
        this.diameter = diameter;
        this.gravity = gravity;
        this.atmosphere = atmosphere;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.musicResId = musicResId;
    }

    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public double getDistanceFromSun() { return distanceFromSun; }
    public double getMass() { return mass; }
    public double getRevolutionPeriod() { return revolutionPeriod; }
    public int getNumberOfSatellites() { return numberOfSatellites; }
    public double getDiameter() { return diameter; }
    public double getGravity() { return gravity; }
    public String getAtmosphere() { return atmosphere; }
    public double getMinTemperature() { return minTemperature; }
    public double getMaxTemperature() { return maxTemperature; }
    public int getMusicResId() {return musicResId;}
}

