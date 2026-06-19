
class Majority_Element {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        /*
        for(int i = 0; i< n; i++){
                int cnt = 0;
            for(int j = i; j<n; j++){
          if(nums[i] == nums[j]) cnt++;
         
            }
             if(cnt > n/2) return nums[i];
        }
       return -1;
      */
      int curr = 0;
      int cnt = 0;
      for(int i = 0; i<n; i++){
        if(cnt == 0) {
            curr = nums[i];
        }
        if(nums[i] == curr) cnt++;
        else cnt--;
      }
      return curr;
    }
    public static void main(String[] args) {
        Majority_Element sol = new Majority_Element();
        int[] nums = {3, 2, 3};
        int result = sol.majorityElement(nums);
        System.out.println(result); // Output: 3
    }
}