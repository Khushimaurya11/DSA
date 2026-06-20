class BuySell {
    class Solution {
        public int maxProfit(int[] prices) {
            int buy_price = prices[0];
            int profit = 0;
            for(int i = 1; i < prices.length; i++){
                if(buy_price > prices[i]){
                    buy_price = prices[i];
                }
                else{
                    profit = Math.max(profit, prices[i] - buy_price);
                }
            }
            return profit;
        }
    }
    
    public static void main(String[] args) {
        BuySell sol = new BuySell();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = sol.new Solution().maxProfit(prices);
        System.out.println(result); // Output: 5
    }
}