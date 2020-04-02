public class BinarySearchTree<E extends Comparable<E>> {

    private int size;
    private Node<E> root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node<E> root) {
        this.root = root;
    }

    public BinarySearchTree(E obj) {
        this.root = new Node<>(obj);
    }

    public void add(E obj) {
        if(root == null) {
            root = new Node<>(obj);
            size = 1;
        }
        else if(root.insert(obj)) 
            size++;
    }

    public boolean contains(E obj) {
        return root == null? false : root.contains(obj);
    }

    public String preorder() {
        return preorder(root);
    }

    public String preorder(Node node) {
        if(node != null) {
            String s = "";
            s += node.toString();
            String temp = preorder(node.getLeft());
            if(temp.length() != 0)
                s += "\t" + temp;
            temp = preorder(node.getRight());
            if(temp.length() != 0)
                s +=  "\t" + temp;
            return s;
        } else {
            return "";
        }
    }

    public String inorder() {
        return inorder(root);
    }

    public String inorder(Node node) {
        if(node != null) {
            String s = "";
            String temp = inorder(node.getLeft());
            if(temp.length() != 0) {
                s += temp;
                s += "\t" + node.toString();
            } else {
                s += node.toString();
            }
            temp = inorder(node.getRight());
            if(temp.length() != 0)
                s +=  "\t" + temp;
            return s;
        } else {
            return "";
        }
    }

    public String postorder() {
        return postorder(root);
    }

    public String postorder(Node node) {
        if(node != null) {
            String s = "";
            String temp = postorder(node.getLeft());
            if(temp.length() != 0)
                s += temp;
            temp = postorder(node.getRight());
            if(temp.length() != 0)
                s +=  (s.length() == 0? "" : "\t") + temp;
            if(s.length() == 0) 
                s += node.toString();
            else
                s += "\t" + node.toString();
            return s;
        } else {
            return "";
        }
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

        public boolean contains(E obj) {
            return search(obj) != null;
        }

        public Node<E> search(E obj) {
            int c = obj.compareTo(value);
            if(c > 0)
                return right == null? null : right.search(obj);
            else if(c < 0)
                return left == null? null : left.search(obj);
            return this;
        }

        public void remove(E obj) {
            // Node<E> node = search(obj)
            // if(node == null) return;
            // int count = node.childCount();
            // switch()
        }

        public int childCount() {
            int i = 0;
            if(left != null) i += 1;
            if(right != null) i += 1;
            return i;
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