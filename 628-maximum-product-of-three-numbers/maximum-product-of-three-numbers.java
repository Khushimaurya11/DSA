import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // Option A: 3 largest elements
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        
        // Option B: 2 smallest elements (negative) * 1 largest element
        int option2 = nums[0] * nums[1] * nums[n - 1];
        
        return Math.max(option1, option2);
    }
}