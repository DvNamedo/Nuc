package NuclearMod.world;

import NuclearMod.NucVars;
import NuclearMod.world.air.Gas;

import arc.Core;
import arc.graphics.*;
import mindustry.Vars;
import mindustry.annotations.Annotations.*;
import mindustry.ctype.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.ui.Bar;
import mindustry.world.*;
import arc.struct.*;

public class NucBlock extends Block {



    public boolean hasGases = true;
    public boolean outputsGas = false;
    public boolean IsAllMaterialUse = true; // 모든 물질종류를 사용하는가

    public UnlockableContent SomeMaterialUse[]; //쓰는 물질들

    public float gasCapacity = 100f;
    public float gasPressure = 10f;

    protected int isAnyTypeMaterial = 0; // 사용하는 물질종류

    //protected Item ItemArr[] = Vars.content.items().toArray();

    protected Liquid LiquidArr[] = Vars.content.liquids().toArray();
    protected Gas GasArr[] = NucVars.NucContent.gases().toArray();

    protected Seq<UnlockableContent> materialSeq = new Seq<>();
    protected Seq<Color> materialSeqColor = new Seq<>();
    protected UnlockableContent materialArr[];
    protected Color materialArrColor[];


// Liquids , Gases 값 가져와서 배열화 하고 셋이 합치기




        // 다중으로 기스 바 보이게끔 하기

        @Override
        public void init(){
            super.init();

            setCPBars(); //set Common Proportional Bar.

        }

        @Override
        public void setStats(){
            super.setStats();



        }

        public void setCPBars() { //set Common Proportional Bar. | 공통 비례 바

            bars.remove("liquid");
            /*
            for(Item ia : ItemArr){
                materialSeq.add(ia);
            }
            */

            if(hasLiquids)
            for (Liquid la : LiquidArr) {
                materialSeq.add(la);
                materialSeqColor.add(la.barColor);
            }


            if(hasGases)
            for (Gas ga : GasArr) {
                materialSeq.add(ga);
                materialSeqColor.add(ga.barColor);
            }

            if(hasGases || hasGases) {

                for (int i = 0; i < materialSeq.size; i++) {
                    materialArr[i] = materialSeq.get(i);
                    materialArrColor[i] = materialSeqColor.get(i);
                }


            }
        }

    public NucBlock(String name) {
        super(name);
    }

    public class NucBlockBuild extends Building {

            @Override
            public void updateTile(){



            }

    }

}
