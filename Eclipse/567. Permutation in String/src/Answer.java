import java.util.Arrays;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();      
        boolean res = answer.checkInclusion("a", "ab");
        System.out.print(res);
	}
	
	
	//I saw the solution	
	//Sort and compare. [Time Limit Exceeded]
	//I need to sort all the substrings of s2. We cannot just sort s2 once, otherwise s1="abc" and s2="bbbca" will lead to wrong answer
    public boolean checkInclusion_slow(String s1, String s2) {
        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length()))))
                return true;
        }
        return false;
    }
    public String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
    
    
    //I saw the solution
    //Sliding Window
    //one string will be a permutation of another string only if both of them contain the same charaters with the same frequency
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        
        //use count and l and r pointer to track whether two string are the same frequency
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        
        for (int i = 0; i < s2.length() - s1.length(); i++) {
        	if(count == 26)
        		return true;
        	
        	//The one will shift out of the window
        	int l = s2.charAt(i)-'a';
        	//The new one just shift into the window
        	int r = s2.charAt(i+s1.length())-'a';
        	
        	s2map[l]--;
        	if(s2map[l] == s1map[l])
        		count++;
        	else if(s2map[l]+1 == s1map[l])
        		count--;
        	
        	s2map[r]++;
        	if(s2map[r] == s1map[r])
        		count++;
        	else if(s2map[r]-1 == s1map[r])
        		count--;
        	
        }
        return count == 26;
    }
}
