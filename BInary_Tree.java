import java.util.LinkedList;
import java.util.Queue;

public class BInary_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    public static void preorder(Node root){//O(n) Root Left Right
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
        //It starts from TOP 
        //and goes to BOTTOM LEFT and 
        //then goes to TOP RIGHT and prints evrything.
    }
    public static void inorder(Node root){//O(n) Left Root Right
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        // It start from the LEFT BOTTOM 
        //and goes UP till the START node 
        //then goes to TOP RIGHT and prints the rest.
    }
    public static void postorder(Node root){//O(n) Left Right Root
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" "); 
        // It start from BOTTOM LEFT then goes
        //to BOTTOM RIGHT then after 
        //prints everything with starting node at the LAST.
    }
    public static void levelOrder(Node root){//O(n) It prints the roots level by level.
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static int countOfNodes(Node root){//O(n)
        if(root==null){
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes+rightNodes+1;

    }
    public static int SumOfNodes(Node root){//O(n)
        if(root==null){
            return 0;
        }
        int leftSum = SumOfNodes(root.left);
        int rightSum = SumOfNodes(root.right);

        return leftSum+rightSum+root.data;
    }
    public static int height(Node root){//O(n)
        if(root==null){
            return 0;
        }
        int leftheight = height(root.left);
        if(leftheight==-1) return -1;
        int rightheight = height(root.right);
        if(rightheight==-1)return -1;

        if(Math.abs(rightheight-leftheight)>1) return -1;

        int myheight = Math.max(leftheight, rightheight)+1;

        return myheight;
    }
    public static boolean IsBalanced(Node root){
        return height(root)!=-1;
    }
    
    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht,int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static TreeInfo diameter(Node root){//O(n)
        if(root==null){
           return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int myheight = Math.max(left.ht, right.ht)+1;
        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht+right.ht+1;

        int mydiam = Math.max(Math.max(diam1,diam2),diam3);
        TreeInfo myInfo = new TreeInfo(myheight, mydiam);

        return myInfo;
    }
    public static void main(String args[]) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1,7,-1,-1,8};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        
    }
}
