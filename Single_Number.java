public class Single_Number {
    class Solver {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i = 0; i< n; i++){
           xor = xor ^ nums[i];
        }
        return xor;
    }
}

    public static void main(String[] args) {
        Single_Number sol = new Single_Number();
        int[] nums = {2, 2, 1};
        int result = sol.new Solver().singleNumber(nums);
        System.out.println(result); // Output: 1
    }
}
