package com.challenge.model.Jet;

import com.challenge.model.Enums.Day;

import java.util.Objects;

public class Jet {
    private String jetModelType; // F-35
    int bullets;
    int missiles;
    int maxJetMissiles;
    int maxJetBullets;
    char shootingMode;
    String gunType;
    Day m = Day.MONDAY;

    public Jet(String jetModelType){
        this.jetModelType = "F_35";
        this.shootingMode = 'C';
        this.maxJetBullets = 1000;
        this.maxJetMissiles = 20;
        reloadJetMissils();
        reloadJetBullets();
    }
    public String getJetModelType() {
        return jetModelType;
    }
    public void reloadJetMissils() {
        missiles = maxJetMissiles;
    }

    public char getShootingMode() {
        return shootingMode;
    }

    public void setShootingMode(char shootingMode) {
        this.shootingMode = shootingMode;
    }

    public void reloadJetBullets() {
        bullets = maxJetBullets;
    }
    public String  getGunType() {
        return gunType;
    }

    public void setGunType(String gunType) {
        this.gunType = gunType;
    }
    public String  getJetShootingMode() {
        return gunType;
    }

    public void changeShootingMode() {
        if (shootingMode == 'C') //GAU-22/A
            this.setShootingMode('K'); //AIM-120
        else
            this.setShootingMode('C');
    }
    public void shootJetBullets() {
        if (bullets > 0)
        {
            if (Objects.equals(jetModelType, "F_35")){
                bullets --;
                System.out.println(">");
            }
            else {
                bullets -= 5;
                System.out.println("^^^^^");
            }
        }else
            System.out.println("The Jet is out of bullets!!");
    }

    public void shootJet() {
        System.out.println(shootingMode);
        this.shootJetBullets();
    }


    public void setJetModelType(String jetModelType) {
        this.jetModelType = jetModelType;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int getMaxJetBullets() {
        return maxJetBullets;
    }

    public void setMaxJetBullets(int maxBullets) {
        this.maxJetBullets = maxBullets;
    }
}

