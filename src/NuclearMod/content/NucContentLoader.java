// How to build
//C:\Users\PC\Desktop\NuclearJavaMod>
// write the "gradlew.bat jar"
package NuclearMod.content;

import NuclearMod.world.air.Gas;
import arc.struct.Seq;
import mindustry.core.ContentLoader;
import mindustry.ctype.Content;
import mindustry.ctype.ContentList;
import mindustry.ctype.ContentType;

public class NucContentLoader extends ContentLoader implements ContentList {
    private Seq<Content>[] contentMap = new Seq[ContentType.all.length];
    private final ContentList[] contents = {
        new NuclBlocks(),
        new NuclItems(),
        new NuclLiquid(),
        new Gases()
    };
    
    @Override
    public void load() {
        for(ContentList list : contents) {
            list.load();
        }
    }

    public Seq<Gas> gases()
    {
        return getBy(ContentType.liquid);
    }
    public Gas gas(int id){ return getByID(ContentType.liquid, id); }
}