

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] input = new int[]{1,2,4,2,5,7,2,4,9,0};
        int res = answer.maxProfit_Dp(input);
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
    //simple case of 123,just buy1 sell one
    public int maxProfit_121(int[] prices) {
		int sell1 = 0, buy1 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
		}
		return sell1;
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
    //Idea is the same as 121, just loop k times, kth is based on (k-1)th
    //https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
    //https://discuss.leetcode.com/topic/8994/dp-o-kn-time-o-n-space-cpp-solution
    public int maxProfit_Dp(int[] prices) {
    	int kNum=2;
    	int n=prices.length;
    	
    	//if k >= n/2, we can have transactions any time, it can be solved by O(n).
        if (kNum > n / 2) {
            int sum = 0;
            for (int i = 1; i < n; i++){
                if (prices[i] > prices[i - 1]){
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }
        
        //use dp[k][i] represents, The max profit of using [0,i] data and at most k transactions.
        //dp[k][i] = max( dp[k][i-1], max(prices[i]-prices[j] + dp[k-1][j]))  j[0~i], when j=0, it contains dp[k-1][i], mean we don't do kth here.
        //dp[0][i] = 0, 0 times transation makes 0 profit; 
        //dp[k][0] = 0, if there is only one price data point you can't make any money no matter how many times you can trade
        int[][] dp = new int[kNum+1][n];
        int maxProf = 0;
        
        for(int k=1; k<=kNum; k++){

        	int j=0;
        	int makeNewTrans_maxPro=0;
        	
        	for(int i=1; i<n; i++){
        		
        		//For kth buy find lowest buy point till i
        		if(-prices[i]+dp[k-1][i] > -prices[j]+dp[k-1][j])
        			j=i;      			
        		
        		makeNewTrans_maxPro = Math.max(makeNewTrans_maxPro, prices[i]-prices[j]+dp[k-1][j]);
        		
        		dp[k][i] = Math.max(dp[k][i-1], makeNewTrans_maxPro);
        		maxProf = Math.max(dp[k][i], maxProf);
        	}
        }
        
    	return maxProf;
    }
    
    
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
    
    //dp2
    // I got this from sell1 buy1 sell2 buy2 solution, I make it k
    public int maxProfit_Dp2(int[] prices) {
    	int n = prices.length;
    	int knum =2;
    	
    	//maxMoney_buy[k-1] Store the max money in the pocket after kth buy, it store previous value while i from 0 to n
    	int[] maxMoney_buy = new int[knum];
    	//maxMoney_sell[k-1] Store the max money in the pocket after kth sell
    	int[] maxMoney_sell = new int[knum];
    	
		for(int k=0; k<knum; k++){
	    	maxMoney_buy[k]= Integer.MIN_VALUE;
	    	maxMoney_sell[k] = 0;
		} 	

		for (int i = 0; i < n; i++) {
			for(int k=0; k<knum; k++){
				maxMoney_buy[k] = Math.max(maxMoney_buy[k], k>0? maxMoney_sell[k-1] - prices[i] : - prices[i]);
				maxMoney_sell[k] = Math.max(maxMoney_sell[k], maxMoney_buy[k] + prices[i]);
			}
		}
		return maxMoney_sell[knum-1];
	}  
}
