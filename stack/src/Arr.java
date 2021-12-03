public class Arr<Type> implements Stack<Type> {

    private int size;
    private int top;
    private int chunk;
    private Type[] stack;
    private int dir;

    Arr(int size,int chunk){
        this.chunk=chunk;
        this.size=size;
        stack= (Type[]) new Object[size];
        top=-1;
        dir=1;
    }

    Arr(Type[] lst,int dir){
        this.dir=dir;
        this.chunk=lst.length;
        this.size=lst.length;
        if(dir==-1){
            top=size;

        }
        else{
            top=-1;
        }
        stack=lst;
        //System.out.println(stack);
    }

    @Override
    public void clear() {
        int l=length();
        assert l>0:"Stack is empty";
        if(dir==1) {
            top = -1;
        }
        else{
            top=size;
        }
    }

    @Override
    public void push(Type item) {
        if(dir==1) {
            if (top < size-1)
                stack[++top] = item;
            else {
                Type[] tmp = stack;
                size=size+chunk;
                stack = (Type[]) new Object[size];
                top=-1;
                for (int i = 0; i < tmp.length; i++) {
                    push(tmp[i]);
                }
                push(item);
            }
        }
        else if(dir==-1){
            if (top>0){
                stack[--top] = item;}
            else {
                Type[] tmp = stack;
                size=size+chunk;
                stack = (Type[]) new Object[size];
                top=size;
                for (int i = 0; i < tmp.length; i++) {
                    push(tmp[i]);
                }
                push(item);
            }
        }
    }

    @Override
    public Type pop() {
        int l=length();
        assert l>0:"Stack is empty";
        if(dir==1)
            return stack[top--];
        else
            return stack[top++];
    }

    @Override
    public int length() {
        if(dir==1)
            return top+1;
        else
            return (size-top);
    }

    @Override
    public Type topValue() {
        int l=length();
        assert l>0:"Stack is empty";
        return stack[top];
    }

    @Override
    public void setDirection(int dir) {
        if(top==-1&&dir==-1){
            top=size;
            this.dir=dir;
        }
        else if(top==size&&dir==1){
            top=-1;
            this.dir=dir;
        }
    }

    public static void main(String[] args) {
        Integer[] arra=new Integer[6];
        Arr<Integer> a1=new Arr<>(arra,1);
        Arr<Integer> a2=new Arr<>(arra,-1);
        a1.push(1);
        a1.push(2);
        a1.push(3);
        a2.push(1);
        a2.push(2);
        a2.push(3);
        for(int i=0;i<6;i++){
            System.out.println(arra[i]);
        }
//        System.out.println(a2.pop());
//        System.out.println(a2.pop());
//        System.out.println(a2.pop());
//        a2.pop();
//        a2.pop();
//        a2.pop();
//        a1.pop();
//        a1.pop();
//        a1.pop();

      //  System.out.println(a2.pop());
       // System.out.println(a2.top);
    }
}
