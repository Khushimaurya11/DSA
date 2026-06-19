public class Missing_number {
    class Solver {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i = 0; i<= n ; i++){
            xor = xor^i;
        }
        for(int i = 0; i<n ; i++){
            xor = xor^nums[i];
        }
        return xor;
    }
}

    public static void main(String[] args) {
        Missing_number sol = new Missing_number();
        int[] nums = {3, 0, 1};
        int result = sol.new Solver().missingNumber(nums);
        System.out.println(result); // Output: 2
    }
}
