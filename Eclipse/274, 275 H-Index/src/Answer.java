
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        //int[] input = new int[]{3, 0, 6, 1, 5};
        int[] input = new int[]{100};
        int res = answer.hIndex_275(input);
        
        System.out.println(res);         
	}
	
	//Idea as counting sort. 
	// n = citations.length
	//And we don't care about specific count for each val lager than n. We just need to know the count for val lager than n and count for val from 0~n
	//Since max H-index will only be n (the number of paper)
    public int hIndex(int[] citations) {
    	int n = citations.length;
    	if(n==0)
    		return 0;
    	
        int[] count = new int[n+1];
        for(int citation : citations){
        	if(citation>=n)
        		count[n]++;
        	else
        		count[citation]++;
        }
        
        for(int i=count.length-1; i>=0; i--){
        	count[i]+= i+1<count.length? count[i+1]:0;
        	if(count[i]>=i)
        		return i;
        }
        return 0;
    }
    
    
    //275
    //Hard to understand boarder case
    public int hIndex_275(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo < hi) {
            int med = (hi + lo) / 2;
            if (citations[med] == len - med) {
                return len - med;
            } else if (citations[med] < len - med) {
                lo = med + 1;
            } else { 
                //(citations[med] > len-med), med qualified as a hIndex,
                // but we have to continue to search for a higher one.
                hi = med - 1;
            }
        }        
        //lo==hi
        //check the if citations[lo] is a valid res, if it is not, we cannot include it.
        //like [0]
        return citations[lo]<len-lo? len-lo-1: len-lo;
    }
}
