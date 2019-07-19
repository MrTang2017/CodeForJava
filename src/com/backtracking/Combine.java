package com.backtracking;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 * @author 汤吉
 *
 */
public class Combine {
	
	private int[] visited;
	private int[] nums;
    public List<List<Integer>> combine(int n, int k) {
        
    	List<List<Integer>> list=new ArrayList<>();
    	if (n==0 || k>n || k==0) {
			return list;
		}
    	visited=new int[n];
    	nums=new int[n];
    	for(int i=0;i<n;i++) {
    		nums[i]=i+1;
    	}
    	List<Integer> temp=new ArrayList<>();
    	int l=0;
    	//df(list,temp,nums,k);
    	df(list, temp, k,l);
    	return list;
    	
    }

	private void df(List<List<Integer>> list, List<Integer> temp, int k, int l) {
		
		if (temp.size()==k) {
			list.add(new ArrayList<>(temp));
			return;
		}
		for(int j=l;j<visited.length;j++) {
			temp.add(nums[j]);
			df(list, temp, k,j+1);
			temp.remove(temp.size()-1);	
		}				
	}

	/*private void df1(List<List<Integer>> list, List<Integer> temp, int k) {
		if (temp.size()==k) {
			list.add(new ArrayList<>(temp));
			return;
		}
		for(int j=0;j<visited.length;j++) {
			if (visited[j]==1) {
				continue;
			}
			//当前未标记的
			if (temp.size()>0 && nums[j]<=temp.get(temp.size()-1)) {
				continue;
			}
			temp.add(nums[j]);
			visited[j]=1;
			df1(list, temp, k);
			temp.remove(temp.size()-1);
			visited[j]=0;		
		}		
	}*/
	
	

	public static void main(String[] args) {
		
		int n=5,k=2;
		List<List<Integer>> list=new Combine().combine(n, k);
		for(List<Integer> list2:list)
			System.out.println(list2);
		
		
	}

}
