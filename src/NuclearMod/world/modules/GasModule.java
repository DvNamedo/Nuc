package NuclearMod.world.modules;

import NuclearMod.NucVars;
import NuclearMod.world.air.*;
import arc.math.*;
import arc.util.*;
import mindustry.world.modules.BlockModule;


public class GasModule extends BlockModule
{
    private static final int windowSize = 3,
                             updateInterval = 60;
    private static final Interval flowTimer = new Interval(2);
    private static final float pollScl = 20f;

    private float[] gases = new float[NucVars.NucContent.gases().size];
    private float total;
    private Gas current = NucVars.NucContent.gas(0);
    private float smoothGas;

    private boolean hadFlow;
    private @Nullable WindowedMean flow;
    private float lastAdded, currentFlowRate;

    public void update(boolean showFlow){
        smoothGas = Mathf.lerpDelta(smoothGas,);
    }


    public float getFlowRate(){
        return currentFlowRate * 60;
    }

}

