public class Node<Type>{
    private Type item;
    private Node next;
    private Node prev;


    public Node(Type item,Node next,Node prev){
        this.item=item;
        this.next=next;
        this.prev=prev;
    }
    public Node(){
        this.item=null;
        this.next=null;
        this.prev=null;
    }
    protected Node getNext() {
        return next;
    }

    protected Type getItem() {
        return item;
    }

    protected void setItem(Type item) {
        this.item = item;
    }

    protected void setNext(Node next) {
        this.next = next;
    }

    protected Node getPrev() {
        return prev;
    }

    protected void setPrev(Node prev) {
        this.prev = prev;
    }
}
