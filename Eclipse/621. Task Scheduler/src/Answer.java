import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        char[] input = new char[]{'A','A','A','B','B','B'};
        int res = answer.leastInterval(input, 50);
        System.out.print(res);
	}
	
	//I saw the solution
	//Not easy to undertand regards to how to tracking cooling time of tasks
	//!!!!!!/Chose priority queue solution
	//Now, the task picked up first after the sorting, 
	//will either be the first task picked up in the last iteration(which will now be picked after its cooling time has been finished)
	//
	//or the task picked will be the one which lies at (n+1)th position in the previous descending tasks array.( Since all the count of  
	//first n task in previous descending tasks array will be minus by 1£¬ so the new order will either stay the same or start with task at 
	//(n+1)th position in the previous descending tasks array.
	//
	//In either of the cases, the cooling time won't cause any conflicts(it has been considered implicitly).
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}
