package com.challenge.model.Gun;
import java.util.*;

public class Gun {
    String gunType;
    int bullets;
    int maxBullets;
    char shootingMode; // S for single, A for automatic 5 bullets (per shot)


    public void reloadBullets() {
        bullets = maxBullets;
    }
    public char getGunShootingMode() {
        return shootingMode;
    }
    public void setShootingMode(char shootingMode) {
        this.shootingMode = shootingMode;
    }

    public Gun() {
        this.shootingMode = 'S';
        this.maxBullets = 1000;
        this.gunType = "ak47";
        reloadBullets();
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
        }
    }

    public void shootGun() {
        System.out.println(gunType);
        this.shootGunBullets();

    }
    public void getGunType() {
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
        }
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
