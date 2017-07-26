
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        String res = answer.convert("PAYPALISHIRING", 2);
        System.out.println(res);    
	}
	//Solution
	public String convert_better(String s, int nRows) {
	    char[] c = s.toCharArray();
	    int len = c.length;
	    StringBuffer[] sb = new StringBuffer[nRows];
	    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
	    
	    int i = 0;
	    while (i < len) {
	        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
	            sb[idx].append(c[i++]);
	        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
	            sb[idx].append(c[i++]);
	    }
	    for (int idx = 1; idx < sb.length; idx++)
	        sb[0].append(sb[idx]);
	    return sb[0].toString();
	}
	
    public String convert(String s, int numRows) {
    	StringBuilder[] res = new StringBuilder[numRows];
    	for(int i=0; i<numRows; i++){
    		res[i] =  new StringBuilder();
    	}
    	
    	char[] schr = s.toCharArray();
    	
    	int row=0;
    	boolean isUp = false;
    	for(char item: schr){
    		res[row].append(item);   		
    		row = isUp? row-1: row+1;
    		
    		if(row == numRows){
    			if(numRows>2){
        			isUp = true;
        			row-=2;
    			}
    			else
    				row=0;
    		}
    		else if(row == 0){
    			isUp = false;
    		}
    	}
    	
    	String resStr="";
    	for(int i=0; i<numRows; i++){
    		resStr +=res[i].toString();
    	}
    	
    	return resStr;
    }
}
