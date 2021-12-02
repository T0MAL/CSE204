import java.util.Scanner;

public class Dishwasher_LL {
    public static void main(String[] args) {
            int n,x;
            Scanner scn=new Scanner(System.in);
            n= scn.nextInt();
            x=scn.nextInt();
            LL<Integer> dirty=new LL<>();
            LL<Integer> clean=new LL<>();
            int[] time=new int[x];
            for(int i=0;i<x;i++){
                time[i]=scn.nextInt();
            }
            LL<Integer> wholeEater=new LL<>();
            int total=0;
            int[] tickTime=new int[n*x];
            int[] count=new int[n];
            int k,t,s;
            k= scn.nextInt();
            t= scn.nextInt();
            s= scn.nextInt();
            count[k-1]++;
            if(count[k-1]==x)
                wholeEater.push(k-1);
            int popTime=0;
            dirty.push(time[s-1]);
            int currentlyWorking;
            currentlyWorking=dirty.pop();
            popTime+=currentlyWorking-1;
            while(1==1){
                k= scn.nextInt();
                t= scn.nextInt();
                s= scn.nextInt();

                if(k==0){
                    while(dirty.length()>0){
                        clean.push(currentlyWorking);
                        //System.out.println(popTime);
                        tickTime[total++]=popTime;
                        popTime++;
                        currentlyWorking=dirty.pop();
                        popTime+=currentlyWorking-1;
//                    tickTime[total++]=popTime;
                    }
                    clean.push(currentlyWorking);
                    tickTime[total++]=popTime;

                    break;
                }
                count[k-1]++;
                if(count[k-1]==x)
                    wholeEater.push(k-1);
                if(t<=popTime){
                    dirty.push(time[s-1]);
                }
                else{
                    while(t>popTime){
                        clean.push(currentlyWorking);
//                    System.out.println(popTime);
                        tickTime[total++]=popTime;
                        popTime++;
                        if(dirty.length()>0) {
                            currentlyWorking = dirty.pop();
                            popTime+=(currentlyWorking-1);
                        }
                        else {
                            //popTime=t;
                            dirty.push(time[s-1]);
                            currentlyWorking= dirty.pop();
                            popTime=t+currentlyWorking-1;
                        }
                    }

                }
            }
            System.out.println(popTime);
            //System.out.println(clean.topValue());
            for(int i=0;i<total;i++){
                if(i!=total-1)
                    System.out.print(tickTime[i]+",");
                else
                    System.out.println(tickTime[i]);
            }
            if(clean.length()==n*x){
                System.out.println("Y");
            }
            else
                System.out.println("N");
            int ll= wholeEater.length();
            for(int i=0;i<ll;i++){
                if(i!=ll-1)
                    System.out.print(wholeEater.pop()+1+",");
                else
                    System.out.println(wholeEater.pop()+1);
            }
        }
}
