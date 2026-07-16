class Solution {
    public int steps(int i, int j, String s, String rev,int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
            if(dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == rev.charAt(j)) {
            return dp[i][j] = 1 + steps(i - 1, j - 1, s, rev,dp);
        } else {
            return dp[i][j] = Math.max(steps(i - 1, j, s, rev,dp), steps(i, j - 1, s, rev,dp));
        }

    }

    public int minInsertions(String s) {
        int m = s.length();
        String rev = "";
        for (int i = 0; i < s.length(); i++) {
            rev = s.charAt(i) + rev;
        }
         int n = rev.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i<dp.length;i++)
           for(int j=0; j<dp[0].length;j++) dp[i][j] = -1;
        return m - steps(m - 1, n - 1, s, rev,dp);
        
    }
}