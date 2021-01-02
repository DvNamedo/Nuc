package NuclearMod.world.air;

import NuclearMod.content.Gases;
import mindustry.content.*;

public class GasStack {
    public Gas gas;
    public float amount;

    public GasStack(Gas gas, float amount){
        this.gas = gas;
        this.amount = amount;
    }

    protected GasStack(){
        gas = Gases.hydrogen;
    }

    @Override
    public String toString(){
        return "GasStack{" +
                "gas=" + gas +
                ",amount=" + amount +
                '}';
    }


}
