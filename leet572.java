public class leet572 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class Binarytree
    {
        static int idex=-1;
        public static Node buildTree(int nodes[])
        {
            idex++;
            if(nodes[idex]==-1)
            {
                return null;
            }
            Node newnode = new Node(nodes[idex]);
            newnode.left=buildTree(nodes);
            newnode.right=buildTree(nodes);

            return newnode;
        }
    }
    
    //subtree of another tree
    public  boolean IsIdentical(Node root,Node subroot)
    {
        if(subroot ==null &&root ==null)
        {
            return true;
        }
        if(subroot ==null || root ==null)
        {
            return false;
        }
        if(root.data==subroot.data)
        {
             return IsIdentical(root.left, subroot.left)&& IsIdentical(root.right, subroot.right);
        }
        return false;
    }
    public boolean isSubtree(Node root,Node subroot)
    {
        if(subroot ==null)
        {
            return true;
        }
        if(root ==null)
        {
            return false;
        }
        if(root.data==subroot.data)
        {
            if(IsIdentical(root, subroot))
            {
                return true;
            }
        }
        return isSubtree(root.left, subroot)|| isSubtree(root.right, subroot);

    }
    public static void main(String[] args)
    {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Binarytree tree = new Binarytree();
        Node root = tree.buildTree(nodes);

        // Create subtree
    Node subroot = new Node(2);
    subroot.left = new Node(4);
    subroot.right = new Node(5);

    // Create object to call non-static methods
    leet572 obj = new leet572();

    System.out.println("Is S1ubtree = " + obj.isSubtree(root, subroot));
    }
}