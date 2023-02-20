# General approach to subsets Problem78
- Input: nums = [1,2,3]
- Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Usually permutation problems are recursion and backtracking

    subsets can have two choice either you can choose the current element or you can leave it

so 2^n choices is your space and time complexity
additional time complexity, you want to copy the array when computing results
this takes n^2 time. O((2^n)*(n))


```
* Approach1 
  * choice recursion, it doesn't maintain lexicographically order, if your input is sorted
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


* Approach2 
  * carry next index and progress, remove the taken one once you back from recursion(backtracking)
  * it guarantee lexigrophical order if input is sorted

 class Solution {
   List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(0,nums,new ArrayList<>());
        return res;
    }
    private void generateSubsets(int idx,int[] input,List<Integer> acc){
        if(idx==input.length){
            res.add(new ArrayList<>(acc));
            return;
        }
        res.add(new ArrayList<>(acc));// copy takes n time
        for(int i=idx;i<input.length;++i){
            acc.add(input[i]);
            generateSubsets(i+1,input,acc);
            acc.remove(acc.size()-1);
        }
    }
}
 
 Approach3
  * generate binary number from 0 to 2*n-1, it maintains lexigraphical order

Approach 4 (iterative cascading)
class Solution {
   List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num:nums){
            List<List<Integer>> newSets = new ArrayList();
            for(List<Integer> oldSet:res){
                // add the curr element to the existing res list
                newSets.add(new ArrayList<>(oldSet){{add(num);}});  // Ntimes copy, so 2^n * n space & time
            }
            // add the newsets back to the result list
            for(List<Integer> newSet:newSets)
                res.add(newSet);
        }
        return res;
    }
    
}


Additional references
https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)