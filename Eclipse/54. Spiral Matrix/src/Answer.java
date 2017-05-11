import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String [] args)
	{
        Answer answer = new Answer(); 
        int[][] input = {{1}};
        List<Integer> res = answer.spiralOrder(input);
        System.out.println(res);
	}
	
	public enum Direction {Ix,Iy,Dx,Dy};
	
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        int m = matrix.length;
        if(m==0)
        	return res;
        int n=matrix[0].length;
        
//        if(n==1|| m==1){
//        	for(int i=0; i<m; i++){
//        		for(int j=0; j<n; j++){
//        			res.add(matrix[i][j]);
//        		}
//        	}
//        	return res;
//        }
        
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
}
