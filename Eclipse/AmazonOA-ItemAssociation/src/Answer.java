import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {

	public static void main(String [] args)
	{
        Answer answer = new Answer();
        String[][] input = new String[][]{{"4","4"},{"4","5"},{"4","6"},{"1","2"},{"2","3"},{"7","7"},{"7","8"}};
        String[] res = answer.findLargestGroup(input);
        for(String item: res)
        	System.out.print(item+", ");
	}
	
	/*
	 * ���ˣ�������������������ģ�(�����������˴���)
		����һ��Pair, ÿ�������˵�������˻�Ϊ���ѣ�[A,B] ˵�����ͣ������ѣ�[��,B] ˵���úͣ������ѣ����ģ��ţ�˵���źͣ������ѡ�
		�ҳ�������������Ȧ�������������Ȧ������ȣ����������ֵ�˳����С���ѵ��Ǹ�Ȧ��
	 * 
	 */
	private String[] findLargestGroup(String[][] relationList) {
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, Integer> count = new HashMap<>();
		
		for(String[] pair : relationList){
			if(!map.containsKey(pair[0])){
				map.put(pair[0], pair[0]);
				count.put(pair[0], 1);
			}
			
			String root0=getRoot(pair[0], map);
			
			//Add new item to group root0
			if(!map.containsKey(pair[1])){
				map.put(pair[1], root0);
				count.put(root0, count.get(root0)+1);
			}
			else{
				String root1=getRoot(pair[1], map);
				//Merge two group
				if(!root0.equals(root1)){
					//merge group root1 into group root0
					if(count.get(root0)>count.get(root1)){
						map.put(root1, root0);
						count.put(root0, count.get(root0)+count.get(root1));
						count.remove(root1);
					}
					////merge group root0 into group root1
					else{
						map.put(root0, root1);
						count.put(root1, count.get(root1)+count.get(root0));
						count.remove(root0);
					}
				}
			}
		}
		
		int maxCount=0;
		List<String> maxGroup= new ArrayList<>();
        for(Map.Entry<String, Integer> ent : count.entrySet()) {
        	int groupC= ent.getValue();
        	String group = ent.getKey();
            if(groupC>maxCount) {
				maxGroup.clear();
				maxGroup.add(group);
				maxCount=groupC;
            }
			else if(groupC==maxCount){
				maxGroup.add(group);
			}
        }		
		
		String[] res = new String[maxCount];
		if(maxCount==0)
			return res;
		
		for(int i=0; i<maxGroup.size(); i++){
			String root = maxGroup.get(i);
			String[] tempRes = new String[maxCount];
			int index=0;
			
	        for(Map.Entry<String, String> ent : map.entrySet()) {
	            if(getRoot(ent.getValue(), map).equals(root)) {
	            	tempRes[index++] = ent.getKey();
	            }
	        }
	        Arrays.sort(tempRes);
	        if(i==0 || res[0].compareTo(tempRes[0])>0)
	        	res=tempRes;	        
		}
		
		return res;
		
	}
	
	private String getRoot(String item, HashMap<String, String> map){
		String root=item;
		while(!map.get(root).equals(root)){
			String parent = map.get(root);
			map.put(root, map.get(parent));
			root=parent;
		}
		return root;
	}
}
