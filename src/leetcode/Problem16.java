package leetcode;

import java.util.Arrays;

public class Problem16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, sum = 0;
        String a="";
        for (int i = 0; i < nums.length; ++i) {
            int l = 0, r = nums.length - 1;
            int t = target - nums[i];
            while (l < r) {
                if (l == i) {
                    l++;
                    continue;
                } else if (r == i) {
                    r--;
                    continue;
                }
                int nmin = t - (nums[l] + nums[r]);
                if (nmin < min) {
                    sum = nums[i] + nums[l] + nums[r];
                    a = ""+nums[i]+","+nums[l]+","+nums[r];
                    min = nmin;
                }
                if (nums[l] + nums[r] > t)
                    r--;
                else
                    l++;
            }
        }
        System.out.println(a);
        return sum;
    }

}

// -4 -1 1 2