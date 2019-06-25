public class RedException {
    public static void main(String[] args)
    {
        float num=10,N=1.9f;//开始将系数设为1.9
        int people=10;
        for(int i=0;i<10;i++)
        {
            System.out.println("the number"+people+" can get  "+ num/people*N);
            num=num-num/people*N;
            people--;
        }
        System.out.println("there remain"+num);
    }
}
