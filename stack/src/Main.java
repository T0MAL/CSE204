import java.util.Scanner;

public class Main {
    public static void print(Stack st){
        int l= st.length();
        int[] a=new int[l];
        Stack<Integer> sttt=new LL<>();
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
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int chunk = scn.nextInt();
        LL<Integer> st=new LL<>();
        while (size > 0) {
            int n = scn.nextInt();
            st.push(n);
            size--;
        }
        print(st);
        int fn;
        int param;
        while (true) {
            fn = scn.nextInt();
            param = scn.nextInt();
            if (fn == 0) {
                break;
            }
            if (fn == 1) {  //clear
                st.clear();
                print(st);
                System.out.println("-1");
            }
            else if (fn == 2) {  //push
                st.push(param);
                print(st);
                System.out.println("-1");
            }
            else if (fn == 3) {   //pop
                int item = st.pop();
                print(st);
                System.out.println(item);
            }
            else if (fn == 4) {   //length
                print(st);
                System.out.println(st.length());
            }
            else if (fn == 5) {     //top
                print(st);
                System.out.println(st.topValue());
            }
            else if (fn == 6) {   //direction
                st.setDirection(param);
                print(st);
                System.out.println("-1");
            }

        }
    }

}
