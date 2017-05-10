
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        double res = answer.myPow3(0.00001, 2147483647);
        System.out.println(res);
	}
	
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        else if(n<0){
        	x=1/x;
        	n=-n;
        }
            
        int i=2;
        double tempRes=x, res=0;
        while(i<=n){
            tempRes = tempRes * tempRes;
            i=2*i;
        }
        res=tempRes;
        
        if(n>i/2)
        	res = res * myPow(x, n-i/2);
        
        return res;
    }
    
    public double myPow2(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow2(x*x, n/2) : x*myPow2(x*x, n/2);
    }
    
    public double myPow3(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}
