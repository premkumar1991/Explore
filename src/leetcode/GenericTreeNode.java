package leetcode;

public class GenericTreeNode <T>{
    T val;
    GenericTreeNode left;
    GenericTreeNode right;
    public GenericTreeNode(T val){
        this.val=val;
    }
    public GenericTreeNode(T val, GenericTreeNode left, GenericTreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
