
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int[] res = answer.plusOne(new int[]{1,2,3,4});
        System.out.println(res);
	}
	
    public int[] plusOne(int[] digits) {
    	int c=1, index=digits.length-1;
    	do{
    		int cur=digits[index]+c;
    		digits[index]=cur%10;
    		c=cur/10;
    		index--;
    	}
    	while(c>0 && index>=0);
    	
    	if(c>0){
    		int[] newres = new int[digits.length+1];
    		newres[0]=1;
    		return  newres;
    	}
    	else 
    		return digits;
    }
}
