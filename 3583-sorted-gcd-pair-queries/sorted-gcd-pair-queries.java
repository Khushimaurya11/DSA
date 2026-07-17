class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        // 1. Sabse bada number nikalen
        int maxVal = 0;
        for (int num : nums) maxVal = Math.max(maxVal, num);

        // 2. Frequency count karein
        int[] count = new int[maxVal + 1];
        for (int num : nums) count[num]++;

        // 3. Har number ke multiples kitne hain array mein
        long[] elementsDivisibleBy = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            for (int j = i; j <= maxVal; j += i) {
                elementsDivisibleBy[i] += count[j];
            }
        }

        // 4. Exact GCD count nikalen (Peeche se loop chalayen)
        long[] exactGcdCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long k = elementsDivisibleBy[i];
            long totalPairs = (k * (k - 1)) / 2; // kC2 pairs
            
            // Bado ko minus karein
            for (int j = 2 * i; j <= maxVal; j += i) {
                totalPairs -= exactGcdCount[j];
            }
            exactGcdCount[i] = totalPairs;
        }

        // 5. Prefix Sum array banayein (Sorted range pta karne ke liye)
        long[] prefixSum = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + exactGcdCount[i];
        }

        // 6. Ab queries ko Binary Search se process karein
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long target = queries[i];
            
            int low = 1, high = maxVal, res = maxVal;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSum[mid] > target) {
                    res = mid;       // Yeh answer ho sakta hai
                    high = mid - 1;  // Aur chota dhoondne ke liye left mein jayein
                } else {
                    low = mid + 1;   // Right mein jayein
                }
            }
            ans[i] = res;
        }

        return ans;
    }
}