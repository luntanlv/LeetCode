
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{3,4,5};
        double res = answer.findMedianSortedArrays(nums2, nums1);
        
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
	//We are not using this here.
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        //divide nums1 at i (before num at index i), i:[0, l1], leftPart have i elements (0~i-1), 
        //the largest num in leftPart is nums1[i-1], the samllest num in rightPart nums1[i]
        //
        //divide nums2 at j (before num at index j), j:[0, l2], leftPart have j element (0~j-1)
        //the largest num in leftPart is nums2[j-1], the samllest num in rightPart nums2[j]
        //
        //When we divide i, j properly leftPart.length = i+j = (l1+l2+1)/2, 
        //When n+m is odd num: 123/45, leftPart is 123, length = (1+5)/2=3
        //When n+m is even num: 123/456, leftPart is 123, length = (1+6)/2=3
        //so j=(l1+l2+1)/2-i
        //Since j=(l1+l2+1)/2-i, We have to make sure j>0
        
        int imin =0, imax=l1;
        while(imin<=imax){
        	int i = imin+(imax-imin)/2;
        	int j = (l1+l2+1)/2-i;

        	//decrease i, to increase j
        	if(j<0){
        		imax = i-1;
        		continue;
        	}
        	//increase i, to decrease i
        	else if(j>l2){
        		imin = i+1;
        		continue;
        	}
        	
        	int leftMax1, rightMin1, leftMax2, rightMin2;
        	leftMax1 = i==0? Integer.MIN_VALUE: nums1[i-1];
        	rightMin1 = i==l1? Integer.MAX_VALUE: nums1[i];
        	
        	leftMax2 = j==0? Integer.MIN_VALUE: nums2[j-1];
        	rightMin2 = j==l2? Integer.MAX_VALUE: nums2[j];
        	
        	
        	//nums1 leftPart is too large, nums2 rightPart is too small, so decrease i, which will also increase j
        	if(leftMax1>rightMin2){
        		imax = i-1;
        	}
        	//nums2[j-1]>nums1[i]
        	//nums2 leftPart is too large, nums1 rightPart is too small, so increase i, which will also decrease j
        	else if(leftMax2>rightMin1){
        		imin = i+1;
        	}    	
        	//largest in left should smaller than smallest in right
        	//(nums1[i-1]<=nums2[j] && nums2[j-1]<=nums1[i]), find the result
        	else{
        		//even number: 12/34, Math.max(nums1[i-1], nums2[j-1]=2), Math.min(nums1[i], nums2[j])=3
        		if((l1+l2)%2==0)
        			return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2))/2.0;
        		//odd number: 123/45, Math.max(nums1[i-1], nums2[j-1]=3
        		else
        			return Math.max(leftMax1, leftMax2);	
        	}
        }
        
        return -1;
    }
    

}
