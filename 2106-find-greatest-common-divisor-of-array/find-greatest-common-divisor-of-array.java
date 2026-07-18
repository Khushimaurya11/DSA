class Solution {
    public int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    /*
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return gcd(nums[0],nums[n-1]); 
    }
    */
    public int findGCD(int[] nums){
        int n = nums.length;
        int min =nums[0];
        int max = nums[0];
        for(int i=1; i<n;i++){
            if(nums[i] < min ) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
        return gcd(min,max);
    }
}