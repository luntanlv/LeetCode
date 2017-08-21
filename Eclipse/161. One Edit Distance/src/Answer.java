
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[] ratings = new int[]{1,2,5};
        int res = answer.candy_st(ratings);
        System.out.println(res);       
	}
	
    public boolean isOneEditDistance(String s, String t) {
    	int sl = s.length(), tl = t.length();
    	char[] sc = s.toCharArray(), tc =t.toCharArray();
    	
        if(sl == tl){
        	int diffCount=0;
        	for(int i=0; i<sl; i++){
        		if(sc[i] != tc[i])
        			diffCount++;
        	}
        	return diffCount==1? true:false;
        }
        else if(Math.abs(sl-tl)==1){
        	char[] shortStr, longStr;
        	if(sl>=tl){
        		shortStr = tc;
        		longStr = sc;
        	}
        	else{
        		shortStr = sc;
        		longStr = tc;        		
        	}

        	int shortIndex=0, longIndex =0, diffCount=0;
        	while(longIndex<longStr.length){
        		if(shortIndex>=shortStr.length || shortStr[shortIndex]!=longStr[longIndex]){
        			longIndex++;
        			diffCount++;
        		}
        		//shortStr[shortIndex]==longStr[longIndex]
        		else{
        			shortIndex++;
        			longIndex++;
        		}
        	}
        	return diffCount==1? true:false; 	
        }
        else
        	return false;
    }
}
