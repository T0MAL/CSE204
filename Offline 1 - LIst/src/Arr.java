public class Arr <Type> implements List<Type> {
    private Type[] list;
    private int currPos;
    private int size;
    private int maxSize;
    private int chunk;

    public Arr(){
        maxSize=10;
        this.size=0;
        chunk=10;
        this.currPos=0;
        list = (Type[]) new Object[maxSize];
    }

    public Arr(int size,int maxSize,Type[] arr){
        this.size=0;
        this.maxSize=maxSize;
        chunk=maxSize;
        this.currPos=0;
        list = (Type[]) new Object[maxSize];
        for(int i=0;i<size;i++)
            append(arr[i]);
    }


    public Arr(int size,int maxSize){
        this.size=0;
        this.maxSize=maxSize;
        chunk=maxSize;
        this.currPos=0;
        list = (Type[]) new Object[maxSize];
    }

    @Override
    public void clear() {
        assert size>0 : "List is already empty";
        size=currPos=0;
    }

    @Override
    public void insert(Type item) {
        if(size<maxSize){
            for(int i=size;i>currPos;i--){
                list[i]=list[i-1];
            }
            list[currPos]=item;
            size++;
        }
        else{
            Type[] l=list;
            maxSize=maxSize+chunk;
            list = (Type[]) new Object[maxSize];
            size=0;
            for(int i=0;i<l.length;i++){
                append(l[i]);
            }
            insert(item);
        }
    }

    @Override
    public void append(Type item) {
        if(size<maxSize){
            list[size]= (Type) new Object();
            list[size]=item;
            size++;
        }
        else{
            Type[] l=list;
            maxSize=maxSize+chunk;
            list = (Type[]) new Object[maxSize];
            size=0;
            for(int i=0;i<l.length;i++){
                append(l[i]);
            }
            list[size]=item;
            size++;
        }
    }

    @Override
    public Type remove() {
        assert size>0 : "List is empty";
        Type gg=list[currPos];
        for(int i=currPos;i<size-1;i++){
            list[i]=list[i+1];
        }
        size--;
        if(currPos>=size){
            currPos--;
        }
        return gg;
    }

    @Override
    public void moveToStart() {
        currPos=0;
    }

    @Override
    public void moveToEnd() {
        if(size>0)
            currPos=size-1;
    }

    @Override
    public void prev() {
        if(currPos>0)
            currPos--;
    }

    @Override
    public void next() {
        if(currPos<size-1)
            currPos++;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public int currPos() {
        return currPos;
    }

    @Override
    public void moveToPos(int pos) {
        if(size==0&&pos==0){
            return;
        }
        assert pos>=0 && pos< size : "Out of bound";
        if(pos>=0 && pos< size)
            currPos=pos;
    }

    @Override
    public Type getValue() {
        assert size>0 : "List is empty";
        return list[currPos];
    }

    @Override
    public int Search(Type item) {
        for(int i=0;i<size;i++){
            if(list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public void update(Type item){
        if(currPos()==size-1){
            remove();
            append(item);
            return;
        }
        remove();
        insert(item);
    }

    public void duplicate(){
        insert(getValue());
    }

    public static void main(String[] args) {
        Arr<Integer> ar=new Arr<>();
        ar.append(1);
        ar.append(2);
        ar.append(3);
        ar.append(4);
        ar.append(5);
        ar.moveToPos(4);
        ar.update(69);
       // System.out.println(ar.getValue());
        ar.moveToPos(3);
        ar.duplicate();
        ar.moveToStart();

        for(int i=0;i<ar.length();i++){
            System.out.println(ar.getValue());
            ar.next();

        }
    }


}
