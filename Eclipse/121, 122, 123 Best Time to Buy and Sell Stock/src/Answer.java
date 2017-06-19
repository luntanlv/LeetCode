

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{1,2,4,2,5,7,2,4,9,0};
        int res = answer.maxProfit_123_twotravesal(input);
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
    
    
    //two traversal
    //https://discuss.leetcode.com/topic/7028/java-solution-with-just-two-traverses
    /*
     * Wrong solution: line 68: while(forwardIndex<=backwardIndex){...} 
     * 
     *  cannot stop in when forward and backward meet, 
     *  1 2 4 2 5 | 7 2 4 9 0
     *  when meet, forwardPro = 4. backwardPro=7
     *  but max is 7-1 + 9-2 = 13
     *  
     *  !!!Even though when first sell position meet second buy position, we can't guarantee this is max,
     *  !!!second buy postion might before current meet point
     * */
    /*
    public int maxProfit_123_tt(int[] prices) {
    	if(prices.length==0)
    		return 0;
    	
    	int forwardIndex = 0, backwardIndex = prices.length-1;
    	int forwardMin=Integer.MAX_VALUE, backwardMax = Integer.MIN_VALUE;
    	int forwardPro = 0, backwardPro = 0;
    	
    	while(forwardIndex<=backwardIndex){
    		
    		if(prices[forwardIndex]<forwardMin)
    			forwardMin = prices[forwardIndex];
    		
    		if(prices[backwardIndex]>backwardMax)
    			backwardMax = prices[backwardIndex];
    		
    		forwardPro= Math.max(forwardPro, prices[forwardIndex]-forwardMin);
    		backwardPro= Math.max(backwardPro, backwardMax - prices[backwardIndex]);
    		
    		forwardIndex++;
    		backwardIndex--;
    	}
    	
    	return Math.max(forwardPro+backwardPro, backwardMax-forwardMin);
	}
    */
    public int maxProfit_123_twotravesal(int[] prices) {
    	int length = prices.length;
    	//leftProfit[i]: The max profit till index i
    	int[] leftProfit = new int[length];
    	
    	int minPrice = Integer.MAX_VALUE; 
    	for(int i=0; i<length; i++){
    		if(prices[i]<minPrice)
    			minPrice = prices[i];
    		
    		leftProfit[i]= Math.max(prices[i]-minPrice, i>0? leftProfit[i-1]: 0);
    	}
    	
    	int maxProfit =0;
    	int maxPrice = Integer.MIN_VALUE; 
    	for(int i=length-1; i>=0; i--){
    		if(prices[i]>maxPrice)
    			maxPrice = prices[i];
    		
    		int rightProfit = maxPrice-prices[i];
    		int totalProfit = rightProfit + (i>0?leftProfit[i-1]: 0);
    		if(maxProfit<totalProfit)
    			maxProfit = totalProfit;
    	}
    	
    	return maxProfit;
	}    
    
    
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
