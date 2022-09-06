package com.challenge;
import com.challenge.controller.WarGameWorld;

public class WarGame {
    public static void main(String[] args) throws InterruptedException {
        new WarGameWorld().run();
    }
}





//package com.challenge;
//
//import com.challenge.model.Army.Army;
//import com.challenge.model.Jet.Jet;
//import com.challenge.model.Army.Soldier;
//import com.challenge.model.Tank.Tank;
//
//import java.util.Random;
//
//public class WarGame {
//    private static Soldier[] createSoldiers() {
//        Soldier[] soldiers = new Soldier[1000];
//        for (int k = 0; k < 1000; k ++) {
//            Soldier soldier = new Soldier("MIL_ID_000747");
//            soldiers[k] = soldier;
//        }
//        return soldiers;
//    }
//    private static  Jet[] createJets(){
//        Jet[] jets = new Jet[100];
//        for (int k = 0; k < 100; k ++) {
//            Jet jet = new Jet("F_35");
//            jets[k] = jet;
//        }
//        return jets;
//    }
//    private static  Tank[] createTanks(){
//        Tank[] tanks = new Tank[90];
//        for (int k = 0; k < 90; k ++) {
//            Tank tank = new Tank("B3 Model 1930");
//            tanks[k] = tank;
//        }
//        return tanks;
//    }
//    public static void main(String[] args) {
//        int min = 100;
//        int max = 999;
//        int x = (int)(Math.random()*(max-min+1)+min);
//        Army army = new Army();
//        army.setSoldiers(createSoldiers());
//        Soldier soldier = new Soldier("MIL_ID_000" + x);
//
//
//        int i = 0;
//        while (i <= 10000) {
//           soldier.shoot();
//           if (new Random().nextInt() % 2 == 0)
//               soldier.changeShootingMode();
//           i += 1000;
//        }
//        army.setJets(createJets());
//        Jet jet = new Jet("F_35");
//        int k = 0;
//        while (k <= 10000) {
//            jet.shootJetGun();
//            if (new Random().nextInt() % 10 == 0) {
//                jet.changeGunType();
//            }
//            k += 1000;
//        }
//        army.setTanks(createTanks());
//        Tank tank = new Tank("B3 Model 1930");
//        int m = 0;
//        while (m <= 1000) {
//            tank.shootTank();
//            if (new Random().nextInt() % 2 == 0)
//                tank.changeCannonType();
//            m += 100;
//
//        }
//
//    }
//}
