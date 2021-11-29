import java.util.Scanner;

public class TNL {
    static void task1(List<Integer> route){
        route.moveToStart();
        int l=route.length();
        for(int i=0;i<l;i++){
            int val=route.getValue();
            if(i!=0)
                System.out.print(",");
            if(val>=1){
                System.out.print(i);
            }
            else{
                System.out.print("");
            }
            route.next();
        }
        System.out.println();
        route.moveToStart();
        for(int i=0;i<l;i++){
            int val=route.getValue();
            if(i!=0)
                System.out.print(",");
            if(val>=2){
                System.out.print(i);
            }
            else{
                System.out.print("");
            }
            route.next();
        }
        System.out.println();
        route.moveToStart();
        for(int i=0;i<l;i++){
            int val=route.getValue();
            if(i!=0)
                System.out.print(",");
            if(val==3){
                System.out.print(i);
            }
            else{
                System.out.print("");
            }
            route.next();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n;
        n=scn.nextInt();
        Arr<Integer> rs= new Arr<Integer>(n,n);
        List<Integer> route= new LL<Integer>(n,n);
        for(int i=0;i<n;i++){
            rs.append(i);
            route.append(1);
        }

        int busn;
        busn=scn.nextInt();
        Arr<Integer> bus= new Arr<Integer>(busn,n);
        for(int i=0;i<busn;i++){
            int gg= scn.nextInt();
            bus.append(gg);
            route.moveToPos(gg);
            if(gg==n-1){
                route.remove();
                route.append(2);
                continue;
            }
            route.remove();
            route.insert(2);
        }
        int trainn=scn.nextInt();
        Arr<Integer> train=new Arr<Integer>(trainn,n);
        for(int i=0;i<trainn;i++){
            int ggg= scn.nextInt();
            train.append(ggg);
            route.moveToPos(ggg);
            if(ggg==n-1){
                route.remove();
                route.append(3);
                continue;
            }
            route.remove();
            route.insert(3);
        }
        int task= scn.nextInt();
        if(task==1){
            task1(route);
        }
    }
}

