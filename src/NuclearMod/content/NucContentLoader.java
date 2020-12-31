// 빌드 하는법 How to build
//C:\Users\PC\Desktop\NuclearJavaMod> 에다가
// gradlew.bat jar 쓰기
package NuclearMod.content;

import mindustry.ctype.ContentList;

public class NucContentLoader implements ContentList {
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
}