import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RedWeChat {

    public static final float MINMONEY = 0.01f;

    public static final float MAXMONRY = 200.00f;

    public static final float times = 20.01f;

    public static void main(String args[]){
        float money = 200;
        int count = 100;
        RedWeChat r = new RedWeChat();
        List<Float> list = r.splitRedPackets(money, count);


        System.out.println("list: "+list);
        Iterator<Float> iterator = list.iterator();
        float total = 0;
        while (iterator.hasNext()){
            total = total + iterator.next();
        }
        System.out.println("total: "+total);
    }

    public List<Float> splitRedPackets(float money, int count){
        List<Float> list = new ArrayList<>();
        float max = (float) Math.round(money*times/count);
        max = max > MAXMONRY ? MAXMONRY : max;
        for(int i = 0; i < count; i++){
            float one = randomRedPacket(money, MINMONEY, max, count-i);
            list.add(one);
            money = money - one;
        }
        return list;
    }

    public float randomRedPacket(float money, float mins, float maxs, int count){
        if(count == 1){
            return (float)(Math.round(money*100))/100;
        }
        if(mins == maxs){
            return mins;
        }
        float max = maxs > money ? money : maxs; //注意这里是和当前money做比较，不是MAXMONEY
        float one = (float) Math.random()*(max - mins) + mins;
        one = (float) Math.round(one*100)/100;   //保留两位小数
        float moneyOther = money - one;
        if(isRight(moneyOther, count -1)){
            return one;
        }
        float avg = money/count;
        if(avg < MINMONEY){
            return randomRedPacket(money, mins, one, count);
        }else if(avg > MAXMONRY){
            return randomRedPacket(money, one, maxs, count);
        }
        return one;
    }

    public boolean isRight(float money, int count){
        double avg = money/count;
        if(avg < MINMONEY){
            return false;
        }else if(avg > MAXMONRY){
            return false;
        }else {
            return true;
        }
    }
}
