package com.challenge.model.Gun;
import java.util.*;

public class Gun {
    String gunType;
    int bullets;
    int maxBullets;
    char shootingMode; // S for single, A for automatic 5 bullets (per shot)

    public Gun(String gunType) {
        this.shootingMode = 'S';
        this.maxBullets = 1000;
        this.gunType = "Heckler";
        reloadBullets();
    }

    public String getGunType() {
        return gunType;
    }

    public void reloadBullets() {
        bullets = maxBullets;
    }
    public char getGunShootingMode() {
        return shootingMode;
    }
    public void setShootingMode(char shootingMode) {
        this.shootingMode = shootingMode;
    }
    public void changeShootingMode() {
        if (shootingMode == 'S')
            this.setShootingMode('A');
        else
            this.setShootingMode('S');
    }
    public void shootGunBullets() {
        if (bullets > 0)
        {
            if (shootingMode == 'S'){
                bullets --;
                System.out.println("-");
            }
            else {
                bullets -= 5;
                System.out.println("-----");
            }
        }else
            System.out.println("The Gun is out of bullets!");
    }

    public void shootGun() {
        System.out.println(gunType);
        this.shootGunBullets();

    }
    public void changeGunType() {
        if (bullets > 0)
        {
            if (Objects.equals(gunType, "AK47")){
                bullets --;
                System.out.println("-*-");
            }
            else if (Objects.equals(gunType, "Heckler")){
                bullets -= 5;
                System.out.println("-£-£-");
            }
            else{
                bullets -=3;
                System.out.println("###");
            }
        }else
            System.out.println("You are out of bullets!!");
    }

    public void setGunType(String gunType) {
        this.gunType = gunType;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int getMaxBullets() {
        return maxBullets;
    }

    public void setMaxBullets(int maxBullets) {
        this.maxBullets = maxBullets;
    }
}
