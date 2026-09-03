import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (pLen > sLen) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill initial frequency arrays for the length of p
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Check the first window
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Slide the window across s
        for (int i = pLen; i < sLen; i++) {
            // Add the new character entering the window
            sCount[s.charAt(i) - 'a']++;
            // Remove the character leaving the window
            sCount[s.charAt(i - pLen) - 'a']--;

            // If frequencies match, record the start index of the current window
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}