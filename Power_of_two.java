public class Power_of_two {
    static class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        //if(n == 1) return true;
        int ans = 1;
        double range = Math.pow(2,30);
        while(ans < n && range >= n){
           ans = ans * 2;
        }
        return ans == n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 16;
        boolean result = sol.isPowerOfTwo(n);
        System.out.println(result); // Output: true
    }
    }
}