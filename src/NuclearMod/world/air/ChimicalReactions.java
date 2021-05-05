package NuclearMod.world.air;

import arc.struct.*;

import mindustry.type.*;
import mindustry.ctype.*;

public class ChimicalReactions {
    public StatusEffect effect;


    protected Seq<UnlockableContent> chemicalReactionsObj = new Seq<>(); // 반응 대상
    protected StatusEffect chemicalReactionsEffect; // 반응 효과
    protected chemicalReactionsType chemicalReactionsType; //반응 유형
    protected float chemicalReactionsPower; // 반응 유형시 파워
    protected UnlockableContent generatedSubstances; // 생성 물질

    public ChimicalReactions(UnlockableContent genSub){
        this.generatedSubstances = genSub;
    }


}
