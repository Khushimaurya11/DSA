public class sqrt {
    class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
      int l = 1;
      int r = x;
      int ans = 1;
     while(l <= r){
        int mid = l + (r-l)/2;
        if(x < (long)mid*mid) {
            r = mid - 1;
        }
        else{
            ans = Math.max(ans,mid);
            l = mid  + 1;
        }
     }
     return ans;
    }


    public static void main(String[] args) {
        sqrt sol = new sqrt();
        int x = 8;
        int result = sol.new Solution().mySqrt(x);
        System.out.println(result); // Output: 2
    }
    }
}