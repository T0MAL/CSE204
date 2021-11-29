public class Main {
    public static void main(String[] args) {
        Arr<Integer> array=new Arr<>(5,10);
      //  LL<Integer> array=new LL<>();
        array.setDirection(1);
        array.push(69);
        array.push(96);
        array.push(1);
        array.push(34);
        array.push(23);
        array.push(77);
        System.out.println(array.length());
     //   array.push(101);
       // System.out.println(array.pop());
        System.out.println(array.topValue());
        for(int i=0;i<6;i++){
            System.out.println(array.pop());
        }
        System.out.println(array.length());
        System.out.println(array.topValue());
     //   array.clear();

    }
}
