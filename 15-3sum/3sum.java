class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
         List<List<Integer>> result = new ArrayList<>();
         Arrays.sort(nums);
         for(int i=0;i<n-2;i++){
           if(i > 0 && nums[i]==nums[i-1]){
           continue;
           }

          int s = (-1)*nums[i];
           int j = i+1;
         int k= n-1;
         while(j <k){
         int sum = nums[j]+ nums[k];
         if(sum == s){
             result.add(Arrays.asList(nums[i],nums[j],nums[k]));
         while(j<k && nums[j] == nums[j+1] ) j++;
         while(j<k && nums[k] == nums[k-1])  k--;

         j++;
         k--;
    }
    else if(sum < s){
        j++;
    }else{
        k--;
    }
         }
         }
    return result;
}

}