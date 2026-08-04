class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
       Set<Integer> ans = new HashSet<>();
        int min = nums[0];
        int max = nums[0];
        for(int num : nums){
                 ans.add(num);
                 min = Math.min(min,num);
                 max = Math.max(max,num);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = min; i<=max;i++){
            if(!ans.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}