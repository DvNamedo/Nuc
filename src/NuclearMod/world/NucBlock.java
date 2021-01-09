package NuclearMod.world;

import mindustry.world.*;

public class NucBlock extends Block {

    public boolean hasGases;
    public boolean outputsGas = false;

    public float gasCapacity = 100f;
    public float gasPressure = 10f;

    public NucBlock(String name) {
        super(name);
    }
}
