class Solution {
       public int amount(int[] nums,int i,int end,int[][] dp) {
        if(i > end) return 0;
        if(dp[i][end] != -1) return dp[i][end];
        int pick = nums[i] + amount(nums,i+2,end,dp);
        int skip = amount(nums,i+1,end,dp);
        return dp[i][end] = Math.max(pick,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row,-1);
      int firstRob =  amount(nums,0,n-2,dp);
        int secondRob =  amount(nums,1,n-1,dp);
        return Math.max(firstRob,secondRob);
    }
}