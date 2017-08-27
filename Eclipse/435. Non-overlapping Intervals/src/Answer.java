import java.util.Arrays;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        //int[][] input = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        int[][] input = new int[][]{{10,16}, {2,8}, {1,6}, {7,12}};
        int res =answer.findMinArrowShots_my(input);
        System.out.println(res);       
	}
	
	public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	
	//https://leetcode.com/problems/non-overlapping-intervals/solution/
	//I saw the solution
	//4 solutions
	
	//Greedy: Sorting by starting time
	//As we iterate, 3 cases will happen
	//1. The two intervals currently considered are non-overlapping: no remove, update the prev and continue;
	//2. The two intervals currently considered are overlapping,
	//		and the end point of the later interval falls before the end point of the previous interval: remove the later one (smaller width one)
	//3. The two intervals currently considered are overlapping,
	//		and the end point of the later interval falls after the end point of the previous interval: remove the later one
	//		Since we sort by starting time, remove later one means we have smaller prev.end,
	//		which will have less opportunity to have overlap with later internals.
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b)->a.start-b.start);
        
        int prev = 0, count = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev].end > intervals[i].start) {
                if (intervals[prev].end > intervals[i].end) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }
    
    //DP:  Sorting by starting time
    //Actually, the problem is the same as "Given a collection of intervals, 
    //find the maximum number of intervals that are non-overlapping." (the classic Greedy problem: Interval Scheduling). 
    //With the solution to that problem, res = intervals.length - ans
    //We use dp here to get max number here
    public boolean isOverlapping(Interval i, Interval j) {
        return i.end > j.start;
    }
    public int eraseOverlapIntervals_dp(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b)->a.start-b.start);
        
        //dp[i]stores the maximum number of valid intervals that can be included from interval 0 to i
        int dp[] = new int[intervals.length];
        dp[0] = 1;
        
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!isOverlapping(intervals[j], intervals[i])) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);

        }
        return intervals.length - ans;
    }
}
