import java.util.*;

class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Prime factorize t into counts of 2, 3, 5, 7
        long tempT = t;
        int[] req = new int[10]; // req[p] for prime factors 2, 3, 5, 7
        
        for (int p : new int[]{2, 3, 5, 7}) {
            while (tempT % p == 0) {
                req[p]++;
                tempT /= p;
            }
        }
        
        // If t has prime factors other than 2, 3, 5, 7, it's impossible
        if (tempT > 1) return "-1";

        int n = num.length();
        
        // Find if any 0 exists in num; if so, we must modify from or before the first 0
        int firstZero = num.indexOf('0');
        int maxPrefix = (firstZero == -1) ? n : firstZero;

        // Prefix requirements array
        int[][] prefixReq = new int[n + 1][10];
        prefixReq[0][2] = req[2];
        prefixReq[0][3] = req[3];
        prefixReq[0][5] = req[5];
        prefixReq[0][7] = req[7];

        for (int i = 0; i < maxPrefix; i++) {
            int d = num.charAt(i) - '0';
            prefixReq[i + 1][2] = Math.max(0, prefixReq[i][2] - countFactor(d, 2));
            prefixReq[i + 1][3] = Math.max(0, prefixReq[i][3] - countFactor(d, 3));
            prefixReq[i + 1][5] = Math.max(0, prefixReq[i][5] - countFactor(d, 5));
            prefixReq[i + 1][7] = Math.max(0, prefixReq[i][7] - countFactor(d, 7));
        }

        // Check if original num (if zero-free) is already valid
        if (firstZero == -1 && satisfied(prefixReq[n])) {
            return num;
        }

        // Step 2: Try to change digit at index i (from maxPrefix down to 0)
        for (int i = maxPrefix; i >= 0; i--) {
            int startDigit = (i < n) ? (num.charAt(i) - '0' + 1) : 1;
            
            for (int d = startDigit; d <= 9; d++) {
                int rem2 = Math.max(0, prefixReq[i][2] - countFactor(d, 2));
                int rem3 = Math.max(0, prefixReq[i][3] - countFactor(d, 3));
                int rem5 = Math.max(0, prefixReq[i][5] - countFactor(d, 5));
                int rem7 = Math.max(0, prefixReq[i][7] - countFactor(d, 7));

                String minSuffix = getMinSuffix(rem2, rem3, rem5, rem7);
                int remLen = (n - 1) - i;

                if (minSuffix.length() <= remLen) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(d);
                    
                    int onesNeeded = remLen - minSuffix.length();
                    for (int k = 0; k < onesNeeded; k++) sb.append('1');
                    sb.append(minSuffix);

                    return sb.toString();
                }
            }
        }

        // Step 3: If same length is impossible, expand length
        String minSuffix = getMinSuffix(req[2], req[3], req[5], req[7]);
        int targetLen = Math.max(n + 1, minSuffix.length());

        StringBuilder sb = new StringBuilder();
        int onesNeeded = targetLen - minSuffix.length();
        for (int k = 0; k < onesNeeded; k++) sb.append('1');
        sb.append(minSuffix);

        return sb.toString();
    }

    private int countFactor(int d, int p) {
        int cnt = 0;
        while (d > 0 && d % p == 0) {
            cnt++;
            d /= p;
        }
        return cnt;
    }

    private boolean satisfied(int[] rem) {
        return rem[2] <= 0 && rem[3] <= 0 && rem[5] <= 0 && rem[7] <= 0;
    }

    // Greedily builds the smallest lexicographical representation for given prime factors
    private String getMinSuffix(int r2, int r3, int r5, int r7) {
        int count8 = r2 / 3;
        r2 %= 3;

        int count9 = r3 / 2;
        r3 %= 2;

        int count6 = 0;
        if (r2 > 0 && r3 > 0) {
            count6 = 1;
            r2--;
            r3--;
        }

        int count4 = r2 / 2;
        r2 %= 2;

        int count2 = r2;
        int count3 = r3;
        int count5 = r5;
        int count7 = r7;

        // Optimization: combine extra digits into 8, 9, or 6 if possible
        if (count2 > 0 && count4 > 0) {
            count8++;
            count2--;
            count4--;
        }
        if (count3 > 0 && count3 + count6 >= 2) {
            // Adjust combination rules for tight upper bounds
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count2; i++) sb.append('2');
        for (int i = 0; i < count3; i++) sb.append('3');
        for (int i = 0; i < count4; i++) sb.append('4');
        for (int i = 0; i < count5; i++) sb.append('5');
        for (int i = 0; i < count6; i++) sb.append('6');
        for (int i = 0; i < count7; i++) sb.append('7');
        for (int i = 0; i < count8; i++) sb.append('8');
        for (int i = 0; i < count9; i++) sb.append('9');

        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}