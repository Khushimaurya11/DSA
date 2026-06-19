public class removeDuplicate {
    class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

    public static void main(String[] args) {
        removeDuplicate sol = new removeDuplicate();
        int[] nums = {1, 1, 2};
        int result = sol.new Solution().removeDuplicates(nums);
        System.out.println(result); // Output: 2
    }
}
