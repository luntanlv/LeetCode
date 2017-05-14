import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        //List<Integer> res = answer.spiralOrder(input);
        //System.out.println(res);
        int[] res = answer.findDiagonalOrder(input);
        for(int item: res){
        	System.out.print(item + ", ");
        }
	}
	
	public enum Direction {Ix,Iy,Dx,Dy};
	
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        int m = matrix.length;
        if(m==0)
        	return res;
        int n=matrix[0].length;
        
        int i=0, j=0;
        int ixBorder = n-1, iyBorder= m-1, dxBorder=0, dyBorder=0;
        Direction dire = Direction.Ix;
        
        while(res.size()<n*m){   	
        	if(dire == Direction.Ix){
        		for(;j<=ixBorder;j++){
        			res.add(matrix[i][j]);
        		}
        		j--;
        		i++;
        		dire = Direction.Iy;
        		dyBorder++;       		
        	}
        	else if(dire == Direction.Iy){
        		for(; i<=iyBorder; i++){
        			res.add(matrix[i][j]);
        		}
        		i--;
        		j--;
        		dire = Direction.Dx;
        		ixBorder--;
        	}
        	else if(dire == Direction.Dx){
        		for(; j>=dxBorder; j--){
        			res.add(matrix[i][j]);
        		}
        		j++;
        		i--;
        		dire = Direction.Dy;
        		iyBorder--;
        	}
        	else if(dire == Direction.Dy){
        		for(; i>=dyBorder; i--){
        			res.add(matrix[i][j]);
        		}
        		i++;
        		j++;
        		dire = Direction.Ix;
        		dxBorder++;
        	}        	
        }

        return res;
    }

    //59
    public int[][] generateMatrix(int n) {
        int[][] res = new int[3][3];
        int i,j;
        Direction dir = Direction.Ix;
        
        for(int val=0; val<n*n; val++){
        	
        }
        
    }    
    
    public int[] findDiagonalOrder(int[][] matrix) {
    	
        int m = matrix.length;
        if(m==0)
        	return new int[0];
        int n=matrix[0].length;
        
        int[] res = new int[n*m]; 
    	
        boolean isUp = true;
        int i=0,j=0;
        for(int k=0; k<n*m;){
            while(i>=0 && i<m && j>=0 && j<n){
            	res[k]=matrix[i][j];
            	if(isUp){
            		i--;
            		j++;
            	}
            	else{
            		i++;
            		j--;
            	}
            	k++;
            }
            
            if(isUp){
            	i=j<n? 0 : i+2;
            	j=j==n? n-1 : j;
            }
            else{
            	
            	j=i<m? 0 : j+2;
            	i=i==m? m-1 : i;
            }
            
            isUp=!isUp;
            
        }
        
        return res;

    }    
}
