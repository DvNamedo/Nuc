package NuclearMod.world.modules;

import NuclearMod.NucVars;
import NuclearMod.content.NucContentLoader;
import NuclearMod.world.air.*;
import arc.math.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.type.*;
import mindustry.world.modules.BlockModule;

import java.util.Arrays;


public class GasModule extends BlockModule
{
    private static final int windowSize = 3,
                             updateInterval = 60;
    private static final Interval flowTimer = new Interval(2);
    private static final float pollScl = 20f;

    private float[] gases = new float[NucVars.NucContent.gases().size];
    private float total,smoothGas;
    private Gas gCurrent = NucVars.NucContent.gas(0);

    private boolean hadFlow;
    private @Nullable WindowedMean flow;
    private float lastAdded, currentFlowRate;

    public void update(boolean showFlow) {
        smoothGas = Mathf.lerpDelta(smoothGas, gCurrentAmount(), 0.1f);
        if(showFlow){
            if(flowTimer.get(1, pollScl)){
                if(flow == null) flow = new WindowedMean(windowSize);
                if(lastAdded > 0.0001f) hadFlow = true;

                flow.add(lastAdded);
                lastAdded = 0;
                if(currentFlowRate < 0 || flowTimer.get(updateInterval)){
                    currentFlowRate = flow.hasEnoughData() ? flow.mean() / pollScl : -1f;
                }
            }
        }
        else{
            currentFlowRate = -1f;
            flow = null;
            hadFlow = false;
        }
    }

    /** 현재 기체 보유량을 u/s 단위로 반환, 값 < 0 이면 준비 안됨을 뜻함*/
    public float getFlowRate(){
        return currentFlowRate * 60;
    }
    public boolean hadFlow(){ return hadFlow; }
    public float smoothAmount(){ return smoothGas; }
    /** 가스의 총량을 반환. */
    public float total(){ return total; }
    /** 마지막으로 받은 기체. 한가지 유형의 기체만이 존재하는 기체모듈에만 유효 */
    public Gas gCurrent(){
        return gCurrent;
    }

    public void reset(Gas gas, float amount){
        Arrays.fill(gases, 0f);
        gases[gas.id] = amount;
        total = amount;
        gCurrent = gas;
    }

    public float gCurrentAmount(){
        return gases[gCurrent.id];
    }

    public float get(Gas gas){
        return gases[gas.id];
    }

    public void clear(){
        total = 0;
        Arrays.fill(gases, 0);
    }

    public void add(Gas gas, float amount){
        gases[gas.id] += amount;
        total += amount;
        gCurrent = gas;

        if(flow != null){
            lastAdded += Math.max(amount, 0);
        }
    }

    public void remove(Gas gas, float amount){
        add(gas, -amount);
    }


    public void each(GasConsumer cons){
        for(int i = 0; i < gases.length; i++){
            if(gases[i] > 0){
                cons.accept(NucVars.NucContent.gas(i), gases[i]);
            }
        }
    }


    public float sum(GasCalculator calc){
        float sum = 0f;
        for(int i = 0; i < gases.length; i++){
            if(gases[i] > 0){
                sum += calc.get(NucVars.NucContent.gas(i), gases[i]);
            }
        }
        return sum;
    }


    @Override
    public void write(Writes write){
        int amount = 0;
        for(float gas : gases){
            if(gas > 0) amount++;
        }

        write.s(amount); //amount of gases

        for(int i = 0; i < gases.length; i++){
            if(gases[i] > 0){
                write.s(i); //gas ID
                write.f(gases[i]); // gas amount
            }
        }

    }

    @Override
    public void read(Reads read, boolean legacy){
        Arrays.fill(gases, 0);
        total = 0f;
        int count = legacy ? read.ub() : read.s();

        for (int j = 0; j < count; j++){
            int gasId = legacy ? read.ub() : read.s();
            float amount = read.f();
            gases[gasId] = amount;
            if(amount > 0) { gCurrent = NucVars.NucContent.gas(gasId); }
            this.total += amount;
        }
    }


    public interface  GasConsumer{
        void accept(Gas gas, float amount);
    }

    public interface GasCalculator{
        float get(Gas gas, float amount);
    }


}

