package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ������ candidates ��һ��Ŀ���� target ��
 * �ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * @author ����
 *candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
 */
public class CombineSum2 {
	private int[] visited;
	
	
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        
	    List<List<Integer>> list=new ArrayList<>();
	    if (candidates.length==0) {
			return list;
		}
	    Arrays.sort(candidates);
	    visited=new int[candidates.length];
	    List<Integer> temp=new ArrayList<>();
	    df(candidates,list,temp,target);
	    return list;
	 
	 
	 }

	private void df(int[] candidates, List<List<Integer>> list, List<Integer> temp, int target) {
		if (target==0) {
			list.add(new ArrayList<>(temp));
			return;
		}
		for(int i=0;i<visited.length;i++) {
			
			if (target-candidates[i]<0) {
				return;
			}
			if (visited[i]==1) {
				continue; 
				
			}
			//ȥ���ظ���
			if (i!=0 && candidates[i]==candidates[i-1] && visited[i-1]==0) {
				continue;
			}
			//ȥ����ͬԪ�صĲ�ͬ���
			if (temp.size()>0 && candidates[i]<temp.get(temp.size()-1)) {
				continue;
			}
			visited[i]=1;
			target=target-candidates[i];
			temp.add(candidates[i]);
			df(candidates, list, temp, target);
			target=target+candidates[i];
			temp.remove(temp.size()-1);
			visited[i]=0;			
		}
		
		
	}

	public static void main(String[] args) {
		int[] cands= {2,5,2,1,2,1};
		int target=5;
		List<List<Integer>> list=new CombineSum2().combinationSum2(cands, target);
		for(List<Integer> list2:list) {
			System.out.println(list2);
		}

	}

}
