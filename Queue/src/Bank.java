import java.util.Scanner;

public class Bank {
    public static void print(Queue<Integer> q){
        int l=q.length();
        int[] tmp=new int[l];
        System.out.print("<");
        for (int i = 0; i < l; i++) {
            if(i!=0)
                System.out.print(" ");
            int tmpp=q.dequeue();
            System.out.print(tmpp);
            tmp[i]=tmpp;
        }
        System.out.print(">");
        System.out.println();
        for (int i = 0; i < l; i++) {
            q.enqueue(tmp[i]);
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner scn=new Scanner(System.in);
        n= scn.nextInt();
        LL<Integer> q1=new LL<>();
        LL<Integer> q2=new LL<>();
        int timeBooth1=0;
        int timeBooth2=0;
        int counter1;
        int counter2;
        int elapsedTime=0;
        while(n>0){
            int time,service;
            time= scn.nextInt();
            service= scn.nextInt();
            for(;elapsedTime<time;elapsedTime++){
                if(elapsedTime==timeBooth1&&q1.length()>0){
                    timeBooth1= elapsedTime+q1.dequeue();
                }
                if(elapsedTime==timeBooth2&&q2.length()>0){
                    timeBooth2= elapsedTime+q2.dequeue();
                }
                if(q1.length()==0&&timeBooth1<=elapsedTime&&q2.length()!=0) {
                    timeBooth1 = elapsedTime + q2.leaveQueue();
                }
                if(q2.length()==0&&timeBooth2<=elapsedTime&&q1.length()!=0) {
                    timeBooth2 = elapsedTime + q1.leaveQueue();
                }
                while(q1.length()-q2.length()>1){
                    q2.enqueue(q1.leaveQueue());
                }
                while(q2.length()-q1.length()>1){
                    q1.enqueue(q2.leaveQueue());
                }
                if(elapsedTime==timeBooth1&&q1.length()>0){
                    timeBooth1= elapsedTime+q1.dequeue();
                }
                if(elapsedTime==timeBooth2&&q2.length()>0){
                    timeBooth2= elapsedTime+q2.dequeue();
                }
            }
            elapsedTime=time+1;
            if(time==timeBooth1&&q1.length()>0){
                timeBooth1= time+q1.dequeue();
            }
            if(time==timeBooth2&&q2.length()>0){
                timeBooth2=time+ q2.dequeue();
            }
            if(q1.length()==0&&timeBooth1<=time){
                timeBooth1=time+service;
            }
            else if(q2.length()==0&&timeBooth2<=time){
                timeBooth2=time+service;
            }
            else if(q1.length()<= q2.length()){
                q1.enqueue(service);
            }
            else if(q1.length()>q2.length()){
                q2.enqueue((service));
            }

            while(q1.length()-q2.length()>1){
                q2.enqueue(q1.leaveQueue());
            }
            while(q2.length()-q1.length()>1){
                q1.enqueue(q2.leaveQueue());
            }
            n--;
            if(n==0){
                while(q1.length()>0||q2.length()>0){
                    if(elapsedTime==timeBooth1&&q1.length()>0){
                        timeBooth1= elapsedTime+q1.dequeue();
                    }
                    if(elapsedTime==timeBooth2&&q2.length()>0){
                        timeBooth2= elapsedTime+q2.dequeue();
                    }
                    if(q1.length()==0&&timeBooth1<=elapsedTime&&q2.length()!=0)
                        timeBooth1=elapsedTime+ q2.leaveQueue();
                    if(q2.length()==0&&timeBooth2<=elapsedTime&&q1.length()!=0)
                        timeBooth2=elapsedTime+ q1.leaveQueue();
                    while(q1.length()-q2.length()>1){
                        q2.enqueue(q1.leaveQueue());
                    }
                    while(q2.length()-q1.length()>1){
                        q1.enqueue(q2.leaveQueue());
                    }
                    elapsedTime++;
                }

            }
        }
        System.out.println("Booth 1 finishes service at t="+timeBooth1);
        System.out.println("Booth 2 finishes service at t="+timeBooth2);
    }

}
