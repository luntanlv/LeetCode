
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{0,1,0,1,2,0};
        
        answer.sortColors(input);
        
        for(int num: input){
        	System.out.print(num + ", ");
        }
        
	}
	
    void sortColors(int A[], int n) {
        int second=n-1, zero=0;
        for (int i=0; i<=second; i++) {
            while (A[i]==2 && i<second) swap(A[i], A[second--]);
            while (A[i]==0 && i>zero) swap(A[i], A[zero++]);
        }
    }	
	
	
	//Using count sort
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        
        for(int num: nums){
        	count[num]++;
        }
        
//        for(int i=1; i < count.length; i++){
//        	count[i]+=count[i-1];
//        }
        
        int n=0;
        for(int i=0; i< count.length; i++){
        	for(int j =0; j<count[i]; j++){
        		nums[n]=i;
        		n++;
            }
        }

    }
}
