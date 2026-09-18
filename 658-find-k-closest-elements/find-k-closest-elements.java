class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> max_Heap =
            new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(b[1], a[1]);
            });
       for(int i = 0; i < n; i++){
           max_Heap.offer(new int[]{(Math.abs(arr[i] - x)) , arr[i]});
       if(max_Heap.size() > k){
        max_Heap.poll();
       }
       }
    while(!max_Heap.isEmpty()){
         int[] current = max_Heap.poll();
         result.add(current[1]);
    }
    Collections.sort(result);
    return result;
}
}