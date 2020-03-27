public class BinarySearchTree<E extends Comparable<E>> {

    private int size;
    private Node<E> root;

    public BinarySearchTree() {

    }

    public void add(E obj) {
        if(root == null) {
            root = new Node<>(obj);
            size = 1;
        }
        else if(root.insert(obj)) 
            size++;
    }

    public int size() {
        return size;
    }

    public static class Node<E extends Comparable<E>> {
        
        private E value;
        private Node<E> left;
        private Node<E> right;

        public Node(E value) {
            this.value = value;
        }

        public boolean insert(E obj) {
            int c = obj.compareTo(value);
            if(c > 0) {
                if(right == null) {
                    right = new Node<>(obj);
                    return true;
                }
                else 
                    return right.insert(obj);
            } else if(c < 0) {
                if(left == null)  {
                    left = new Node<>(obj);
                    return true;
                }
                else 
                    return left.insert(obj);
            }
            return false;
        }

        public E getValue() {
            return value;
        }
        
        public Node<E> getLeft() {
            return left;
        }
        
        public Node<E> getRight() {
            return right;
        }
        
        public void setValue(E value) {
            this.value = value;
        }
        
        public void setLeft(Node<E> left) {
            this.left = left;
        }
        
        public void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return value.toString();
        }

    }

}