class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // memo[i][j] stores the maximum net score difference the current player can achieve
        // for the subarray nums[i...j]
        Integer[][] memo = new Integer[n][n];
        
        return maxDiff(nums, 0, n - 1, memo) >= 0;
    }
    
    private int maxDiff(int[] nums, int i, int j, Integer[][] memo) {
        // Base case: only one element left
        if (i == j) {
            return nums[i];
        }
        
        // Return cached result if already computed
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        // Option 1: Pick the leftmost element nums[i]
        int pickLeft = nums[i] - maxDiff(nums, i + 1, j, memo);
        
        // Option 2: Pick the rightmost element nums[j]
        int pickRight = nums[j] - maxDiff(nums, i, j - 1, memo);
        
        // Choose the maximum relative difference
        memo[i][j] = Math.max(pickLeft, pickRight);
        return memo[i][j];
    }
}