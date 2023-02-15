package leetcode;

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int ns, ne = 0;
        // find new start merge point
        int l = 0, r = intervals.length - 1, m=0;
        int left = 0, right = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (newInterval[0] >= intervals[m][0] && newInterval[0] <= intervals[m][1]) //insert point lies between
                break;
            else if (newInterval[0] < intervals[m][0]) { // insert point lies left side
                r = m - 1;
            } else // insert point lies right side
            {
                l = m + 1;
            }
        }
        if (m >= l && m <= r) {
            ns = Math.min(intervals[m][0], newInterval[0]);
            l = m;
            r = intervals.length - 1;
            left = m - 1;
        } else if (m == l) { //left insert point
            ns = newInterval[0];
            l = m;
            r = intervals.length - 1;
            left = m - 1;
        } else {
            ns = newInterval[0];
            l = m + 1;
            r = intervals.length - 1;
            left = m;
        }
        // new end interval lookup and fix
        while (l <= r) {
            m = l + (r - l) / 2;
            if (newInterval[1] >= intervals[m][0] && newInterval[1] <= intervals[m][1]) {
                break;
            } else if (newInterval[1] < intervals[m][0]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (m >= l && m <= r) {
            right = m + 1;
            ne = Math.max(newInterval[1], intervals[m][1]);
        } else if (m == l) //left insert point
        {
            right = m;
            ne = newInterval[1];
        } else {
            right = m + 1;
            ne = newInterval[1];
        }
        int size = left + 2 + (intervals.length - right);

        int[][] ans = new int[size][2];
        int i = 0;
        while (i <= left) {
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
            i++;
        }
        ans[i][0] = ns;
        ans[i][1] = ne;
        i++;
        while (right < intervals.length) {
            ans[i][0] = intervals[right][0];
            ans[i][1] = intervals[right][1];
            right++;
            i++;
        }
        return ans;
    }

}
