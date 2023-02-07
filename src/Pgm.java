
public class Pgm {
    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data=data;
        }
    }
    public void printIdenticalNodeParent(TreeNode root){
        if(root!=null)
            return;
        if(root!=null && root.left!=null && root.right!=null && root.left.data == root.right.data){
            System.out.println(root.data);
        }
        printIdenticalNodeParent(root.left);
        printIdenticalNodeParent(root.right);

    }

    static class Singleton{
        private static Singleton instance=null;
        public static synchronized Singleton getInstance(){
            if(instance==null)
                instance = new Singleton();
            return instance;
        }
    }
}
