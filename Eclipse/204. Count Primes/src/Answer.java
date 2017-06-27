
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();
        int res = answer.countPrimes(2);
        System.out.println(res);    
	}
	
	//Count the number of prime numbers LESS than a non-negative number, n.
	
	//https://discuss.leetcode.com/topic/13654/my-simple-java-solution/2
	//https://www.youtube.com/watch?annotation_id=annotation_386867&feature=iv&src_vid=eKp56OLhoQs&v=7VPA-HjjUmU
	//https://www.youtube.com/watch?annotation_id=annotation_366926&feature=iv&src_vid=7VPA-HjjUmU&v=eKp56OLhoQs
	//I saw the solution
    public int countPrimes(int n) {
    	//Assume all num from 0~n are prime
        boolean[] notPrime = new boolean[Math.max(2, n)];
        //0, 1 are not prime
        notPrime[0] = true;
        notPrime[1] = true;

        //i start from 2, mark all numbers which are multiple of 2 to be notPrime
        //if a number cannot be divide by any number from 2 square root(n), it cannot be divide any number larger than square root n.
        for(int i=2; i<=Math.sqrt(n); i++){
        	//it i is prime, mark all its multiple to not a prime
        	if(notPrime[i]==false){

        		for(int j=2; i*j<n; j++){
        			notPrime[i*j]=true;
        		}
        	}
        }
        
        int count =0;
        for(int i=0; i<n; i++){
        	if(notPrime[i]==false)
        		count++;
        } 
        return count;
    }
}
