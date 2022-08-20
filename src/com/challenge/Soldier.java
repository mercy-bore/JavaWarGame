package com.challenge;
import com.challenge.Gun.Gun;
import com.challenge.Jet.Jet;

public class Soldier {
    private Gun gun;
    private String militaryId;
    private char type; // A or E
    public Soldier(String militaryId) {
        this.militaryId = militaryId;
        this.gun = new Gun();
    }
    Enum.Day s = Enum.Day.MONDAY;
    Enum.Day t = Enum.Day.WEDNESDAY;
    Enum.Day y = Enum.Day.FRIDAY;
    public void shoot() {
        System.out.println("On " + s + " ,Soldier of Military ID " + this.militaryId + ", was shooting on Mode: " + gun.getShootingMode());
        this.gun.shootBullets();
    }
    public void changeShootingMode() {
        this.gun.changeShootingMode();
    }
}
