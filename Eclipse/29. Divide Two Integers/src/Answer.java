
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int res = answer.divide_2(9,2);
        System.out.println(res);       
	}
	
	//I saw the solution
    public int divide(int dividend, int divisor) {
        if (divisor==0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        
        int sign = (dividend<0 && divisor<0) || (dividend>0 && divisor>0) ? 1:-1;
        long dvd = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);
        
        int res=0;
        while(dvd>=div){
        	long temp=div, tempRes =1;
        	while(dvd>=2*temp){       		
        		temp=2*temp;      
        		tempRes=2*tempRes;
        	}
        	res+=tempRes;
        	dvd-=temp;      	
        }
        
        return res*sign;
    }
    
    //I have this
    public int divide_2(int dividend, int divisor) {
        if (divisor==0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        
        int sign = (dividend<0 && divisor<0) || (dividend>0 && divisor>0) ? 1:-1;
        long dvd = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);
        
    	long temp=div;
    	int bitCount=0;
    	while(dvd>=2*temp){       		
    		temp=2*temp;      
    		bitCount++;
    	}
    	
    	int res=0;
    	while(bitCount>=0){
    		if(dvd>=temp){
    			res |= 1<< bitCount;
    			dvd-=temp;
    		}
    		temp/=2;
    		bitCount--;
    	}
    	
    	return res*sign;
    }
}
