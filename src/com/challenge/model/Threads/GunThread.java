package com.challenge.model.Threads;
import com.challenge.controller.WarGameWorld;
import com.challenge.model.Army.Army;
import java.util.Random;

import static com.challenge.controller.WarGameWorld.ally;
import static com.challenge.controller.WarGameWorld.enemy;

public class GunThread extends Thread {

    @Override
    public void run() {
        // randomize enemy or ally
        int choice = new Random().nextInt(10);
        if (choice % 2 == 0) {
            // enemy
            for (int k = 0; k < 10; k++) {
                int soldierIndex = new Random().nextInt(enemy.getSoldiers().size() - 1);
                enemy.getSoldiers().get(soldierIndex).shoot();
            }
            // ally
            for (int k = 0; k < 10; k++) {
                int soldierIndex = new Random().nextInt(ally.getSoldiers().size() - 1);
                choice = new Random().nextInt(10);
                if (choice % 2 == 0 && ally.getSoldiers().get(soldierIndex).isAlive())
                    ally.getSoldiers().get(soldierIndex).shot();
            }
        } else {
            for (int k = 0; k < 10; k++) {
                int soldierIndex = new Random().nextInt(ally.getSoldiers().size() - 1);
                ally.getSoldiers().get(soldierIndex).shoot();
            }
            // ally
            for (int k = 0; k < 10; k++) {
                int soldierIndex = new Random().nextInt(enemy.getSoldiers().size() - 1);
                choice = new Random().nextInt(10);
                if (choice % 2 == 0 && enemy.getSoldiers().get(soldierIndex).isAlive())
                    enemy.getSoldiers().get(soldierIndex).shot();
            }
        }
    }
}