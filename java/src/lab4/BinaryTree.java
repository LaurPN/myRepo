package lab4;

public class BinaryTree<T extends Comparable<T>> {
   static class Node<V> {
       V data;
       Node<V> left, right;

       public Node(V data) {
           this.data = data;
           left = null;
           right = null;
       }
   }

    Node<T> first;

    public BinaryTree() {
        this.first = null;
    }

    public void add(T val){
        first = insert_Recursive(first, val);
    }

    private Node<T> insert_Recursive(Node<T> root, T val){
        if (root == null) {
            root = new Node<>(val);
            return root;
        }
        if (val.compareTo(root.data) < 0) {
            root.left = insert_Recursive(root.left, val);
        } else if (val.compareTo(root.data) > 0) {
            root.right = insert_Recursive(root.right, val);
        }
        return root;
    }

    public void inorder(){
        inorder_Recursive(first);
    }

    private void inorder_Recursive(Node<T> root){
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.data + " ");
            inorder_Recursive(root.right);
        }
    }
}
