

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{7, 1, 5, 3, 6, 4};
        int res = answer.maxProfit_112(input);
        System.out.println(res);       
	}
	
	
	//121: one time sell and buy
	//I saw the solution
	//if (prices[n] < prices[0]) then, the max profit is in prices[0]...prices[n], or begin from prices[n+1],
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    
    //122: multiple sell and buy
    public int maxProfit_112(int[] prices) {
        int pre = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > pre){
            	maxprofit += prices[i]-pre;
            }
            pre=prices[i];
        }
        return maxprofit;
    }
    
    
    //123
    //DP
    //https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
    
    
    //123
    //same ideas as 121
    public int maxProfit_123(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}    
}
