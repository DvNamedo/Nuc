package NuclearMod.world.air;

import arc.graphics.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.type.StatusEffect;
import mindustry.world.meta.*;

public class Gas<T extends UnlockableContent> extends UnlockableContent
{
    // 기체 색
    // 바 색
    // 유출시 이펙트
    // 유출 상태로

    public Color color;
    public Color barColor;
    public StatusEffect effect;
    //public float greenhouseEffect = 0; // 온실효과

    protected UnlockableContent[] chemicalReactionsObj; // 반응 대상
    protected StatusEffect[] chemicalReactionsEffect; // 반응 효과
    protected chemicalReactionsType[] chemicalReactionsType; //반응 유형
    protected float[] chemicalReactionsPower; // 반응 유형시 파워
    protected UnlockableContent[] generatedSubstances; // 생성 물질

    public Gas(String name, Color color) {
        super(name);
        this.color = new Color(color);
    }

    //자주 쓰일것
    public Gas(String name){
        this(name, new Color(0,0,0,0));
    }

    public void SetChemicalReactions(UnlockableContent[] CRObj, StatusEffect[] chemicalReactionsEffect, chemicalReactionsType[] chemicalReactionsType, float[] chemicalReactionsPower, UnlockableContent[] generatedSubstances){
        this.chemicalReactionsObj = CRObj;
        this.chemicalReactionsEffect = chemicalReactionsEffect;
        this.chemicalReactionsType = chemicalReactionsType;
        this.chemicalReactionsPower = chemicalReactionsPower;
        this.generatedSubstances = generatedSubstances;
    }

    public boolean hasNullArray(){
        int[] bool = {chemicalReactionsObj.length, chemicalReactionsEffect.length,chemicalReactionsType.length, chemicalReactionsPower.length, generatedSubstances.length};
        return !(bool[0] == bool[1] && bool[2] == bool[3] && bool[4] == bool[0]);
    }

    public Color BarColor(){
        return barColor == null ? color : barColor;
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
