import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();   
        int res = answer.minCut("aabb");
        System.out.println(res);       
	}
	
	//similar to 5.Longest Palindromic Substring;
	//这道其实是两道dp题的合体， 先求出isPal[i][j], 然后根据isPal 求 minCut[i].  minCut[i]: min cut for s.subString(i,n)
	//I saw the solution
    public int minCut(String s) {
    	int n=s.length();
    	//isp[i][j] indicate whether s.subString(i,j+1) is palindrome
        boolean[][] isp = new boolean[n][n];
        //cut[i]: min cut for s.subString(i,n)
        int[] cut = new int[n];
        
        char[] sch = s.toCharArray();
        for(int i=n-1; i>=0; i--){
        	////if s.substring(j+1, n) at least will be palindrome if we divide all partition to a single char
        	int curC=n-i-1;
        	
        	for(int j=i; j<n; j++){
        		
        		if(sch[i]==sch[j] && (j-i<=2 || isp[i+1][j-1]==true) ){
        			isp[i][j]=true;
        			if(j==n-1)
        				curC = 0;
        			else{
        				//if s.substring(j+1, n) at least will be palindrome if we divide all partition to a single char
        				curC = Math.min(curC, cut[j+1]+1);
        			}
        		}
        	}
        	cut[i]=curC;
        }
        return cut[0];
    }
}
