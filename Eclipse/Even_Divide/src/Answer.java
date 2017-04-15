import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Answer {
	
	public static void main(String [] args)
	{
//		int res = answer(1048574);
//		System.out.println(res);
		
//		boolean res = isValid("()");
//		System.out.println(res);
	}	
	
	
    public static int even_divide(String s) { 
        int length = s.length();
        char[] sChar = s.toCharArray();
        int maxPartL = 1;
        String part;
        // Your code goes here.
    	for(int n=length; n>0; n--){
    		if(length%n==0){
    			int partL= length/n;
    			boolean tempRes = true;
    			   				
				//compare each part
				for(int i =1; i<n; i++){   					
					for(int j =0; j<partL; j++){
						if(sChar[j]!=sChar[i*partL+j]){
							tempRes=false;
							break;
						}					
					}
				}
				
				if(tempRes){
	    			maxPartL = n;
	    			part = String.valueOf(sChar).substring(0, partL);
	    			System.out.println(part);
	    			return maxPartL;
				}			
			}		
    	}
		return maxPartL;
    } 
    
    public static int[] gear(int[] pegs) { 
        // Your code goes here.
    	int[] diff = new int[pegs.length-1];
    	for(int i=0; i<pegs.length-1; i++){
    		diff[i]=pegs[i+1]-pegs[i];
    	}

    	int tempSum=0;
    	for(int i=0; i<diff.length; i++){
    		tempSum = tempSum + (int)java.lang.Math.pow(-1,i)*diff[diff.length-1-i];
    	}
    	int x_sign = (int)java.lang.Math.pow(-1,diff.length);
    	
    	//first radius: x
    	//2(tempSum + x_sign*x) = x
    	//x=2*tempSum / 1-2*x_sign
    	int a=2*tempSum;
    	int b=1-2*x_sign;
    	
    	if(a<0 && b<0){
    		a=-a;
    		b=-b;
    	}
    	
    	if(a>0 && b>0 && a>=b){
    		a = a%3==0&&b%3==0? a/3:a;
    		b = a%3==0&&b%3==0? b/3:b;
    		
    		double gear = a/b;
    		for(int i=0; i<pegs.length-1; i++){
    			if(pegs[i]+gear>pegs[i+1]-1){
    				a=-1;
    				b=-1;
    				break;
    			}
    			gear=pegs[i+1]-pegs[i]-gear;
    		}
    	}
    	else{
    		a=-1;
    		b=-1;
    	}
    	
    	//System.out.println(35%3);
    	//System.out.println(b);
    	//System.out.println("------------");

    	return new int[]{a,b};

    	
    } 
    
    public static int answer(int total_lambs) { 
    	
    	ArrayList<Integer> generous = new ArrayList<Integer>();
    	ArrayList<Integer> stingy = new ArrayList<Integer>();
    	generous.add(1);
    	stingy.add(1);
    	int stingy_total = total_lambs-1;
    	int generous_total = total_lambs-1;
  	
    	
    	while(generous_total>0){
    		int last = generous.get(generous.size()-1);
    		int sec_last = generous.size()>=2? generous.get(generous.size()-2) : 0 ;
    		if(generous_total>=2*last){
    			generous.add(2*last);
    			generous_total-=2*last;	
    		}
    		else if(generous_total>=last+sec_last){
    			generous.add(generous_total);
    			generous_total = 0;
    		}
    		else
    			break;    		
    	}
    	
    	while(stingy_total>0){
    		int last = stingy.get(stingy.size()-1);
    		int sec_last = stingy.size()>=2? stingy.get(stingy.size()-2) : 0 ;
    		if(stingy_total>=last + sec_last){
    			stingy.add(last + sec_last);
    			stingy_total-=last + sec_last;	
    		}
    		else
    			break;    		
    	}
    	
    	int temp =0;
    	for(int pay :generous){
    		System.out.print(pay + ", ");
    		temp+=pay;
    	}
    	System.out.println("------" + generous_total);
    	System.out.println(temp);
    	
    	temp =0;
    	for(int pay :stingy){
    		System.out.print(pay + ", ");
    		temp+=pay;
    	}
    	System.out.println("------"+ stingy_total);
    	System.out.println(temp);
    	
    	System.out.println(stingy.size());
    	System.out.println(generous.size());
    	int res =  stingy.size() - generous.size();
    	return res;

    } 
}
