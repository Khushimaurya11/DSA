class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        int i = 0;
        int j = m;
        int[] pFreq = new int[26];
        int[] countWindow = new int[26];
        List<Integer> res = new ArrayList<>();
        if(m > n) return res;
        for (int k = 0; k < m; k++) {
            pFreq[p.charAt(k) - 'a']++;
            countWindow[s.charAt(k) - 'a']++;
        }
        while (j <= n) {
            if (Arrays.equals(pFreq, countWindow)) {
                res.add(i);
            }
            if(j==n) break;
                countWindow[s.charAt(i) - 'a']--;
                i++;
                countWindow[s.charAt(j) - 'a']++;
               j++;
        }

        return res;
    }
}