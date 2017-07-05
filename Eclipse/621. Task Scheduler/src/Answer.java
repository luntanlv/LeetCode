
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        char[] input = new char[]{'A','A','A','B','B','B'};
        int res = answer.leastInterval(input, 2);
        System.out.print(res);
	}
	
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks){
        	int index = task - 'A';
        	count[index]++;
        }
        
        int curTaskCount = 0, totalTask = tasks.length;
        int cpu =0;
        
        while(curTaskCount<totalTask){
        	int index = 0;
        	//any invalid index to start
        	int preIndex = totalTask;
        	
        	for(int i=0; i<n; i++){
        		while(count[index]==0){
        			index = (index+1)%26;
        		}
        		
        		if(index == preIndex){
        			cpu+=n;
        		}
        		else{
        			cpu++;
        		}
        		
        		count[index]--;
        		index++;
        		curTaskCount++;
        	}
        }
        
        return cpu;
    }
}
