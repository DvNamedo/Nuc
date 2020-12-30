package NuclearMod.type;

import arc.graphics.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.type.StatusEffect;
import mindustry.world.meta.*;

public class Gas<T> extends UnlockableContent
{
    // 기체 색
    // 바 색
    // 유출시 이펙트
    // 유출 상태로

    public Color color;
    public Color barColor;
    public StatusEffect effect;
    public float greenhouseEffect = 0;

    public T[] chemicalReactions;
    public  StatusEffect[] chemicalReactionsEffect;
    public String[] chemicalReactionsType;

    public Gas(String name, Color color) {
        super(name);
    }


    @Override
    public String toString(){
        return localizedName;
    }

    @Override
    public ContentType getContentType(){
        return ContentType.liquid;
    }
}
