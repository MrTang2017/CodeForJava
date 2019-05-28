package com.myoffer.first;

import java.util.ArrayList;

public class SlidWind {

	static ArrayList<Integer> list=new ArrayList<>();
	 public static ArrayList<Integer> maxInWindows(int [] num, int size)
	    {
	       
	        int preIndex=0;
	        int postIndex=size-1;
	        int max=0;
	        while(postIndex<num.length){
	            if((postIndex+1)%size==0 || (preIndex+1)%size==0){
	                //更新最大值
	                max=update(preIndex,postIndex,num);
	                list.add(max);
	            }else{
	                if(num[postIndex]>max)
	                    list.add(num[postIndex]);
	                 else {
	                	max=update(preIndex,postIndex,num);
	 	                list.add(max);
	                 }
	                     
	            }
	            preIndex++;
	            postIndex++;
	        }
	       return list;
	    }
	    
	public static int update(int i, int j, int[] num) {
		int max = 0;
		for (; i <= j; i++) {
			if (num[i] > max)
				max = num[i];
		}
		return max;
	}
	
	
	
	public static void main(String[] args) {
		int[] num= {12,10,14,23,15,34,32,13};
		SlidWind.maxInWindows(num, 3);
		for(Integer max:list)
			System.out.println(max);
	}

}
