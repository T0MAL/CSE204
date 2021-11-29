import java.util.Scanner;

public class Main {
    public static void print(List arr){
        int cc = arr.currPos();
        arr.moveToStart();
        System.out.print("<");
        for (int i = 0; i < arr.length(); i++) {
            if(i!=0)
                System.out.print(" ");
            if (i == cc) {
                System.out.print("| ");
            }

            System.out.print(arr.getValue());
            arr.next();
        }
        System.out.print(">");
        System.out.println();
        arr.moveToPos(cc);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int chunk = scn.nextInt();
        Arr<Integer> lst = new Arr<Integer>();
        while (size > 0) {
            int n = scn.nextInt();
            lst.append(n);
            size--;
        }
        print(lst);
        int fn;
        int param;
        while (true) {
            fn = scn.nextInt();
            param = scn.nextInt();
            if (fn == 0) {
                break;
            }
            if (fn == 1) {  //clear
                lst.clear();
                print(lst);
                System.out.println("-1");
            }
            else if (fn == 2) {  //insert
                lst.insert(param);
                print(lst);
                System.out.println("-1");
            }
            else if (fn == 3) {   //append
                lst.append(param);
                print(lst);
                System.out.println("-1");
            }
            else if (fn == 4) {   //remove
                int item=lst.remove();
                print(lst);
                System.out.println(item);
            }
            else if (fn == 5) {     //move to start
                lst.moveToStart();
                print(lst);
                System.out.println("-1");
            }
            else if (fn == 6) {   //move to end
                lst.moveToEnd();
                print(lst);
                System.out.println("-1");
            }
            else if (fn == 7) {   //prev
                lst.prev();
                print(lst);
                System.out.println("-1");
            }
            else if (fn == 8) {   //next
                lst.next();
                print(lst);
                System.out.println("-1");
            }
            else if (fn == 9) {     //length
                print(lst);
                System.out.println(lst.length());
            }
            else if (fn == 10) {  //currpos
                print(lst);
                System.out.println(lst.currPos());
            }
            else if (fn == 11) { //move to pos
                lst.moveToPos(param);
                print(lst);
                System.out.println("-1");
            }
            else if (fn == 12) {   //getvalue
                print(lst);
                System.out.println(lst.getValue());
            }
            else if (fn == 13) {  // search
                print(lst);
                System.out.println(lst.Search(param));
            }
        }
    }

}
