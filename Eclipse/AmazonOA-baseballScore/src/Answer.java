import java.util.Stack;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String[] input = new String[]{"X","Z", "5", "-2", "4", "Z", "X", "9", "+", "+"};
        int res = answer.getScore(input);
        System.out.println(res);
	}
	
	/*
	 * Given a string array representing a throw ball blocks, each string is either a number,
		+, Z, X. Calculate total. If number, just add to total. If +, add last 2 scores to total.
		If Z, remove last score from total. If X, double last score and add to toal.
		Use 0 for any missing last score. ��Щ corner cases Ҫ���ǡ�
		�����÷�,����һ�� String[] input,������ score
		����� integer, �ͼӸ� score(�и�ֵ).
		����ǡ�x��, ����һ��ֵ double ,�Ӹ� score; ��û����һ��ֵ,��һ��ֵ�� 0 ����
		����ǡ�z��, ��һ���ɼ�����, score ������һֵ
		����ǡ�+��,��������ֵ���,Ȼ��Ӹ� score
	 * 
	 */
	public int getScore(String[] input){
		Stack<Integer> st = new Stack<>();
		int res=0;
		for(String cur: input){
			if(cur.equals("Z")){
				if(!st.isEmpty()){
					int remove = st.pop();
					res-=remove;
				}			
			}
			else if(cur.equals("X")){
				int pre = st.isEmpty()? 0: st.peek();
				int val = 2*pre;
				st.push(val);
				res+=val;		
			}
			else if(cur.equals("+")){
				int pre1=0, pre2=0;
				if(!st.isEmpty()){
					pre1=st.pop();
					pre2=st.isEmpty()? 0: st.peek();
					st.push(pre1);
				}
				
				int val = pre1+pre2;
				st.push(val);
				res+=val;		
			}
			//Num
			else{
				int val = Integer.valueOf(cur);
				st.push(val);
				res+=val;
			}
		}
		
		return res;
	}
}
