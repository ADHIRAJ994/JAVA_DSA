public class Binary_Search_Tree {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static boolean serach(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data>key){
            return serach(root.left, key);
        }else if(root.data==key){
            return true;
        }else{
            return serach(root.right, key);
        }
    }
    public static Node delete(Node root,int val){ // In delete we use inorder successor which means smallest value in the right subtree.
        if(root.data>val){
           root.left = delete(root.left, val);
        }else if(root.data<val){
            root.right = delete(root.right, val);
        }else{
            //Case 1
            if(root.left==null&&root.right==null){
                return null;
            }
            //Case 2
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            // Case 3
            Node IS = inorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inorderSuccesor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public static void printInRange(Node root,int X,int Y){
        if(root==null){
            return;
        }
        if(root.data>=X&&root.data<=Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data+" ");
            printInRange(root.right, X, Y);
        }else if(root.data>=Y){
            printInRange(root.left, X, Y);
        }else{
            printInRange(root.right, X, Y);
        }
    }
    public static void main(String[] args){
        int values[]  ={8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i = 0;i<values.length;i++){
            root = insert(root, values[i]);
        }

        // inorder(root);
        //  System.out.println();
        // if(serach(root, 7)){
        //     System.out.println("found");
        // }else{
        //     System.out.println("Not found");
        // }
        // delete(root, 5);
        // inorder(root);

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
}
