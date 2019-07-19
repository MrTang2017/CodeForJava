package com.backtracking;

import java.util.ArrayList;
import java.util.List;
/**
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数
 * 并且每种组合中不存在重复的数字
 * @author 汤吉
 *
 */
public class CombineSum3 {
	
	private int[] visited;
	private int[] nums;

	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> list = new ArrayList<>();
		if (n == 0 || k <= 0) {
			return list;
		}
		nums = new int[9];
		visited = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = i + 1;
		}

		List<Integer> temp = new ArrayList<>();
		df(list, temp, k, n);
		return list;

	}
	

	private void df(List<List<Integer>> list, List<Integer> temp, int k, int n) {
		if (n==0 && temp.size()==k) {
			list.add(new ArrayList<>(temp));
			return;
		}
		
		for(int j=0;j<visited.length;j++) {
			if (n-nums[j]<0) {
				return;
			}
			if (visited[j]==1) {
				continue;
			}
			
			if (temp.size()>0 && nums[j]<temp.get(temp.size()-1)) {
				continue;
			}
			
			temp.add(nums[j]);
			n=n-nums[j];
			visited[j]=1;
			df(list, temp, k, n);
			visited[j]=0;
			temp.remove(temp.size()-1);
			n=n+nums[j];		
		}	
		
	}


	public static void main(String[] args) {
		int n=9,k=3;
		List<List<Integer>> list=new CombineSum3().combinationSum3(k, n);
		for(List<Integer> list2:list)
			System.out.println(list2);
		
		

	}

}
