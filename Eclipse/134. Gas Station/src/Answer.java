
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[] gas = new int[]{1,2};
        int[] cost = new int[]{2,1};
        int res = answer.canCompleteCircuit(gas, cost);
        System.out.println(res);       
	}
	
	//I saw the solution
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int startPos =0, tank=0, total=0;;
    	for(int i =0; i<gas.length; i++){
    		tank += gas[i]-cost[i];
    		total+=tank;
    		if(tank<0){
    			startPos = i+1;
    			tank=0;
    		}
    			
    	}
        return total<0? -1: startPos;
    }
}
