import java.util.PriorityQueue;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[][] input = new int[][]{{1,2,3,4,5},{1,0,3,4,5},{1,2,3,4,5},{1,2,3,4,0}};
        
        answer.setZeroes(input);
        
        for(int[] row: input){
        	for(int num: row)
        		System.out.print(num + ", ");
        	System.out.println("");
        }      
	}
	
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n=0;
        if(m>0)
        	n=matrix[0].length;
        
        if(m==0 || n==0)
        	return -1;
    	
        boolean[][] visted = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        
        q.add(new int[]{0,0});
        visted[0][0]=true;
        
        while(!q.isEmpty()){
        	int[] cur = q.poll();
        	int x = cur[0], y = cur[1];
        	
        	k--;
        	if(k==0)
        		return matrix[x][y];
        	
        	if(x+1<m && visted[x+1][y]==false){
        		q.add(new int[]{x+1, y});
        		visted[x+1][y]=true;
        	}
        	
        	if(y+1<n && visted[x][y+1]==false){
        		q.add(new int[]{x, y+1});
        		visted[x][y+1]=true;
        	}
        }
        
        return -1;
    }
    
    //binary search, it is hard to write it right
    //kind of quick sort idea
    /*
     * We are done here, but let's think about this problem in another way:
     * The key point for any binary search is to figure out the "Search Space". 
     * For me, I think there are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number). 
     * Most usually, when the array is sorted in one direction, we can use index as "search space", w
     * hen the array is unsorted and we are going to find a specific number, we can use "range".
     * 
     * Let me give you two examples of these two "search space"
     * index -- A bunch of examples -- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ ( the array is sorted
     * range -- https://leetcode.com/problems/find-the-duplicate-number/ (Unsorted Array)
     * The reason why we did not use index as "search space" for this problem is the matrix is sorted in two directions, we can not find a linear way to map the number and its index.
     * 
     */
    
    public int kthSmallest_bs(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            //count: num of val which is <= mid
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k)
            	lo = mid + 1;
            //https://discuss.leetcode.com/topic/52865/my-solution-using-binary-search-in-c/32
            //
            //if mid is the val from matrix,
            // 1. if count>k and if there are more than one val equal to mid
            // 		for example3 , k=8, count =9, two val = mid,
            // 		so mid is 8th and 9th smallest, mid is the answer 
            //
            //2. if count ==k 
            //	 since count is num of val <= mid, mid is the kth value in the matrix
            //	 so we should keep mid
            else
            	hi = mid;
        }
        // the reason why left is the val in the matrix
        // Because the loop invariant is left<=Solution<=right. The moment it quits the loop, we also know another condition is true: left>=right.
        //left<=Solution<=right and left>=right means left==Solution==right.
        return lo;
    }
    
    public int kthSmallest_bs2(int[][] matrix, int k) {
        int n = matrix.length;

        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0; // number of elements no bigger than mid

            for (int i = 0; i < n; i++) {
                int[] row = matrix[i];

                int t_left = 0, t_right = row.length;
                while (t_left < t_right) {
                    int t_mid = (t_left + t_right) / 2;
                    int value = row[t_mid];
                    if(value > mid) {
                        t_right = t_mid;
                    } else {
                        t_left = t_mid + 1;
                    }
                }
                count += t_left;
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
