package NuclearMod.world.air;

import NuclearMod.content.Gases;
import mindustry.content.*;

public class GasStackMayBeNot {
    public Gas gas;
    public float amount;

    public GasStackMayBeNot(Gas gas, float amount){
        this.gas = gas;
        this.amount = amount;
    }

    protected GasStackMayBeNot(){
        gas = Gases.hydrogen;
    }

}
