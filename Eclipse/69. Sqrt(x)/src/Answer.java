
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        
        int res = answer.sqrt(2147395600);
        System.out.println(res);
	}
	
	//
	//be careful of boundry, 2147395599, 2147395600
	
	//Near the very end, closest step, before while loop, left = mid = right.
	//In while, If mid < sqrt(x), left = mid + 1 executed, right pointer is not moving, and right is the answer.
	//In while, If mid > sqrt(x), right = mid - 1 executed, right pointer shifts left 1, closest to sqrt(x), right is also the answer.
    public int sqrt(int x) {
        if(x==0)
            return 0;
        
        int low = 1;
        int high = x;
        while (low <= high) {
        	int mid = low + ((high - low) >> 1);
            // int mid = (low + high) / 2; fail on 2147395599
        	if(mid > x / mid)
            //if(mid * mid > x) fail on 2147395599
            	high = mid-1;
            else if(mid * mid < x)
                low = mid+1;
            else return mid;
        }
        return high;        
    }
    
    public int sqrt2(int x) {
        if (x == 0)
            return 0;
        int low = 1, high = x;
        while (true) {
        	int mid = low + ((high - low) >> 1);
            if (mid > x / mid) {
                high = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                low = mid + 1;
            }
        }
    }
    
    
    /*
		Since sqrt(x) is composed of binary bits, 
		I calculate sqrt(x) by deciding every bit from the most significant to least significant. 
		Since an integer n can have O(log n) bits with each bit decided within constant time, 
		this algorithm has time limit O(log n), actually, because an Integer can have at most 32 bits, 
		I can also say this algorithm takes O(32)=O(1) time.
     */
    public int sqrt3(int x) {
        if(x==0)
            return 0;
        int h=0;
        while((long)(1<<h)*(long)(1<<h)<=x) // firstly, find the most significant bit
            h++;
        h--;
        int b=h-1;
        int res=(1<<h);
        while(b>=0){  // find the remaining bits
            if((long)(res | (1<<b))*(long)(res |(1<<b))<=x)
                res|=(1<<b);
            b--;
        }
        return res;
    }
}
