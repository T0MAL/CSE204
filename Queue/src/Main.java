import java.util.Scanner;

public class Main {
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
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        Arr<Integer> q=new Arr<>(size,size);
        while (size > 0) {
            int n = scn.nextInt();
            q.enqueue(n);
            size--;
        }
        print(q);
        int fn;
        int param;
        while (true) {
            fn = scn.nextInt();
            param = scn.nextInt();
            if (fn == 0) {
                break;
            }
            if (fn == 1) {  //clear
                q.clear();
                print(q);
                System.out.println("-1");
            }
            else if (fn == 2) {  //enqueue
                q.enqueue(param);
                print(q);
                System.out.println("-1");
            }
            else if (fn == 3) {   //dequeue
                int item = q.dequeue();
                print(q);
                System.out.println(item);
            }
            else if (fn == 4) {   //length
                print(q);
                System.out.println(q.length());
            }
            else if (fn == 5) {     //frontValue
                print(q);
                System.out.println(q.frontValue());
            }
            else if (fn == 6) { //rearvalue
                print(q);
                System.out.println(q.rearValue());
            }
            else if(fn==7){ //leaveq
                int item = q.leaveQueue();
                print(q);
                System.out.println(item);
            }
        }
    }
}
