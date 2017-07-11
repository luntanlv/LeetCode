
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int res = answer.reverse(-1234);
        System.out.println(res);    
	}
	
    public int reverse(int x) {
        int cur = x;
        long res = 0;
        while(cur!=0){
        	int temp = cur%10;
        	res=10*res+temp;
        	cur=cur/10;
        }
        return res>Integer.MAX_VALUE || res<Integer.MIN_VALUE? 0: (int)res;
    }
    
    //this is good
    public int reverse_better(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
