package com.challenge.Jet;

import com.challenge.Enum;

import java.util.Objects;

public class Jet {
    private String jetModelType; // F-35
    int bullets;
    int maxJetBullets;
    String gunType;
//    Enum.Jets x = Enum.Jets.F15;
//    Enum.Day

    public void reloadJetBullets() {
        bullets = maxJetBullets;
    }
    public String  getGunType() {
        return gunType;
    }
    public Jet(String jetModelType){
        this.jetModelType = "F_35";
        this.maxJetBullets = 1000;
        reloadJetBullets();
    }
    public void setGunType(String gunType) {
        this.gunType = gunType;
    }
    public void changeGunType() {
        if (Objects.equals(gunType, "GAU-22/A")) //GAU-22/A
            this.setGunType("AIM-120"); //AIM-120
        else
            this.setGunType("GAU-22/A");
    }
    public void shootJetBullets() {
        if (bullets > 0)
        {
            if (Objects.equals(gunType, "GAU-22/A")){
                bullets --;
                System.out.println(">");
            }
            else {
                bullets -= 5;
                System.out.println("^^^^^");
            }
        }
    }

    public void shootJetGun() {
        System.out.println("Jet " + this.jetModelType + ", is shooting Jet Gun Type:  " + this.gunType);
        this.shootJetBullets();
    }
    public String getJetModelType() {
        return jetModelType;
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

