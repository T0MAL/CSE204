public class LL<Type> extends Node<Type> implements Queue<Type> {
    private Node headNode;
    private Node tailNode;
    private int size;
    public LL(){
        headNode=new Node<Type>(null,null,null);
        tailNode=headNode;
        size=0;
    }

    @Override
    public void clear() {
        headNode.setNext(null);
        headNode.setItem(null);
        tailNode=headNode;
        size=0;
    }

    @Override
    public void enqueue(Type item) {
            tailNode.setNext(new Node(item, null, tailNode));
            tailNode = tailNode.getNext();
            size++;
    }

    @Override
    public Type dequeue() {
        if(size==1){
            Type tmp = (Type) headNode.getNext().getItem();
            clear();
            return tmp;
        }
        if(size!=0) {
            Type tmp = (Type) headNode.getNext().getItem();
            Node tm=headNode;
            headNode.setNext(headNode.getNext().getNext());
            headNode.getNext().setPrev(tm);
            size--;
            return tmp;
        }
        else{
            return null;
        }
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public Type frontValue() {
        if(length()>=1)
            return (Type) headNode.getNext().getItem();
        else
            return null;
    }

    @Override
    public Type rearValue() {
        if(length()>=1)
            return (Type) tailNode.getItem();
        else
            return null;
    }

    @Override
    public Type leaveQueue() {
        if(length()>=1){
            Type tmp= (Type) tailNode.getItem();
            tailNode=tailNode.getPrev();
            tailNode.setNext(null);
            size--;
            return tmp;
        }
        else{
            return null;
        }
    }
}
