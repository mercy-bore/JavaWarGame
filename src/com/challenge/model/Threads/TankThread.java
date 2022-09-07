package com.challenge.model.Threads;
import com.challenge.controller.WarGameWorld;
import com.challenge.model.Army.Army;

import java.util.Random;

public class TankThread extends Thread {
    private void SoldiersShooting(Army army){
        for (int k = 0; k < WarGameWorld.getMaxSoldiers(); k ++) {
            int soldierIndex = new Random().nextInt(army.getSoldiers().size() - 1);
            army.getSoldiers().get(soldierIndex).shoot();
        }
    }
    private void SoldiersDying(Army army){
        for (int k = 0; k < WarGameWorld.getMaxSoldiers(); k ++) {
            int soldierIndex = new Random().nextInt(army.getSoldiers().size() );
            if (WarGameWorld.getChoice() <= 9 && army.getSoldiers().get(soldierIndex).isAlive())
                army.getSoldiers().get(soldierIndex).shot();
        }
    }
    @Override
    public void run() {
        if (WarGameWorld.getChoice() % 2 == 0){
            this.SoldiersShooting(WarGameWorld.enemy);
            this.SoldiersDying(WarGameWorld.ally);
        }else {
            this.SoldiersShooting(WarGameWorld.ally);
            this.SoldiersDying(WarGameWorld.enemy);
        }
    }
}
