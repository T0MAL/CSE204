import java.util.Scanner;

public class Dishwasher1A2S {
    public static void print(Stack st){
        int l= st.length();
        int[] a=new int[l];
        while(l>0){
            int tmp= (int) st.pop();
            a[l-1]=tmp;
            l--;
        }
        System.out.print("<");
        for (int i = 0; i <a.length; i++) {
            if(i!=0)
                System.out.print(" ");
            System.out.print(a[i]);
            st.push(a[i]);
        }
        System.out.print(">");
        System.out.println();
        // System.out.println(a);
    }
    public static void main(String[] args) {
        int n,x;
        Scanner scn=new Scanner(System.in);
        n= scn.nextInt();
        x=scn.nextInt();
        Integer[] arra=new Integer[n*x*2];
        Arr<Integer> dirty=new Arr<>(arra,-1);
        Arr<Integer> clean=new Arr<>(arra,1);
        int[] time=new int[x];
        for(int i=0;i<x;i++){
            time[i]=scn.nextInt();
        }
        Arr<Integer> wholeEater=new Arr<>(n,n);
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
          //  print(dirty);
            k= scn.nextInt();
            t= scn.nextInt();
            s= scn.nextInt();
            if(k==0){
                while(dirty.length()>0){
                    clean.push(currentlyWorking);
                    //System.out.println(popTime);
                    tickTime[total++]=popTime;
                   // popTime;
                    currentlyWorking=dirty.pop();
                    popTime+=currentlyWorking;
//                    tickTime[total++]=popTime;
                }
                clean.push(currentlyWorking);
                tickTime[total++]=popTime;
                //print(dirty);
                break;
            }
            count[k-1]++;
            if(count[k-1]==x)
                wholeEater.push(k-1);
            if(t<=popTime){
                dirty.push(time[s-1]);
                //System.out.println("call me");
            }
            else{
                while(t>popTime){
                    clean.push(currentlyWorking);
                    tickTime[total++]=popTime;
                    if(dirty.length()>0) {
                        currentlyWorking = dirty.pop();
                       // System.out.println(currentlyWorking);
                        popTime+=(currentlyWorking);
                    }
                    else {
                        //popTime=t;
                        dirty.push(time[s-1]);
                        currentlyWorking= dirty.pop();
                        popTime=t+currentlyWorking-1;
                        break;
                    }
                    if(popTime>=t){
                        dirty.push(time[s-1]);
                        break;
                    }
                }
            }
            //System.out.println(popTime);
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
