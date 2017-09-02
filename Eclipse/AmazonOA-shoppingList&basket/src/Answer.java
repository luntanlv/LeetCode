import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        List<String> sl1 = Arrays.asList(new String[]{"apple", "apple"});
        List<String> sl2 = Arrays.asList(new String[]{"orange", "anything", "orange"});
        //List<String> sl3 = Arrays.asList(new String[]{"apple", "apple"});
        //List<String> sl4 = Arrays.asList(new String[]{"apple", "apple"});
        
        List<List<String>> sl =  new ArrayList<List<String>>();
        sl.add(sl1);
        sl.add(sl2);
        
        List<String> cl = Arrays.asList(new String[]{"orange", "apple", "apple", "a", "orange", "b", "orange", "banana", "orange", "c"});
        
        int res = answer.checkShoppingList(sl, cl);
        System.out.print(res);
	}
	
	//http://www.1point3acres.com/bbs/thread-288738-1-1.html
	
	public int checkShoppingList(List<List<String>> shoppingLists, List<String> shoppingCart) {
		int[] res= new int[]{1,0};
		
		for(List<String> shoppingList: shoppingLists){
			if(res[0]==0 || res[1]>=shoppingCart.size())
				break;
			res = helper(shoppingList, shoppingCart, res[1]);
		}
		
		return res[0];
	}
	
	private int[] helper(List<String> shoppingList, List<String> shoppingCart, int cartIndex){
		//res[0]: isValid, res[1]: newCartIndex
		int[] res = new int[2];
		
		int listIndex = 0, cartIndexL = cartIndex, cartIndexR = cartIndex;
		int cartLen = shoppingCart.size();
		
		while(cartIndexR<cartLen){
			String curC = shoppingCart.get(cartIndexR);
			String curL = shoppingList.get(listIndex);
			
			if(curL.equals("anything") || curL.equals(curC)){
				listIndex++;
				cartIndexR++;
				
				if(listIndex==shoppingList.size()){
					res[0]=1;
					res[1]=cartIndexR;
					return res;
				}
					
			}
			else{
				cartIndexL++;
				cartIndexR=cartIndexL;
				listIndex=0;
			}
		}
		
		res[0]=listIndex==shoppingList.size()? 1:0;
		res[1]=cartIndexR;
		return res;
	}
	
}
