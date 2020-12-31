package NuclearMod.content;

import NuclearMod.world.air.Gas;
import mindustry.ctype.*;
import arc.graphics.*;
import mindustry.type.*;
import arc.math.*;

public class Gases implements ContentList {
    public static Gas
    //Single element
    hydrogen, helium, carbon, nitrogen, oxygen,
    //compound
    CO2,H2O,
    //mixture
    air;

    @Override
    public void load() {
        hydrogen = new Gas("hydrogen"){{
            barColor = new Color(255,60,2);
        }};
    }
}
