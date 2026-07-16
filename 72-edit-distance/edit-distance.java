class Solution {
     public int min(int i, int j,String word1, String word2, int[][] dp) {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j))
         return dp[i][j] = min(i-1,j-1,word1,word2,dp);
        else{
           return dp[i][j] = Math.min(min(i-1,j,word1,word2,dp),Math.min(min(i,j-1,word1,word2,dp),min(i-1,j-1,word1,word2,dp))) + 1;
        }
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
          for(int j=0;j<n;j++) dp[i][j] = -1;
         return min(m-1,n-1,word1,word2,dp);
    }
}