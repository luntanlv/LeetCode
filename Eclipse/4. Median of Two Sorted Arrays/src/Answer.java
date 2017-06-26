
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        char[][] input = new char[][]{{'A', 'B', 'C', 'D'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        //char[][] input = new char[][]{{'A'}};
        boolean res = answer.exist(input, "ABCB");
        
        System.out.println(res);
            
	}
	
	//"if we cut the sorted array to two halves of EQUAL LENGTHS, then
	//median is the AVERAGE OF Max(lower_half) and Min(upper_half), i.e. the
	//two numbers immediately next to the cut".
	//
	//Note that I'll use '/' to represent a cut, and (number / number) to represent a cut made.
	//For example, for [2 3 5 7], we make the cut between 3 and 5: [2 3 / 5 7]
    //then the median = (3+5)/2. 
	//
	//for [2 3 4 5 6], we make the cut right through 4 like this: [2 3 (4/4) 5 7]
	//Since we split 4 into two halves, we say now both the lower and upper subarray contain 4. This notion also leads to the correct answer: (4 + 4) / 2 = 4;
	//
	//So the number immediately left to the cut leftIndex = (N-1)/2,
	//the number immediately right to the cut rightIndex = N/2,
	//
	//The median = (nums[(N-1)/2] + nums[N/2])/2
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        //divide nums1 at i (before num at index i), i:[0, l1], leftPart have i elements (0~i-1), rightPart have l1-i elments (i~l1-1)
        //divide nums2 at j (before num at index j), j:[0, l2], leftPart have j element, rightPart have l2-j
        //When we divide i, j properly leftPart.length = rightPart.length.
        //So 
        int l = (l1 + l2 -1) / 2;
        int r = (l1 + l2) / 2;
        return (getkth(A, m ,B, n, l) + getkth(A, m, B, n, r)) / 2;
    }
    
    private getkth()
}
