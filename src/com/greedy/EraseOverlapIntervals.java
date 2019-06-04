package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * ����һ������ļ��ϣ�
 * �ҵ���Ҫ�Ƴ��������С������ ʹʣ�����以���ص���
 * 
 * @author ����
 *
 *
 *         ����: [ [1,2], [2,3], [3,4], [1,3] ] ���: 1
 */

public class EraseOverlapIntervals {

	/**
	 * �����ص����ٵ������� �ȼ����������ɵĲ��ص���������� 
	 * Ȼ���������ܸ�����ȥ���ص�����ĸ�����
	 * 
	 * @param intervals
	 * @return
	 */
	static class Interval{
		
		int start;
		int end;
		public Interval(int start,int end) {
			this.start=start;
			this.end=end;
		}	
	}
	public static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		Interval[] intervals2=new Interval[intervals.length];
		// ���������β��ֵ��������
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < 1; j++) {
				intervals2[i]=new Interval(intervals[i][j], intervals[i][j+1]);
			} 
		}
		Arrays.sort(intervals2,new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {	
				return o1.end-o2.end;
			}	
		});
		int end = intervals2[0].end;
		int count = 1;
		for (int k = 1; k < intervals2.length; k++) {
			if (intervals2[k].start < end) {
				continue;
			}
			end = intervals2[k].end;
			count++;
		}
		return intervals2.length - count;

	}

	public static void main(String[] args) {
		int[][] nums = { { 2, 5 }, { 1, 2 }, { 6, 8 }, { 3, 7 } };
		System.out.println(EraseOverlapIntervals.eraseOverlapIntervals(nums));

	}

}
