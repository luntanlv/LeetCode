import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Answer {
	//Definition for undirected graph.
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
	}
	
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        UndirectedGraphNode root = answer.new UndirectedGraphNode(1);
        
        UndirectedGraphNode res = answer.cloneGraph(root);
        System.out.println(res);       
	}	
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null)
    		return null;
    	
        HashMap<UndirectedGraphNode, UndirectedGraphNode> old2NewDic = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        Queue<UndirectedGraphNode> q =  new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> isVisted = new HashSet<UndirectedGraphNode>();

        q.add(node);
        isVisted.add(node);
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        old2NewDic.put(node, head);
        
        while(!q.isEmpty()){
        	UndirectedGraphNode cur = q.poll();
        	UndirectedGraphNode curNew = old2NewDic.get(cur);
        	
        	for(UndirectedGraphNode next: cur.neighbors){
        		if(!isVisted.contains(next)){
        			isVisted.add(next);
        			q.add(next);
        			UndirectedGraphNode nextNew = new UndirectedGraphNode(next.label);
        			curNew.neighbors.add(nextNew);
        			old2NewDic.put(next, nextNew);	
        		}
        		else{
        			UndirectedGraphNode nextNew = old2NewDic.get(next);
        			curNew.neighbors.add(nextNew);
        		}
        	}
        }
        
        return head;
    }
}
