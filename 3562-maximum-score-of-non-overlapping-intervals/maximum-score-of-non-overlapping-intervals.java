import java.util.*;

class Solution {
    static class Interval {
        int l, r, weight, id;
        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    static class Result {
        long weight;
        List<Integer> indices;

        Result(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervals.get(i).get(0), intervals.get(i).get(1), intervals.get(i).get(2), i);
        }

        // Sort intervals by starting time l
        Arrays.sort(arr, (a, b) -> Integer.compare(a.l, b.l));

        // Precompute next non-overlapping interval index for each i using binary search
        int[] nextIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1, ans = n;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (arr[mid].l > arr[i].r) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            nextIdx[i] = ans;
        }

        // dp[i][k] stores the best Result for suffix starting at i with at most k choices left
        Result[][] dp = new Result[n + 1][5];
        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new Result(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k <= 4; k++) {
                // Option 1: Skip current interval
                Result best = dp[i + 1][k];

                // Option 2: Pick current interval
                if (k > 0) {
                    Result nextRes = dp[nextIdx[i]][k - 1];
                    long candWeight = arr[i].weight + nextRes.weight;

                    List<Integer> candIndices = new ArrayList<>(nextRes.indices.size() + 1);
                    candIndices.add(arr[i].id);
                    candIndices.addAll(nextRes.indices);
                    Collections.sort(candIndices);

                    Result cand = new Result(candWeight, candIndices);

                    if (isBetter(cand, best)) {
                        best = cand;
                    }
                }
                dp[i][k] = best;
            }
        }

        List<Integer> resIndices = dp[0][4].indices;
        int[] res = new int[resIndices.size()];
        for (int i = 0; i < resIndices.size(); i++) {
            res[i] = resIndices.get(i);
        }
        return res;
    }

    private boolean isBetter(Result cand, Result best) {
        if (cand.weight > best.weight) return true;
        if (cand.weight < best.weight) return false;
        
        // Lexicographical comparison when weight is tied
        int len1 = cand.indices.size();
        int len2 = best.indices.size();
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            if (!cand.indices.get(i).equals(best.indices.get(i))) {
                return cand.indices.get(i) < best.indices.get(i);
            }
        }
        return len1 < len2;
    }
}