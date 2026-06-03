class Solution {
    public int maxProfit(int[] prices) {
        int m=prices[0],max=0;
        for(int i=1;i<prices.length;i++){
            if(m>prices[i]){
                m=prices[i];
            }
            if(prices[i]-m>max){
                max=prices[i]-m;
            }

        }
        
        return max;
    }
}