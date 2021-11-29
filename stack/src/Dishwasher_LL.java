import java.util.Scanner;

public class Dishwasher_LL {
    public static void main(String[] args) {
        LL<Integer> dirty=new LL<>();
        LL<Integer> clean=new LL<>();
        int n,x;
        Scanner scn=new Scanner(System.in);
        n= scn.nextInt();
        x=scn.nextInt();
        int[] time=new int[x];
        for(int i=0;i<x;i++){
            time[i]=scn.nextInt();
        }

    }
}
