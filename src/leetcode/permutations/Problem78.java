package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(0,nums,new ArrayList<>());
        return res;
    }

    // time - O(2^n*n) space - O(2^n)
    private void generateSubsets1(int idx,int[] input,List<Integer> acc){
        res.add(new ArrayList<>(acc));// copy takes n time, may be 1length,2length --- sum
        for(int i=idx;i<input.length;++i){
            acc.add(input[i]);
            generateSubsets(i+1,input,acc);
            acc.remove(acc.size()-1);
        }
    }

    private void generateSubsets(int idx,int[] input,List<Integer> acc){
        if(idx==input.length){
            res.add(new ArrayList<>(acc));
            return;
        }
        generateSubsets(idx+1,input,acc);
        acc.add(input[idx]);
        generateSubsets(idx+1,input,acc);
        acc.remove(acc.size()-1);
    }
}
