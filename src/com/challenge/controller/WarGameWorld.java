package com.challenge.controller;
import com.challenge.UserRegistration;
import com.challenge.model.Army.Army;
import com.challenge.model.Army.Soldier;
import com.challenge.model.Enums.DifficultyLevel;
import com.challenge.model.Threads.GunThread;
import com.challenge.model.Threads.JetThread;
import com.challenge.model.Threads.TankThread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import static com.challenge.model.Enums.DifficultyLevel.*;


public class WarGameWorld {
    private static final int maxSoldiers=10;
    public static Army ally;
    public static Army enemy;
    public  static int choice;

    public static DifficultyLevel difficultyLevel = EASY;

    public WarGameWorld() {
        this.setupGame();
    }
    public static int getChoice() {
        return choice;
    }

    public static int getMaxSoldiers() {
        return maxSoldiers;
    }

    private void setupGame() {
        // Create 2 armies (Ally and Enemy)
        ally = new Army("ally");
        enemy = new Army("enemy");
        ArrayList<Soldier> allySoldiers = new ArrayList<>(maxSoldiers);
        ArrayList<Soldier> enemySoldiers = new ArrayList<>(maxSoldiers);
        for (int k = 0; k < maxSoldiers; k ++) {
            allySoldiers.add(new Soldier("ALLY_00" + k));
            enemySoldiers.add(new Soldier("ENEMY_00" + k));
        }
        ally.setSoldiers(allySoldiers);
        enemy.setSoldiers(enemySoldiers);
    }

    private void runGame() {
        GunThread t1 = new GunThread();
        t1.start();
        TankThread t2 = new TankThread();
        JetThread t3 = new JetThread();
        try {
            t1.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean allSoldiersAreDead(Army army) {
        boolean alive = true;
        for (int k = 0; k < army.getSoldiers().size(); k++) {
            alive = !army.getSoldiers().get(k).isAlive();
            if (alive)
                break;
        }
        return alive;
    }

    private boolean noWeaponHasBullets(Army army) throws FileNotFoundException {
        for (int k = 0; k < army.getSoldiers().size(); k++)
            if (army.getSoldiers().get(k).gunHasBullets())
                return false;
        return true;
    }
    private int deadSoldiers(Army army){
        int alive = 0;
        for (int k = 0; k < army.getSoldiers().size(); k++){
            if (army.getSoldiers().get(k).isAlive()) {
                alive = alive + 1;
            }
        }
        return army.getSoldiers().size() - alive;

    }



    private boolean registration () throws FileNotFoundException, InterruptedException {
        try {
            File obj = new File("Registration.txt");
                if (obj.createNewFile()) {
                    System.out.println("File is created");
                }

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();

            }

            int choice;
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");

            System.out.println("Enter your Choice");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                UserRegistration user = new UserRegistration();
                user.register();
            } else if (choice == 2) {
                UserRegistration user = new UserRegistration();
                user.login();
            } else {
                System.out.println("Choose Proper Option");
            }
            sc.close();
        return true;
    }




    public void run() throws InterruptedException, FileNotFoundException {
        System.out.println("============= *****  Welcome To WarGame ***** =================");
        Thread.sleep(1000);
        System.out.println();
        System.out.println("===============  We need to defend our country ===================");
        Thread.sleep(2000);
        System.out.println();


        while(true) {
            // - Setup the game [Soldiers, Army (Ally, Enemy), Weapon Arsenal]
            // - Run the game [ Soldiers shoot at enemy, Control Weapons + Arsenal ]
            // - Control the game. Determine, when the game ends...
            // [1 - All soldiers are dead,
            // [2 - No weapon has bullets

            System.out.println("***********************  Profile Setup  *********************");

            if (registration()){

                    while (true) {
                        if (allSoldiersAreDead(ally) && allSoldiersAreDead(enemy)) {
                            System.out.println();
                            System.out.println("=== ****** GAME OVER ****** ===");
                            System.out.println();
                            System.out.println("Here is the game summary .......");
                            Thread.sleep(1500);
                            System.out.println("......  find out if you won or lost.");
                            System.out.println();
                            Thread.sleep(2500);
                            if (deadSoldiers(ally) < deadSoldiers(enemy))
                                System.out.println("     ************* Congratulations!!  You have won the Game !! *************     ");
                            else
                                System.out.println("You Lost.Try again. ");

                            break;
                        } else {
                            this.runGame();
                        }
                        if (noWeaponHasBullets(ally) && noWeaponHasBullets(enemy)) {
                            break;
                        }

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Thread.sleep(3000);
                    break;
                }else
                System.out.println("Error");
        }
    }
}

