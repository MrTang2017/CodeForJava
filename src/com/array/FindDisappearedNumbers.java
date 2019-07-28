package com.array;

import java.util.ArrayList;
import java.util.List;
/**
 * ÊäÈë:
 * [4,3,2,7,8,2,3,1]
 * Êä³ö:
 * [5,6]
 * @author ÌÀ¼ª
 *
 */

public class FindDisappearedNumbers {
	
	
	
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
    	int n=nums.length;
    	List<Integer> list=new ArrayList<>();
    	int[] counts=new int[n+1];
    	for(int i=0;i<n;i++) {
    		counts[nums[i]]++;
    	}
    	
    	for(int j=1;j<=n;j++) {
    		if (counts[j]==0) {
				list.add(j);
			}
    	}
    	
    	return list;
    	
    }

	public static void main(String[] args) {
		
		
		int nums[]= {4,2,3,7,8,5,7,1};
		List<Integer> list=new FindDisappearedNumbers().findDisappearedNumbers(nums);
		System.out.println(list);
				
		
		
	}

}
