package com.myoffer.first;
import java.util.ArrayList;
public class printCircleArray {
	    public ArrayList<Integer> printMatrix(int [][] matrix) {
	       //定义四个方向
	        ArrayList<Integer> array=new ArrayList<>();
	        int rows=matrix.length;
	        int cols=matrix[0].length;
	        int start=0;
	        while(rows>2*start && cols>2*start){
	            printNumber(matrix,rows,cols,start,array);
	            start++;
	        }  
	        return array;
	    }
	    
	    public void printNumber(int[][] matrix, int rows, int cols, int start, ArrayList<Integer> array){
	        int endC=cols-1-start;//终止列号
	        int endR=rows-1-start;//终止行号
	        //从左到右打印
	        for(int i=start;i<=endC;i++){
	            array.add(matrix[start][i]);
	        }
	        //上到下打印
	        if(start<endR){
	            for(int i=start+1;i<=endR;i++){
	                array.add(matrix[i][endC]);
	            }
	        }
	        //从右向左打印
	        if (start<endC && start<endR){
	            for(int i=endC-1;i>=start;i--){
	                array.add(matrix[endR][i]);
	            }
	        }
	        //从下向上打印
	        if(start<endC && endR>2*start){
	            for(int i=endR-1;i>start;i--){
	                array.add(matrix[i][start]);
	            }
	        }     
	    }
	public static void main(String[] args) {
	}

}
