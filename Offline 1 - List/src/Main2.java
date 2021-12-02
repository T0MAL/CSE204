import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int x,y;
        Scanner scn=new Scanner(System.in);
        x=scn.nextInt();
        y= scn.nextInt();
        Arr<Integer> id=new Arr<>();
        Arr<Integer> course =new Arr<>();

         while(x!=0&&y!=0){
             int t1=id.Search(x);
             int t2=course.Search(y);
            if(t1==-1&&t2==-1){
                id.insert(x);
                course.insert(y);
                System.out.println("Insert");
                id.moveToStart();
                course.moveToStart();
                for(int i=0;i<id.length();i++){
                    System.out.print("["+id.getValue()+" "+course.getValue()+"]");
                    id.next();
                    course.next();
                }
               // System.out.println();
            }
            else if(t1>=0){
                id.moveToPos(t1);
                course.moveToPos(t1);
                id.duplicate();
                course.duplicate();
                System.out.println("duplicate");
                id.moveToStart();
                course.moveToStart();
                for(int i=0;i<id.length();i++){
                    System.out.print("["+id.getValue()+" "+course.getValue()+"]");
                    id.next();
                    course.next();
                }
                System.out.println();
                course.moveToPos(t1);
                id.moveToPos(t1);
                course.update(y);
                id.moveToStart();
                course.moveToStart();
                System.out.println("update");
                for(int i=0;i<id.length();i++){
                    System.out.print("["+id.getValue()+" "+course.getValue()+"]");
                    id.next();
                    course.next();
                }
                System.out.println();
            }
            else if(t2>=0){
                id.moveToPos(t2);
                course.moveToPos(t2);
                id.duplicate();
                course.duplicate();
                id.moveToStart();
                course.moveToStart();
                System.out.println("duplicate");
                for(int i=0;i<id.length();i++){
                    System.out.print("["+id.getValue()+" "+course.getValue()+"]");
                    course.next();
                    id.next();
                }
                System.out.println();
                id.moveToPos(t2);
                course.moveToPos(t2);
                id.update(x);
                id.moveToStart();
                course.moveToStart();
                System.out.println("update");
                for(int i=0;i<id.length();i++){
                    System.out.print("["+id.getValue()+" "+course.getValue()+"]");
                    id.next();
                    course.next();
                }
            }
             System.out.println();
            x=scn.nextInt();
            y=scn.nextInt();

        }
    }
}
