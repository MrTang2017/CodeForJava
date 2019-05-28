package com.myoffer.first;

import java.util.ArrayList;
import java.util.List;

public class OddEven {
	    public static void reOrderArray(int [] array) {
	        int length=array.length;
	        List<Integer> oddList=new ArrayList<>();
	        List<Integer> evenList=new ArrayList<>();
	        for(int i=0;i<length;i++){
	            if(array[i]%2!=0)
	                oddList.add(array[i]);
	            else
	                evenList.add(array[i]);
	        }
	        int j=0;
	        for(Integer o:oddList)
	            array[j++]=o;
	        for(Integer e:evenList)
	            array[j++]=e;  
	    }
	
	public static void main(String[] args) {
		int array[]= {2,4,5,6,7,8,9,0};
        OddEven.reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}

}
