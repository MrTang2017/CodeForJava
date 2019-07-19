package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ��
 * �ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * @author ����
 *
 */
public class CombinationSum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> list=new ArrayList<>();
	        if (candidates.length==0) {
				return list;
			}
	        Arrays.sort(candidates);
	        List<Integer> temp=new ArrayList<>();
	        df(candidates,target,temp,list);
	        
	        return list;
	        
	        
	  }

	private void df(int[] candidates, int target, List<Integer> temp, List<List<Integer>> list) {
		if (target==0) {
			list.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i=0;i<candidates.length;i++) {
			if (target-candidates[i]<0) {
				return;
			}
			if (temp.size()>0 && candidates[i]<temp.get(temp.size()-1)) {
				continue;
			}
			target=target-candidates[i];
			temp.add(candidates[i]);
			df(candidates, target, temp, list);
			temp.remove(temp.size()-1);		
			target=target+candidates[i];
		}	
		
	}

	public static void main(String[] args) {
		
		int[] cands= {1,2,3,4,7};
		int target=7;
		List<List<Integer>> list=new CombinationSum().combinationSum(cands, target);
		for(List<Integer> list2:list) {
			System.out.println(list2);
		}
		

	}

}
