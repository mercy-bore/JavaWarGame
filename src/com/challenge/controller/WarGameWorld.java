package com.challenge.controller;
import com.challenge.model.Army.Army;
import com.challenge.model.Army.Soldier;
import java.util.*;


public class WarGameWorld {
    private final static int maxSoldiers = 10;
    private Army ally;
    private Army enemy;

    public WarGameWorld() {
        this.setupGame();
    }
    public static String weapons() {
        List<String> artilery = new LinkedList<>();
        artilery.add("Guns");
        artilery.add("Tanks");
        artilery.add("Jets");
        return artilery.toString();
    }
    public String armies() {
        List<Army> armies = new ArrayList<>();
        Army a1 = new Army("British Army");
        Army a2 = new Army("Kenya Army");
        Army a3 = new Army("The US Army");
        armies.add(a1);
        armies.add(a2);
        armies.add(a3);
        System.out.println("The armies in WarGame are: ");
        for(Army i: armies){
            System.out.println(i.getName());
        }
        return armies.toString();
    }
    private void setupGame() {
        // Create 2 armies (Ally and Enemy)
        ally = new Army("ally");
        enemy = new Army("enemy");
        // 1000 soldiers per army
        Soldier[] allySoldiers = new Soldier[maxSoldiers];
        Soldier[] enemySoldiers = new Soldier[maxSoldiers];

        for (int k = 0; k < maxSoldiers; k++) {
            allySoldiers[k] = new Soldier("ALLY_00" + k);
            enemySoldiers[k] = new Soldier("ENEMY_00" + k);

            ally.setSoldiers(allySoldiers);
            enemy.setSoldiers(enemySoldiers);


        }
    }

    private void runGame() throws InterruptedException {

        // randomize enemy or ally
        int choice = new Random().nextInt(10);
        if (choice % 2 == 0) {
            // enemy
            for (int k = 0; k < 10; k++) {
                int soldierIndex = new Random().nextInt(enemy.getSoldiers().length - 1);
                enemy.getSoldiers()[soldierIndex].shoot();
            }
            // ally
            for (int k = 0; k < 10; k++) {
                int soldierIndex = new Random().nextInt(ally.getSoldiers().length - 1);
                choice = new Random().nextInt(10);
                if (choice % 2 == 0 && ally.getSoldiers()[soldierIndex].isAlive())
                    ally.getSoldiers()[soldierIndex].shot();
            }
        } else {
            for (int k = 0; k < 10; k++) {
                int soldierIndex = new Random().nextInt(ally.getSoldiers().length - 1);
                ally.getSoldiers()[soldierIndex].shoot();
            }
            // ally
            for (int k = 0; k < 10; k++) {
                int soldierIndex = new Random().nextInt(enemy.getSoldiers().length - 1);
                choice = new Random().nextInt(10);
                if (choice % 2 == 0 && enemy.getSoldiers()[soldierIndex].isAlive())
                    enemy.getSoldiers()[soldierIndex].shot();
            }
        }
    }

    private boolean allSoldiersAreDead(Army army) {
        boolean alive = true;
        for (int k = 0; k < army.getSoldiers().length; k++) {
            alive = !army.getSoldiers()[k].isAlive();
            if (alive)
                break;
        }
        return alive;
    }

    private boolean noWeaponHasBullets(Army army) {
        for (int k = 0; k < army.getSoldiers().length; k++)
            if (army.getSoldiers()[k].gunHasBullets())
                return false;
        return true;
    }


    public void run() throws InterruptedException {
        System.out.println("============= *****  Welcome To WarGame ***** =================");
        Thread.sleep(1000);
        System.out.println("===============  We need to defend our country ===================");
        Thread.sleep(2000);
        while(true) {
            // - Setup the game [Soldiers, Army (Ally, Enemy), Weapon Arsenal]
            // - Run the game [ Soldiers shoot at enemy, Control Weapons + Arsenal ]
            // - Control the game. Determine, when the game ends...
            // [1 - All soldiers are dead,
            // [2 - No weapon has bullets
            int choice;
            Scanner console = new Scanner(System.in);
            System.out.println();
            System.out.println("=============== *** WarGame Menu *** ===================");
            System.out.print("Select: \n 1 To play the game \n 2 To view armies \n 3 To view artillery \n 4 To exit the game \n ");
            choice = console.nextInt();
            switch (choice) {
                case 1:
                    while (true) {
                        if (allSoldiersAreDead(ally)&&allSoldiersAreDead(enemy)){
                            System.out.println("All soldiers are dead");
                            break;
                        }
                        else {
                            this.runGame();
                        }
                        if (noWeaponHasBullets(ally) || noWeaponHasBullets(enemy)){
                            break;
                        }

                        try {
                            Thread.sleep(2000);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                        break;
                case 2:
                    System.out.println(armies());
                    break;
                case 3:
                    System.out.println("The artillery used in this game are: " + weapons());
                    break;
                case 4:
                    System.out.println("You are now exiting the game!!");
                    return;
            }
        }
    }
}

