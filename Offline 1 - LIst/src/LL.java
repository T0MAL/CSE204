public class LL<Type> extends Node<Type> implements List<Type> {
    private Node headNode;
    private Node tailNode;
    private Node currentNode;
    private int size;
    public LL(){
        headNode=new Node<Type>();
        currentNode= headNode;
        tailNode=headNode;
        size=0;
    }
    public LL(int size,int max){
        headNode=new Node<Type>();
        currentNode= headNode;
        tailNode=headNode;
        this.size=0;
    }

    public LL(int size,int max,Type[] arr){
        headNode=new Node<Type>();
        currentNode= headNode;
        tailNode=headNode;
        this.size=0;
        for(int i=0;i<size;i++){
            append(arr[i]);
        }
    }

    @Override
    public void clear() {
        assert size>0 : "List is empty";
        headNode.setNext(null);
        currentNode=headNode;
        tailNode=headNode;
        size=0;
    }

    @Override
    public void insert(Type item) {
        if(size!=0){
            Node tmp=currentNode.getNext();
            currentNode.setNext(new Node<Type>(item,currentNode.getNext(),currentNode));
            tmp.setPrev(currentNode.getNext());
            size++;
        }
        else{
            currentNode.setNext(new Node<Type>(item,currentNode.getNext(),currentNode));
            tailNode=currentNode.getNext();
            size++;
        }
    }

    @Override
    public void append(Type item) {
        tailNode.setNext(new Node<Type>(item,null,tailNode));
        tailNode=tailNode.getNext();
        size++;
    }

    @Override
    public Type remove() {
        assert size>0 : "List is empty";
        Type i = null;
        if(currentNode!=tailNode.getPrev()){
            i= (Type) currentNode.getNext().getItem();
            currentNode.setNext(currentNode.getNext().getNext());
            currentNode.getNext().setPrev(currentNode);
        }
        else if(currentNode==tailNode.getPrev()){
            i= (Type) tailNode.getItem();
            currentNode=currentNode.getPrev();
            currentNode.getNext().setNext(null);
            tailNode=currentNode.getNext();
        }
        size--;
        return i;
    }

    @Override
    public void moveToStart() {
        currentNode=headNode;
    }

    @Override
    public void moveToEnd() {
        if(size==0){
            currentNode=tailNode;
        }
        currentNode=tailNode.getPrev();
    }

    @Override
    public void prev() {
        if(currentNode.getPrev()!=null){
            currentNode=currentNode.getPrev();
        }
    }

    @Override
    public void next() {
        if(currentNode.getNext()!=tailNode){
            currentNode=currentNode.getNext();
        }
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public int currPos() {
        int tmp=0;
        Node tmp2=headNode;
        while(true){
            if(tmp2==currentNode){
                return tmp;
            }
            else{
                tmp2=tmp2.getNext();
                tmp++;
            }
        }
    }

    @Override
    public void moveToPos(int pos) {
        if(size==0&&pos==0){
            return;
        }
        assert pos>=0 && pos< size : "Out of bound";
            currentNode=headNode;
            for (int i = 0; i < pos; i++) {
                currentNode = currentNode.getNext();
        }
    }

    @Override
    public Type getValue() {
        assert size>0 : "List is empty";
        return (Type) currentNode.getNext().getItem();
    }

    @Override
    public int Search(Object item) {
        if(size==0)
            return -1;
        int tmp=0;
        Node tmp2=headNode.getNext();
        while(true){
            if(tmp2.getItem().equals(item)){
                return tmp;
            }
            else if(tmp2==tailNode){
                return -1;
            }
            else{
                tmp2=tmp2.getNext();
                tmp++;
            }
        }
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
        LL<Integer> ar = new LL<>();
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

        for (int i = 0; i < ar.length(); i++) {
            System.out.println(ar.getValue());
            ar.next();

        }
    }

}
