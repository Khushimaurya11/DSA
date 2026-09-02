class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int  i = 0;
        int  j = 0;
        int max = 0;
        HashSet<Character> res = new HashSet<>(); 
        while(j < n){
           if(res.contains(s.charAt(j))){
            res.remove(s.charAt(i));
            i++;
           }else{
            res.add(s.charAt(j));
            max = Math.max(max,j-i+1);
            j++;
           }
        }
        return max;
    }
}