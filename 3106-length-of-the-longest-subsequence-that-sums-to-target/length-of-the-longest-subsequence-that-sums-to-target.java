class Solution {
    public int count(int i, List<Integer> nums, int target,  int[][] dp) {
        if (target == 0)
            return 0;
        if (i == nums.size() || target < 0) {
            return Integer.MIN_VALUE;
        }
        if(dp[i][target] != -1) return dp[i][target];
        int pick = 1 + count(i + 1, nums, target - nums.get(i),dp);
        int skip = count(i + 1, nums, target,dp);
        return  dp[i][target] = Math.max(pick, skip);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n+1][target+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        int result = count(0, nums, target,dp);
        return result < 0 ? -1 : result;
    }
}