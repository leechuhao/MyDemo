package shutDown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2_1 {
	public static void main(String[] args) {
		int[][] max = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
//		Scanner in = new Scanner(System.in);
//		List<Integer> num = new ArrayList<Integer>();
//		while(in.hasNextLine()){
//			
//		}
		rotateMatrix(max, 3);
		
	}
	public static void rotateMatrix(int[][] mat,int n){
        int[][] mat_rotate = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                mat_rotate[j][n-1-i]=mat[i][j];
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(mat_rotate[i][j]+" ");
            }
        }
    }
}
