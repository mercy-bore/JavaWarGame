package com.challenge.model.Army;
import com.challenge.model.Gun.Gun;
import com.challenge.model.Jet.Jet;
import com.challenge.model.Tank.Tank;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final String name;
    private Soldier[] soldiers;
    private Gun[] guns;

    private Tank[] tanks;
    private Jet[] jets;

    public Army(String name) {
        this.name = name;
    }

    public Soldier[] getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(Soldier[] soldiers) {
        this.soldiers = soldiers;
    }

    public Gun[] getGuns() {
        return guns;
    }

    public void setGuns(Gun[] guns) {
        this.guns = guns;
    }

    public Tank[] getTanks() {
        return tanks;
    }

    public void setTanks(Tank[] tanks) {
        this.tanks = tanks;
    }

    public Jet[] getJets() {
        return jets;
    }

    public String getName() {
        return name;
    }

    public void setJets(Jet[] jets) {
        this.jets = jets;
    }

}
