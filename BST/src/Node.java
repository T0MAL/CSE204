public class Node {
    private int key;
    private Node left;
    private Node right;
    Node(int key){
        this.key=key;
        this.left=null;
        this.right=null;
    }

    Node(int key,Node left,Node right){
        this.key=key;
        this.left=left;
        this.right=right;
    }

    protected Node getRight() {
        return right;
    }

    protected int getKey() {
        return key;
    }

    protected Node getLeft() {
        return left;
    }

    protected void setKey(int key) {
        this.key = key;
    }

    protected void setRight(Node right) {
        this.right = right;
    }

    protected void setLeft(Node left) {
        this.left = left;
    }
}
