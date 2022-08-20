package com.challenge;

import java.util.Objects;

public class Tank {
    private String tankNumber;
    private String tankModelType; // T-72
    int bullets;
    int maxTankBullets;
    String cannonType;
    public void reloadTankBullets() {
        bullets = maxTankBullets;
    }
    Enum.Day t = Enum.Day.THURSDAY;
    Enum.Artilery g = Enum.Artilery.TANK;


    public Tank(String tankModelType){
        this.tankModelType = "Shupanov p3 1937";
        this.maxTankBullets = 1000;
        reloadTankBullets();
    }
    public void setCannonType(String cannonType) {
        this.cannonType = cannonType;
    }
    public void changeCannonType() {
        if (Objects.equals(cannonType, "Breda 35"))
            this.setCannonType("B3 Model 1930");
        else
            this.setCannonType("Breda 35");
    }
    public void shootTankBullets() {
        if (bullets > 0) {
            if (Objects.equals(cannonType, "Breda 35")) {
                bullets--;
                System.out.println("*");
            } else {
                bullets -= 5;
                System.out.println("£££££");
            }
        }
    }

    public void shootTank() {
        System.out.println(g + " " + this.tankModelType + " , is shooting on Cannon Type:  " + this.cannonType);
        this.shootTankBullets();

    }
}

