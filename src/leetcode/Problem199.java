package leetcode;

import java.util.*;

public class Problem199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Deque<TreeNode> q=new ArrayDeque<>();
        q.addFirst(root);
        List<Integer> res=new LinkedList<>();
        while(!q.isEmpty()){
            int size=q.size();
            res.add(q.getLast().val);
            while(size-->0){
                TreeNode n = q.removeFirst();
                if(n.left!=null)
                    q.addLast(n.left);
                if(n.right!=null)
                    q.addLast(n.right);
            }
        }
        return res;
    }
}
