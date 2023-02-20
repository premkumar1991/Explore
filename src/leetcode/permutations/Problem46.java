package leetcode.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem46 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        //Set<Integer> idx=new HashSet<>();
        //permute(nums,idx,new ArrayList<>());
        List<Integer> numsList = new ArrayList<>();
        for(int i:nums)
            numsList.add(i);
        permute(0,nums.length, numsList);
        return res;
    }
    // Approach 2 with hashset to avoid same element adding again
//     public void permute(int[] nums,Set<Integer> idx,List<Integer> acc){
//         if(acc.size()==nums.length)
//         {
//             res.add(new ArrayList<>(acc));
//             return;
//         }
//         for(int i=0;i<nums.length;i++){
//             if(!idx.contains(i)){
//                 acc.add(nums[i]);
//                 idx.add(i);
//                 permute(nums,idx,acc);
//                 acc.remove(acc.size()-1);
//                 idx.remove(i);
//             }
//         }
//     }

    // Approach using swap
    public void permute(int idx,int n,List<Integer> nums){
        if(idx==n){
            res.add(new ArrayList<>(nums));
        }
        for(int i=idx;i<n;++i){
            Collections.swap(nums,idx,i);
            permute(idx+1,n,nums);
            Collections.swap(nums,idx,i);
        }

    }
}
