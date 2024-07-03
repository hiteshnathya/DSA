package Day3;

class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // insert key
    public void insert(int key) {
        root = inserting(root, key);
    }

    Node inserting(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = inserting(root.left, key);

        else if (key > root.key)
            root.right = inserting(root.right, key);

        return root;


    }
    // search key in tree (? :
    //(exp)? exp1 :exp2;

    public boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (key == root.key)
            return true;
        return key < root.key ? search(root.left, key) : search(root.right, key);

    }


    //delete method
    public Node delete(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

        }

        return root;


    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.key + " ");
            inorder(root.right);

        }
    }

    public void preorder(Node root) {
        if (root != null) {
            System.out.println(root.key + " ");
            inorder(root.left);
            inorder(root.right);

        }
    }

    public void postorder(Node root) {
        if (root != null) {

            inorder(root.left);
            inorder(root.right);
            System.out.println(root.key + " ");

        }
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(60);
        bst.insert(40);
        bst.insert(30);
        bst.insert(50);
        bst.insert(80);
        bst.insert(70);
        bst.insert(100);
        bst.inorder(bst.root);


        System.out.println(" root value");
        System.out.println(bst.root.key);
        System.out.println();

        bst.delete(bst.root, 30);
        bst.inorder(bst.root);
        System.out.println();

        bst.delete(bst.root, 70);
        bst.inorder(bst.root);
        System.out.println();

        bst.preorder(bst.root);
        System.out.println();
        bst.postorder(bst.root);


    }
}


