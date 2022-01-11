public class BST {
    private Node root;
    BST(){
        root=null;
    }

    public void insert(int key){
        root=insertHelp(root,key);
        print(root);
        System.out.println();
    }

    private Node insertHelp(Node root,int key){
        if(root==null){
            return new Node(key,null,null);
        }
        if(key> root.getKey()){
            root.setRight(insertHelp(root.getRight(),key));
        }
        else if(key< root.getKey()){
            root.setLeft(insertHelp(root.getLeft(),key));
        }
        return root;
    }

    public Boolean find(int key){
        return findHelp(root,key);
    }
    private Boolean findHelp(Node root,int key){
        if(root==null){
            return false;
        }
        if(key== root.getKey()){
            return true;
        }
        else if(key<root.getKey()){
            return findHelp(root.getLeft(),key);
        }
        else{
            return findHelp(root.getRight(),key);
        }
    }

    public void delete(int key){
        if(find(key)) {
            root = deleteHelp(root, key);
            print(root);
            System.out.println();
        }
        else {
            System.out.println("Invalid Operation");
        }
    }

    private Node deleteHelp(Node root,int key){
        if(root==null){
            return root;
        }
        if(key>root.getKey()){
            root.setRight(deleteHelp(root.getRight(),key));
        }
        else if(key< root.getKey()){
            root.setLeft(deleteHelp(root.getLeft(),key));
        }
        else{
            if(root.getLeft()==null){
                return root.getRight();
            }
            else if(root.getRight()==null){
                return root.getLeft();
            }
            int tmp=findMin(root.getRight());
            root.setKey(tmp);
            root.setRight(deleteHelp(root.getRight(),tmp));
        }
        return root;
    }

    private int findMin(Node root){
        int tmp = 0;
        while(root!=null){
            tmp=root.getKey();
            root=root.getLeft();
        }
        return tmp;
    }

    public void traverse(String s){
        if(s.equalsIgnoreCase("In")){
            inOrder(root);
            System.out.println();
        }
        else if(s.equalsIgnoreCase("pre")){
            preOrder(root);
            System.out.println();
        }
        else if(s.equalsIgnoreCase("post")){
            postOrder(root);
            System.out.println();
        }
    }

    private void inOrder(Node root){
        if(root!=null){
            inOrder(root.getLeft());
            System.out.print(root.getKey()+" ");
            inOrder(root.getRight());
        }
    }

    private void preOrder(Node root){
        if(root!=null){
            System.out.print(root.getKey()+" ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    private void postOrder(Node root){
        if(root!=null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getKey()+" ");
        }
    }


    private void print(Node root){
        if(root!=null){
            System.out.print(root.getKey());
            if(root.getLeft()!=null||root.getRight()!=null){
                System.out.print("(");
                print(root.getLeft());
                System.out.print(")");
                System.out.print("(");
                print(root.getRight());
                System.out.print(")");
            }
        }
    }
}
