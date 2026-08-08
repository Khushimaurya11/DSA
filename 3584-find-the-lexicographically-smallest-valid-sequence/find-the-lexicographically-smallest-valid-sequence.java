import java.util.Arrays;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // lastPos[j] stores the largest index in word1 from which 
        // word2[j...m-1] can be formed as a subsequence.
        int[] lastPos = new int[m + 1];
        Arrays.fill(lastPos, -1);
        lastPos[m] = n;

        int w1Idx = n - 1;
        for (int w2Idx = m - 1; w2Idx >= 0; w2Idx--) {
            while (w1Idx >= 0 && word1.charAt(w1Idx) != word2.charAt(w2Idx)) {
                w1Idx--;
            }
            if (w1Idx >= 0) {
                lastPos[w2Idx] = w1Idx;
                w1Idx--;
            } else {
                break;
            }
        }

        int[] result = new int[m];
        boolean changed = false;
        int ptr = 0;

        for (int i = 0; i < m; i++) {
            boolean matched = false;

            while (ptr < n) {
                if (word1.charAt(ptr) == word2.charAt(i)) {
                    result[i] = ptr;
                    ptr++;
                    matched = true;
                    break;
                } else if (!changed && lastPos[i + 1] > ptr) {
                    // Try changing word1[ptr] to word2[i]
                    result[i] = ptr;
                    ptr++;
                    changed = true;
                    matched = true;
                    break;
                }
                ptr++;
            }

            if (!matched) {
                return new int[0];
            }
        }

        return result;
    }
}