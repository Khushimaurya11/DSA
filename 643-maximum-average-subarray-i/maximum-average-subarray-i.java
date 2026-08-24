class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        double sum = 0;
        double avg = 0;
        double max_avg = Double.NEGATIVE_INFINITY;
        while(j < n){
           sum = sum + nums[j];
           avg = sum / k;
          if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
            max_avg = Math.max(avg,max_avg);
            sum = sum - nums[i];
            i++;
            j++;
        }
        }
        return max_avg;
    }
}