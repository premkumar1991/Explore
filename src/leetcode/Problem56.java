package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        for(int i=0;i< intervals.length;++i){
            int[] newInterval = {intervals[i][0],intervals[i][1]};
            while(i+1< intervals.length&&intervals[i+1][0]<=newInterval[1]){
                newInterval[0]=Math.min(newInterval[0],intervals[i+1][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i+1][1]);
                ++i;
            }
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
