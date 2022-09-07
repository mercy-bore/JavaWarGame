package com.challenge.model.Army;
import com.challenge.model.Gun.Gun;
import com.challenge.model.Jet.Jet;
import com.challenge.model.Tank.Tank;

import java.util.ArrayList;

public class Army {
    private final String name;
    private ArrayList<Soldier> soldiers;
    private ArrayList<Gun> guns;
    private ArrayList<Tank> tanks;
    private ArrayList<Jet> jets;

    public Army(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }

    public ArrayList<Gun> getGuns() {
        return guns;
    }

    public void setGuns(ArrayList<Gun> guns) {
        this.guns = guns;
    }

    public ArrayList<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(ArrayList<Tank> tanks) {
        this.tanks = tanks;
    }

    public ArrayList<Jet> getJets() {
        return jets;
    }

    public void setJets(ArrayList<Jet> jets) {
        this.jets = jets;
    }

    public void setSoldiers(ArrayList<Soldier> soldiers) {
        this.soldiers = soldiers;
    }
}
