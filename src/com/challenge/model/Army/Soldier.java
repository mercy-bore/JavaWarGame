package com.challenge.model.Army;
import com.challenge.model.Gun.Gun;
import com.challenge.model.Jet.Jet;
import com.challenge.model.Tank.Tank;
import java.util.Random;

public class Soldier {
    private boolean alive;
    private Gun gun;
    private Tank tank;
    private Jet jet;
    private String militaryId;

    public Soldier(String militaryId) {
        this.militaryId = militaryId;
        this.alive = true;
        this.gun = new Gun("Heckler");
        this.tank = new Tank("Shupanov p3 1937");
        this.jet = new Jet("F_35");
    }
    public  void  setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean isAlive() {
        return alive;
    }

    public boolean gunHasBullets() {
        return this.gun.getBullets() > 0;
    }
    public boolean tankHasBullets() {
        return this.tank.getBullets() > 0;
    }
    public boolean jetHasBullets() {
        return this.jet.getBullets() > 0;
    }

    public Gun getGun() {
        return gun;
    }
    public Tank getTank(){return  tank;}
    public Jet getJet(){return jet;}

    public void setGun(Gun gun) {
        this.gun = gun;
    }
    public void setTank(Tank tank) {
        this.tank = tank;
    }
    public void setJet(Jet jet) {
        this.jet = jet;
    }
    public String getMilitaryId() {
        return militaryId;
    }
    public void setMilitaryId(String militaryId) {
        this.militaryId = militaryId;
    }
    public void shoot(){
        if(this.alive) {
            int weapon = new Random().nextInt(10);
            if (weapon % 2 == 0) {
                System.out.println(this.militaryId + " shooting a gun  on mode: " + gun.getGunShootingMode());
                this.gun.shootGunBullets();
            }  else if (weapon % 5 == 0) {
                System.out.println(this.militaryId + " shooting a tank on mode:  " + tank.getShootingMode());
                this.tank.shootTankBullets();
            } else if (weapon % 3 != 0) {
                System.out.println(this.militaryId + " shooting a jet of type: " + jet.getJetModelType());
                this.jet.shootJetBullets();
            }
        }
    }
    public void shot() {
        this.alive = false;
        System.out.println(this.militaryId + " just died.");
    }
    public void changeGunShootingMode() {
        this.gun.changeShootingMode();
    }
    public void changeTankShootingMode() {
        this.tank.changeShootingMode();
    }
    public void changeJetShootingMode() {
        this.jet.changeShootingMode();
    }


}
