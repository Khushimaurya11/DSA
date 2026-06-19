
class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for(int i = 1; i< n; i++){
            //nums[0] = nums[0] + 0;
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] result = sol.runningSum(nums);
        for(int num : result){
            System.out.print(num + " "); // Output: 1 3 6 10
        }
    }
}