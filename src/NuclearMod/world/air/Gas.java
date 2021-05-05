package NuclearMod.world.air;

import arc.graphics.*;
import arc.struct.Seq;
import arc.util.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.type.StatusEffect;
import mindustry.world.meta.*;

import java.util.*;

public class Gas extends UnlockableContent
{
    // 기체 색
    // 바 색

    public Color color;
    public Color barColor;

    public Gas(String name, Color color) {
        super(name);
        this.color = new Color(color);
    }


    //자주 쓰일것
    public Gas(String name){
        this(name, new Color(0,0,0,0));
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

    /** 이사 합니다 ChimicalReactions */

    /*
    public StatusEffect effect;


    protected Seq<Seq<UnlockableContent>> chemicalReactionsObj = new Seq<>(); // 반응 대상
    protected Seq<StatusEffect> chemicalReactionsEffect = new Seq<>(); // 반응 효과
    protected Seq<chemicalReactionsType> chemicalReactionsType = new Seq<>(); //반응 유형
    protected float[] chemicalReactionsPower; // 반응 유형시 파워
    protected Seq<Seq<UnlockableContent>> generatedSubstances = new Seq<>(); // 생성 물질

     */




    /*
    public Seq<UnlockableContent> setCRObj(UnlockableContent... UCs){
        Seq<UnlockableContent> CRObj_ = new Seq<>();
        for(int i = 0; i < UCs.length; i++){
            CRObj_.set(i, UCs[i]);
        }
        return CRObj_;
    }

    public Seq<Seq<UnlockableContent>> setCRObjs(Seq<UnlockableContent>... UCs){
        Seq<Seq<UnlockableContent>> CRObjs_ = new Seq<>();
        for(int i = 0; i< UCs.length; i++){
            CRObjs_.set(i, UCs[i]);
        }
        return CRObjs_;
    }


    public void SetChemicalReactions(Seq<Seq<UnlockableContent>> CRObj, Seq<StatusEffect> chemicalReactionsEffect, Seq<chemicalReactionsType> chemicalReactionsType, float[] chemicalReactionsPower, Seq<Seq<UnlockableContent>> generatedSubstances){
        this.chemicalReactionsObj = CRObj;
        this.chemicalReactionsEffect = chemicalReactionsEffect;
        this.chemicalReactionsType = chemicalReactionsType;
        this.chemicalReactionsPower = chemicalReactionsPower;
        this.generatedSubstances = generatedSubstances;
    }

    public boolean hasNullArray(){
        int[] bool = {chemicalReactionsObj.size, chemicalReactionsEffect.size,chemicalReactionsType.size, chemicalReactionsPower.length, generatedSubstances.size};
        return !(bool[0] == bool[1] && bool[2] == bool[3] && bool[4] == bool[0]);
    }

    public UnlockableContent[] matters(UnlockableContent... matter){
        return matter;
    }
     */


}
