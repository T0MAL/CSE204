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

    public LL(int size,int chunk){
        headNode=new Node<Type>();
        //currentNode= headNode;
        tailNode=headNode;
        this.size=0;
    }

    @Override
    public void clear() {
        int l=length();
        assert l>0:"Stack is empty";
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
        int l=length();
        assert l>0:"Stack is empty";
        Type tmp= (Type) tailNode.getItem();
        tailNode.getPrev().setNext(null);
        tailNode=tailNode.getPrev();
        size--;
        return tmp;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public Type topValue() {
        int l=length();
        assert l>0:"Stack is empty";
        return (Type) tailNode.getItem();
    }

    @Override
    public void setDirection(int dir) {
        //ignore
    }
}
