package leetcode;

public class Problem76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int l = 0, r = 0;
        int[] ascii = new int[128];
        int[] copy = new int[128];
        for (int i = 0; i < t.length(); ++i) {
            ascii[t.charAt(i)]++;
            copy[t.charAt(i)]++;
        }

        int totMatches = 0, min = s.length() + 1;
        int[] minIdx = new int[]{-1, -1};

        while (r < s.length()) {
            if (ascii[s.charAt(r)] > 0) {
                copy[s.charAt(r)]--;
                if (copy[s.charAt(r)] >= 0) //take distinct counts
                    totMatches++;
            }
            if (totMatches == t.length()) {
                while (l <= r && totMatches == t.length()) {
                    if (ascii[s.charAt(l)] > 0) {
                        copy[s.charAt(l)]++;
                        if (copy[s.charAt(l)] > 0)
                            totMatches--;
                    }
                    l++;
                }
                if (r - l + 2 < min) {
                    min = r - l + 2;
                    minIdx[0] = l - 1;
                    minIdx[1] = r + 1;
                }
            }
            r++;
        }
        if (minIdx[0] == -1)
            return "";
        return s.substring(minIdx[0], minIdx[1]);
    }


}
