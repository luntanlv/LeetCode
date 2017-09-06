import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        //List<String> sl3 = Arrays.asList(new String[]{"anything"});
        List<String> sl1 = Arrays.asList(new String[]{"orange", "apple"});
        List<String> sl2 = Arrays.asList(new String[]{"orange", "anything", "orange"});
        
        //List<String> sl4 = Arrays.asList(new String[]{"apple", "apple"});
        List<String> sl5 =  new ArrayList<>();
        
        List<List<String>> sl =  new ArrayList<List<String>>();
        //sl.add(sl3);
        sl.add(sl1);
        sl.add(sl2);
        
        
        
        List<String> cl = Arrays.asList(new String[]{"orange", "apple", "apple", "a", "orange", "b", "orange", "banana", "orange", "c"});
        
        int res = answer.checkShoppingList(sl, cl);
        System.out.print(res);
	}
	
	//http://www.1point3acres.com/bbs/thread-288738-1-1.html
	
	public int checkShoppingList(List<List<String>> shoppingLists, List<String> shoppingCart) {
		if(shoppingCart.isEmpty())
			return 0;
		
		int[] res= new int[]{1,0};
		
		for(List<String> shoppingList: shoppingLists){
			if(res[0]==0 || res[1]>=shoppingCart.size()){
				res[0]=0;
				break;
			}
				
			res = helper(shoppingList, shoppingCart, res[1]);
		}
		
		return res[0];
	}
	
	private int[] helper(List<String> shoppingList, List<String> shoppingCart, int cartIndex){
		//res[0]: isValid, res[1]: newCartIndex
		int[] res = new int[2];
		
		int curListIndex = 0;
		int cartIndexL = cartIndex;
		int cartIndexR = cartIndex;
		int cartLength = shoppingCart.size();
		
		while(cartIndexR<cartLength){
			String curCart = shoppingCart.get(cartIndexR);
			String curList = shoppingList.get(curListIndex);
			
			if(curList.equals("anything") || curList.equals(curCart)){
				curListIndex++;
				cartIndexR++;
				
				if(curListIndex==shoppingList.size()){
					res[0]=1;
					res[1]=cartIndexR;
					return res;
				}
					
			}
			else{
				cartIndexL++;
				cartIndexR=cartIndexL;
				curListIndex=0;
			}
		}
		
		res[0]=curListIndex==shoppingList.size()? 1:0;
		res[1]=cartIndexR;
		return res;
	}
	
}
