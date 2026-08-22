class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int i = 0;
        int j = 0;
      List<Integer> ans = new ArrayList<>();

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
               ans.add(nums1[i]);
               i++;
            }
             else{
                ans.add(nums2[j]);
                j++;
            }
        }
        while(j < n){
            ans.add(nums2[j]);
            j++;
        }
        while(i < m){
            ans.add(nums1[i]);
            i++;
        }
        for(int k=0; k<m+n; k++){
            nums1[k] = ans.get(k);
        }
    }
}