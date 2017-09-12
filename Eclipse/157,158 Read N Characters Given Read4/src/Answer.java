
public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer();  
        int res  = answer.nextGreaterElement(1999999999);
        System.out.println(res);
	}
	
	//157
	//Note:
	//The read function will only be called once for each test case.
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     * 
     * int read4(char[] buf);
     */
	//I saw the solution
    public int read(char[] buf, int n) {
        
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readBytes = 0;
        
        while (readBytes < n && !endOfFile) {
            int currReadBytes = read4(buffer);
            if (currReadBytes !=4) {
                endOfFile = true;
            }
            int length = Math.min(n - readBytes, currReadBytes);
            for (int i=0; i<length; i++) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += length;
        }
        return readBytes;
    }
    
    //158
    //Note:
    //The read function may be called multiple times.
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     * 
     * int read4(char[] buf)
     */
    //I saw the soulution
    
    //I used buffer pointer (buffPtr) and buffer Counter (buffCnt) to store the data received in previous calls. 
    //In the while loop, if buffPtr reaches current buffCnt, it will be set as zero to be ready to read new data.
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    
    public int read_158(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) break;
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            if (buffPtr >= buffCnt) buffPtr = 0;
        }
        return ptr;
    }
}
