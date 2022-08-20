package com.challenge.Army;

import com.challenge.Gun.Gun;
import com.challenge.Jet.Jet;

public class Army {
    private com.challenge.Soldier[] soldiers;
    private Gun[] guns;
    private com.challenge.Tank[] tanks;
    private Jet[] jets;

    public com.challenge.Soldier[] getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(com.challenge.Soldier[] soldiers) {
        this.soldiers = soldiers;
    }

    public Gun[] getGuns() {
        return guns;
    }

    public void setGuns(Gun[] guns) {
        this.guns = guns;
    }

    public com.challenge.Tank[] getTanks() {
        return tanks;
    }

    public void setTanks(com.challenge.Tank[] tanks) {
        this.tanks = tanks;
    }

    public Jet[] getJets() {
        return jets;
    }

    public void setJets(Jet[] jets) {
        this.jets = jets;
    }
}
