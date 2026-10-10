
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalOps = (long) k1 + k2;
        
        long[] diff = new long[n];
        long totalDiff = 0;
        
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            totalDiff += diff[i];
        }
        
        if (totalDiff <= totalOps) {
            return 0;
        }
        
        Arrays.sort(diff);
        
        // Use a frequency map or group by values by scanning from right to left
        Map<Long, Long> countMap = new HashMap<>();
        for (long d : diff) {
            countMap.put(d, countMap.getOrDefault(d, 0L) + 1L);
        }
        
        // Alternatively, greedy reduction using sorting in descending order:
        Long[] sortedDiff = new Long[n];
        for (int i = 0; i < n; i++) {
            sortedDiff[i] = diff[i];
        }
        Arrays.sort(sortedDiff, Collections.reverseOrder());
        
        long k = totalOps;
        List<Long> list = new ArrayList<>(countMap.keySet());
        Collections.sort(list, Collections.reverseOrder());
        
        for (int i = 0; i < list.size() && k > 0; i++) {
            long curr = list.get(i);
            long count = countMap.get(curr);
            long nextVal = (i + 1 < list.size()) ? list.get(i + 1) : 0;
            
            long diffToNext = curr - nextVal;
            long totalCanReduce = diffToNext * count;
            
            if (k >= totalCanReduce) {
                k -= totalCanReduce;
                countMap.put(nextVal, countMap.getOrDefault(nextVal, 0L) + count);
                countMap.remove(curr);
            } else {
                long reducePerItem = k / count;
                long remainder = k % count;
                
                long newLeadVal = curr - reducePerItem;
                countMap.put(curr, count - remainder);
                countMap.put(newLeadVal, countMap.getOrDefault(newLeadVal, 0L) + (count - remainder));
                
                long reducedExtraVal = newLeadVal - 1;
                countMap.put(reducedExtraVal, countMap.getOrDefault(reducedExtraVal, 0L) + remainder);
                countMap.put(curr, countMap.get(curr) - (count - remainder));
                
                k = 0;
                break;
            }
        }
        
        long ans = 0;
        for (Map.Entry<Long, Long> entry : countMap.entrySet()) {
            long val = entry.getKey();
            long count = entry.getValue();
            if (val > 0) {
                ans += count * val * val;
            }
        }
        
        return ans;
    }
}