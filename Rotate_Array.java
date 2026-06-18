public class Rotate_Array {
    class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
       k %= n;
    reverse(nums,0,n-1);
    reverse(nums,0,k-1);
    reverse(nums,k,n-1);
    }
public void reverse(int[] nums, int start, int end){
    while(start<end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}

    }

    public static void main(String[] args) {
        Rotate_Array sol = new Rotate_Array();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        sol.new Solution().rotate(nums, k);
        System.out.print("Rotated array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
