package com.challenge.model.Army;
import com.challenge.model.Gun.Gun;
import com.challenge.model.Jet.Jet;
import com.challenge.model.Tank.Tank;
import java.util.Scanner;

public class Soldier {
    private boolean alive;
    private Gun gun;
    private Tank tank;
    private Jet jet;
    private String militaryId;

    public  void  setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean isAlive() {
        return alive;
    }

    public Soldier(String militaryId) {
        this.militaryId = militaryId;
        this.alive = true;
        this.gun = new Gun();
        this.tank = new Tank("Jf78");
        this.jet = new Jet("F-35");
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
    public void shoot() throws InterruptedException {
//        System.out.println(this.militaryId + " shooting on mode " + gun.getGunShootingMode());
//        this.gun.shootGunBullets();

        int weapon;
        Scanner console = new Scanner(System.in);
        System.out.println();
        System.out.println("==================== War is upon us!! ==========================");
        Thread.sleep(2000);
        System.out.println("============= *****  Choose your weapon Soldier ***** =================");
        System.out.println();
        Thread.sleep(2000);
        System.out.print("Select: \n 1 Gun \n 2 Tank \n 3 Jet \n 4 Main Menu  \n");
        System.out.println();
        weapon = console.nextInt();
        if (isAlive()) {
            switch (weapon) {
                case 1:
                    System.out.print(this.militaryId + " shooting on mode: " + gun.getGunShootingMode() + ", and with a Gun Type of: ");
                    this.gun.shootGun(); //shootGunBullets()
                    break;
                case 2:
                    System.out.print(this.militaryId + " shooting on mode " + tank.getShootingMode() + ", with a TANK of type: ");
                    this.tank.shootTank(); // shootTankBullets()
                    break;
                case 3:
                    System.out.print(this.militaryId + " shooting with Jet model type " + jet.getJetModelType() + ", on shooting mode ");
                    this.jet.shootJet(); // ShootJetBullets()
                    break;
                case 4:
                    System.out.println("Going back to main menu");
                    break;
            }
        }
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

    public void shot() {
        this.alive = false;
        System.out.println(this.militaryId + " just died");
    }
}
