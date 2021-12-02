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
        setDirection(dir);
        this.dir=dir;
        this.chunk=lst.length;
        size=lst.length;
        for(int i=0;i<lst.length;i++){
            push(lst[0]);
        }
    }

    @Override
    public void clear() {
        if(dir==1)
            top=-1;
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
        else{
            if (top >0)
                stack[--top] = item;
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
        assert l>1:"Stack is empty";
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
            return size-top;
    }

    @Override
    public Type topValue() {
        int l=length();
        assert l!=0:"Stack is empty";
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
        Arr<Integer> a=new Arr<>(5,19);
        a.push(1);
        a.push(2);
        a.push(3);
        System.out.println(a.pop());
        System.out.println(a.pop());
        a.push(69);
        System.out.println(a.pop());
        System.out.println(a.length());
        System.out.println(a.pop());
        System.out.println(a.pop());
    }

}
