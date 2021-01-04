package NuclearMod;

import NuclearMod.content.NucContentLoader;
import arc.assets.*;
import mindustry.core.Version;
import mindustry.gen.Groups;


public class NucVars implements Loadable
{
    public float test;
    public static NucContentLoader NucContent;

    public static void init(){
        Groups.init();


        Version.init();

        NucContent = new NucContentLoader();
    }
}
