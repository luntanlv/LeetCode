

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
}
