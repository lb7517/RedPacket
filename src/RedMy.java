import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RedMy {
    public static void main(String args[]){
        double price = 10, num = 5;
        double minMoney = 0.01;
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < num; i++){
            double tmp1 = Math.random()*price;
            double tmp;
            if(i == num - 1){ //最后一个把剩余钱直接全给
                tmp = (double) Math.round(price*100)/100;
            }else{
                tmp = (double)Math.round(tmp1*100)/100;
                if(tmp == 0.00){        //处理随机为0的
                    tmp = minMoney;
                }else if(tmp == price){ //处理随机为最大值的数
                    while (tmp == price){
                        tmp = (double)Math.round(tmp1*100)/100;
                    }
                }
                price = price - tmp;
            }
            list.add(tmp);
        }
        System.out.println("list: "+list);


        Iterator<Double> iterator = list.iterator();
        double a = 0;
        while (iterator.hasNext()){
            a = a + iterator.next();
        }
        System.out.println("a: "+a);
    }
}
