public class LL<Type> extends Node<Type> implements Stack<Type> {



    private Node headNode;
    private Node tailNode;
    private int size;
    public LL(){
        headNode=new Node<Type>();
        //currentNode= headNode;
        tailNode=headNode;
        size=0;
    }

    @Override
    public void clear() {
        tailNode=headNode;
        size=0;
    }

    @Override
    public void push(Type item) {
        tailNode.setNext(new Node(item,null,tailNode));
        tailNode=tailNode.getNext();
        size++;
    }

    @Override
    public Type pop() {
        Type tmp= (Type) tailNode.getItem();
        tailNode.getPrev().setNext(null);
        tailNode=tailNode.getPrev();
        return tmp;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public Type topValue() {
        return (Type) tailNode.getItem();
    }

    @Override
    public void setDirection(int dir) {

    }
}
