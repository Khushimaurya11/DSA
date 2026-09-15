class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int n = s.length();
        int lastEnd = -1; 

        for (int i = 0; i < n; i++) {
           
            int l = i, r = i;
            while (l > lastEnd && r < n && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len >= k) { 
                    count++;
                    lastEnd = r;
                    break;
                }
                l--;
                r++;
            }

          
            l = i;
            r = i + 1;
            while (l > lastEnd && r < n && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len >= k) {
                    count++;
                    lastEnd = r;
                    break;
                }
                l--;
                r++;
            }
        }

        return count;
    }
}
