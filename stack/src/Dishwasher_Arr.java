import java.util.Scanner;

public class Dishwasher_Arr {
    public static void main(String[] args) {
        int n,x;
        Scanner scn=new Scanner(System.in);
        n= scn.nextInt();
        x=scn.nextInt();
        Arr<Integer> dirty=new Arr<>(x,x);
        Arr<Integer> clean=new Arr<>(x,x);
        int[] time=new int[x];
        for(int i=0;i<x;i++){
            time[i]=scn.nextInt();
        }
    }
}
