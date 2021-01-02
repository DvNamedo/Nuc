package NuclearMod.world.modules;

import NuclearMod.Vars;
import NuclearMod.Vars.*;
import NuclearMod.content.NucContentLoader;
import NuclearMod.core.NuclearJavaMod;
import arc.math.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.type.*;
import NuclearMod.world.air.*;
import mindustry.world.modules.BlockModule;


public class GasModule extends BlockModule
{
    private static final int windowSize = 3,
                             updateInterval = 60;
    private static final Interval flowTimer = new Interval(2);
    private static final float pollScl = 20f;

    private float[] gases = new float[Vars.NucContent.gases().size()];
}

