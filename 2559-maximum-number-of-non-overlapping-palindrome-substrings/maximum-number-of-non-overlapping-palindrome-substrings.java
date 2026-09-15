class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int n = s.length();
        int lastEnd = -1; // End index of the last selected non-overlapping palindrome

        for (int i = 0; i < n; i++) {
            // Check odd-length center at i
            int l = i, r = i;
            while (l > lastEnd && r < n && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len >= k) { // Found shortest valid palindrome of length k or k + 1
                    count++;
                    lastEnd = r;
                    break;
                }
                l--;
                r++;
            }

            // Check even-length center between i and i + 1
            l = i;
            r = i + 1;
            while (l > lastEnd && r < n && s.charAt(l) == s.charAt(r)) {
                int len = r - l + 1;
                if (len >= k) { // Found shortest valid palindrome of length k or k + 1
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