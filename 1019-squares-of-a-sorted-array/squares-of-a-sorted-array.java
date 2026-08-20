class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int  i =0;
        int k = n-1;
         int j = n-1;
        while(i<=j){
          int fs = nums[i]*nums[i];
          int ss = nums[j]*nums[j];
            if(ss > fs){
                result[k] = ss;
                j--;
                k--;
            }
            else{
           result[k] = fs;
           k--;
           i++;
            }
        }
        return result;
    }
}