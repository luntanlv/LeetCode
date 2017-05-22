
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();             
        System.out.println("");
            
	}	
	
	
	//need review, didn't figure out the solution from back to front
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int index1 = m-1, index2= n-1, i=m+n-1;
        while(index1>=0 && index2>=0){
        	nums1[i--]= nums1[index1]>=nums2[index2]? nums1[index1--] : nums2[index2--];
        }
        while(index2>=0){
            nums1[i--] =  nums2[index2--];
        }
    }
}
