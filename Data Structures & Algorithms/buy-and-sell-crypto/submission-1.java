class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0;
        int r = 1;
        while (l < prices.length - 1 && r < prices.length) {
            if (prices[l] > prices[r]) {
                l = r;
            } else if (prices[r] - prices[l] > maxProfit) {
                maxProfit = prices[r] - prices[l];
            }
            r++;
        }
        return maxProfit;
    }
}
