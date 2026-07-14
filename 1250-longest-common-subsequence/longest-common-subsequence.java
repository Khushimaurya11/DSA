class Solution {
    static int[][] dp;
    public int longest(int i,int j,String text1, String text2) {
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            return  dp[i][j]=1 + longest(i-1,j-1,text1,text2);
        }
        else{
           int first =  longest(i-1,j,text1,text2);
           int second = longest(i,j-1,text1,text2);
           return dp[i][j]= Math.max(first,second);
        }
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
      int m = text1.length();
      int n = text2.length();
      dp = new int[m][n];
      for(int i=0;i<dp.length;i++)
          for(int j =0;j<dp[0].length;j++) dp[i][j] = -1;
      return  longest(m-1,n-1,text1,text2);
    }
}