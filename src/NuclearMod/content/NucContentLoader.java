// 빌드 하는법 How to build
//C:\Users\PC\Desktop\NuclearJavaMod> 에다가
// gradlew.bat jar 쓰기
package NuclearMod.content;

import NuclearMod.world.air.Gas;
import arc.struct.Seq;
import mindustry.ctype.Content;
import mindustry.ctype.ContentList;
import mindustry.ctype.ContentType;

import static NuclearMod.Vars.*;

public class NucContentLoader implements ContentList {
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

    public <T extends Content> Seq<T> getBy(ContentType type){
        return (Seq<T>)contentMap[type.ordinal()];
    }

    public Seq<Gas> gases(){
        return getBy(ContentType.liquid);
    }
}