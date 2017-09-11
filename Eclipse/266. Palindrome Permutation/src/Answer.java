import java.util.HashSet;
import java.util.Set;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();  
        System.out.println();
	}
	
	//I saw the solution
	public boolean canPermutePalindrome(String s) {
		Set<Character>set = new HashSet<Character>();
		for (char c : s.toCharArray())  
			if (set.contains(c)) set.remove(c);// If char already exists in set, then remove it from set
			else set.add(c);// If char doesn't exists in set, then add it to set
		return set.size() <= 1;
	}
}
