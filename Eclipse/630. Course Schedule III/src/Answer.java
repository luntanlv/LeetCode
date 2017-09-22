import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        int[] input = new int[]{};
        List<Integer> res = answer.scheduleCourse(input,74);
        System.out.print(res);
	}
    //I saw the solution
    //it is always profitable to take the course with a smaller end day prior to a course with a larger end day. 
	//This is because, the course with a smaller duration, if can be taken, can surely be taken only if it is taken prior to a course with a larger end day.
	//Based on this idea, firstly, we sort the given coursescourses array based on their end days. 
	//Then, we try to take the courses in a serial order from this sorted coursescourses array.	
	//
	//If this course can be taken, we update the current time to time + duration_itime+durationi
	//and also increment the current countcount value to indicate that one more course has been taken.
	//But, if we aren't able to take the current course i.e. time + duration_i > end_day_i,
	//we can try to take this course by removing some other course from amongst the courses that have already been taken.
	//
	//We are sure of the fact that by removing the j th course, 
	//we can fit in the current course, because, coursej was already fitting in the duration available till now. 
	//Since, duration_i < duration_j, the current course can surely take its place. 
	//Thus, we look for a course from amongst the taken courses having a duration larger than the current course.
	//
	//But why are we doing this replacement? The answer to this question is as follows. 
	//By replacing the jth course, with the ith course of a relatively smaller duration,
	//we can increase the time available for upcoming courses to be taken. 
	//An extra duration_j - duration_i time can be made available by doing so.
	
	//O(n^2)
    public int scheduleCourse(int[][] courses) {
        System.out.println(courses.length);
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0, count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                time += courses[i][0];
                count++;
            } else {
                int max_i = i;
                for (int j = 0; j < i; j++) {
                    if (courses[j][0] > courses[max_i][0])
                        max_i = j;
                }
                if (courses[max_i][0] > courses[i][0]) {
                    time += courses[i][0] - courses[max_i][0];
                }
                courses[max_i][0] = -1;
            }
        }
        return count;
    }
    
    //Using Heap
    public int scheduleCourse_better(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue < Integer > queue = new PriorityQueue < > ((a, b) -> b - a);
        int time = 0;
        for (int[] c: courses) {
            if (time + c[0] <= c[1]) {
                queue.offer(c[0]);
                time += c[0];
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }
}
