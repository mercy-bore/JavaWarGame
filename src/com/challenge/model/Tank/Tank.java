package com.challenge.model.Tank;
import com.challenge.model.Enums.Artilery;
import com.challenge.model.Enums.Day;

public class Tank {
    private final String tankModelType; // T-72
    int bullets;
    int maxTankBullets;
    int missiles;
    int maxTankMissiles;
    int weaponType;
    char shootingMode;
    public void reloadTankBullets() {
        bullets = maxTankBullets;
    }
    public void reloadTankMissiles() {
        missiles = maxTankMissiles;
    }

    Day t = Day.THURSDAY;
    Artilery tank = Artilery.TANK;


    public Tank(String tankModelType){
        this.tankModelType = "Shupanov p3 1937";
        this.maxTankBullets = 1000;
        this.maxTankMissiles = 30;
        this.shootingMode  ='A';
        reloadTankBullets();
        reloadTankMissiles();
    }

    public char getShootingMode() {
        return shootingMode;
    }

    public void setShootingMode(char shootingMode) {
        this.shootingMode = shootingMode;
    }

    public void setCannonType(int weaponType) {
        this.weaponType = weaponType;
    }
    public int getTankShootingMode() {
        return shootingMode;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int getMissiles() {
        return missiles;
    }

    public void setMissiles(int missiles) {
        this.missiles = missiles;
    }

    public void changeShootingMode() {
        if (shootingMode == 'A')  //         if (Objects.equals(cannonType, "Breda 35"))
            this.setShootingMode('B');
        else
            this.setShootingMode('A');
    }
    public void shootTankBullets() {
        if (bullets > 0) {
            if (shootingMode == 'A') {
                bullets--;
                System.out.println("*");
            } else {
                bullets -= 5;
                System.out.println("£££££");
            }
        }else
            System.out.println("Tank is out of bullets!!");
    }

    public void shootTank() {
        System.out.println(this.tankModelType);
        this.shootTankBullets();

    }
}

