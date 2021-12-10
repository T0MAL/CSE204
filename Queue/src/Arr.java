public class Arr<Type> implements Queue<Type>{
    private int rear;
    private int front;
    private Type[] q;
    private int size;
    private int chunk;

    public Arr(int size,int chunk){
        this.chunk=chunk;
        this.size=size+1;
        this.rear=0;
        this.front=1;
        q= (Type[]) new Object[this.size];
    }
    public Arr(Type[] ar){
        this.size=ar.length;
        this.chunk=size;
        this.rear=0;
        this.front=1;
        q= ar;
    }

    @Override
    public void clear() {
        rear=0;
        front=1;
       // currSize=0;
    }

    @Override
    public void enqueue(Type item) {
        int l=length();
        if(l<size-1){
            rear = (rear + 1) % size;
            q[rear] = item;
        }
        else{
            Type[] tmp=q;
            int tmpSize=size;
            size=size+chunk;
            q= (Type[]) new Object[size];
            int tmpFront=front;
            int tmpRear=rear;
            clear();
            for(int i=0;i<tmp.length-1;i++){
                enqueue(tmp[tmpFront]);
                //System.out.println(tmp[tmpFront]);
                tmpFront=(tmpFront+1)%tmpSize;
            }
            enqueue(item);
        }
    }

    @Override
    public Type dequeue() {
        if(length()>=1) {
            Type tmp = q[front];
            front = (front + 1) % size;
            return tmp;
        }
        else{
            return null;
        }
    }

    @Override
    public int length() {
        return ((rear+size) - front + 1) % size;
    }

    @Override
    public Type frontValue() {
        if(length()>=1)
            return q[front];
        else
            return null;
    }

    @Override
    public Type rearValue() {
        return q[rear];
    }

    @Override
    public Type leaveQueue() {
        if(length()>=1) {
            Type tmp = q[rear];
            rear = (rear - 1) % size;
            return tmp;
        }
        else{
            return null;
        }
    }
}
