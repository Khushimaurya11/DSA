class Solution {
    /*
     public int steps(int n,int[] dp) {
        if(n <= 1) return 1; 
        if(dp[n] != -1) return dp[n];
        return dp[n] = steps(n-1,dp)+steps(n-2,dp);
             }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return steps(n,dp);
    }
    */
    public int climbStairs(int n){
        if(n <=1) return 1;
        int first = 1;
        int second = 1;
        for(int i =  2; i<=n; i++){
            int current = first+ second;
            first = second;
            second = current;


        }
        return second;
    }
}