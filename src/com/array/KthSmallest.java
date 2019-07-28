package com.array;

import java.util.PriorityQueue;

public class KthSmallest{
	
	class Tuple implements Comparable<Tuple>{
		int val;
		public Tuple(int val) {
			this.val=val;
		}
		
		@Override
		public int compareTo(Tuple that) {
		   return that.val-this.val;
	}
	
	   	
	}

    public int kthSmallest(int[][] matrix, int k) {
        
    	int rows=matrix.length;
    	int cols=matrix[0].length;
    	PriorityQueue<Tuple> priorityQueue=new PriorityQueue<>();
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			if (priorityQueue.size()==k) {
    				if (matrix[i][j]<priorityQueue.peek().val) {
						priorityQueue.poll();
						priorityQueue.offer(new Tuple(matrix[i][j]));
					}
					
				}else {
					priorityQueue.offer(new Tuple(matrix[i][j]));
				}
    		}
    	}
    	
    	return priorityQueue.poll().val;
    
    	
    }

	
	
}
