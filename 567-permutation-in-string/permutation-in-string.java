class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i = 0;
        int j = n;
        int[] sFreq = new int[26];
        int[] windowFreq = new int[26];
       if(n > m) return false;
        for(int k =0; k<n; k++){
            sFreq[s1.charAt(k) - 'a']++;
            windowFreq[s2.charAt(k)-'a']++;
        }
        while(j <= m){
            if(Arrays.equals(sFreq,windowFreq)){
                return true;
            }
            if(j == m) break;
             windowFreq[s2.charAt(i) - 'a']--;
             i++;
             windowFreq[s2.charAt(j) - 'a']++;
             j++;
        }
        return false;
    }
}