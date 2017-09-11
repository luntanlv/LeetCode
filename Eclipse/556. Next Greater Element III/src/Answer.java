import java.util.ArrayList;
import java.util.List;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();  
        int res  = answer.nextGreaterElement(1999999999);
        System.out.println(res);
	}
	
	//Similar to 31. Next Permutation
	//https://leetcode.com/problems/next-permutation/description/
	
    public int nextGreaterElement(int n) {
        List<Integer> vl = new ArrayList<Integer>();
        while(n>0){
        	vl.add(n%10);
        	n=n/10;
        }
        
        int index =0;
        while(index<vl.size()){
        	int pre = index-1>=0? vl.get(index-1):0;
        	int cur = vl.get(index);

        	if(cur<pre)
        		break;
        	
        	index++;
        }
        
        if(index==vl.size())
        	return -1;
        
        int switchIndex=0;
        while(switchIndex<index){
        	int cur = vl.get(switchIndex);

        	if(cur>vl.get(index))
        		break;
        	
        	switchIndex++;
        }
        
        int temp = vl.get(index);
        vl.set(index, vl.get(switchIndex));
        vl.set(switchIndex, temp);
        
        //reverse 0~index-1
        int l=0, r=index-1;
        while(l<r){
            temp = vl.get(l);
            vl.set(l, vl.get(r));
            vl.set(r, temp);
            l++;
            r--;
        }
        
        int res=0;
        for(int i=vl.size()-1; i>=0; i--){
        	int pre = res;
        	res=res*10+vl.get(i);
        	if(pre!=res/10)
        		return -1;      	
        }
        
        return  res;
    }
}
