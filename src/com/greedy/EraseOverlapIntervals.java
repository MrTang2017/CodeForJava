package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * 给定一个区间的集合，
 * 找到需要移除区间的最小数量， 使剩余区间互不重叠。
 * 
 * @author 汤吉
 *
 *
 *         输入: [ [1,2], [2,3], [3,4], [1,3] ] 输出: 1
 */

public class EraseOverlapIntervals {

	/**
	 * 计算重叠最少的区间数 先计算最多能组成的不重叠区间个数， 
	 * 然后用区间总个数减去不重叠区间的个数。
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
		// 按照区间结尾的值进行排序
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
