

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
       int i = 0;
       int j = 0;
       int resultIndex = 0;
          Deque<Integer> deque = new ArrayDeque<>();
          while(j < n){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[j]){
                deque.removeLast();
            }
            deque.addLast(j);

            if(deque.peekFirst() < i){
                deque.removeFirst();
            }

            if(j-i+1 == k){
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
                i++;
            }
            j++;
          }
          return result;
    }
}