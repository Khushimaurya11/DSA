class Solution {
     public int ways(int i,int[] arr, int target) {
        if(i == arr.length){
            if(target == 0) return 1;//1 valid way
            else return 0;
        }
      int add = ways(i+1,arr,target-arr[i]);
      int subs = ways(i+1,arr,target+arr[i]);
      return add+subs;
    }
    public int findTargetSumWays(int[] arr, int target) {
        return ways(0,arr,target);
    }
}