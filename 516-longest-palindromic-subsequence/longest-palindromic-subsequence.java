class Solution {
    public int lps(int i,int j,String s,String rev,int[][] dp){
          if(i <0 || j<0) return 0;
          if(dp[i][j] != -1) return dp[i][j] ;
          if(s.charAt(i) == rev.charAt(j)){
            return dp[i][j]  = 1 + lps(i-1,j-1,s,rev,dp);
          }
          else return dp[i][j] = Math.max(lps(i-1,j,s,rev,dp),lps(i,j-1,s,rev,dp));
    }
    public int longestPalindromeSubseq(String s) {
        String rev = "";
        for (int i = 0; i < s.length(); i++) {
  rev = s.charAt(i) + rev;
}
        int m = s.length();
        int n = rev.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++) dp[i][j] = -1;
        return lps(m-1,n-1,s,rev,dp);
    }
}