package com.challenge.model.Threads;
import com.challenge.controller.WarGameWorld;
import com.challenge.model.Army.Army;
import java.util.Random;

public class JetThread extends Thread {
    private void SoldierFireWeapon(Army army){
        for (int k = 0; k < WarGameWorld.getMaxSoldiers(); k ++) {
            int soldierIndex = new Random().nextInt(army.getSoldiers().size() - 1);
            army.getSoldiers().get(soldierIndex).shoot();
        }
    }
    private void SoldierDie(Army army){
        for (int k = 0; k < WarGameWorld.getMaxSoldiers(); k ++) {
            int soldierIndex = new Random().nextInt(army.getSoldiers().size() - 1);
            if (WarGameWorld.getChoice() <= 9 && army.getSoldiers().get(soldierIndex).isAlive())
                army.getSoldiers().get(soldierIndex).shot();
        }
    }
    @Override
    public void run() {
        if (WarGameWorld.getChoice() % 2 == 0){
            this.SoldierFireWeapon(WarGameWorld.enemy);
            this.SoldierDie(WarGameWorld.ally);
        }else {
            this.SoldierFireWeapon(WarGameWorld.ally);
            this.SoldierDie(WarGameWorld.enemy);
        }
    }
}
