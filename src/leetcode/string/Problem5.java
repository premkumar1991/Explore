package leetcode.string;

public class Problem5 {
        public String longestPalindrome(String s) {
            int len=s.length();
            boolean[][] dp=new boolean[len][len];
            int l=0,r=1;
            // 1 length prefill
            for(int i=0;i<len;i++){
                dp[i][i]=true;
            }
            // 2 length prefill
            for(int i=0;i<len;i++){
                if(i+1<len&&dp[i]==dp[i+1])
                    dp[i][i+1]=true;
            }
            // >3 length
            for(int i=2;i<len;i++){
                for(int j=0;j+i<len;j++){
                    if(dp[j+1][j+i-1]&&dp[j]==dp[j+i]){
                        dp[j][j+i]=true;
                        l=j;
                        r=j+i+1;
                    }
                }
            }
            return s.substring(l,r);
        }

}
