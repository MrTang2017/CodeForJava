package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ������һ��ˮƽ�����ϰڷţ������ص���
 * ���ڴ�ֱͶ�������ᣬʹ��·���ϵ����򶼱����ơ�
 * �����С��Ͷ���ڴ���ʹ�������򶼱����ơ�
 * @author ����
 *
 *ʵ����[[1,6],[2,8],[7,12],[10,16]]
 *�����2
 *
 *˼�룺���㲻�ص����������
 */
public class FindMinArrowShots {

	static class Interval {

		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int findMinArrowShots(int[][] points) {

		if (points.length == 0) {
			return 0;
		}
		Interval[] intervals2 = new Interval[points.length];
		// ���������β��ֵ��������
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < 1; j++) {
				intervals2[i] = new Interval(points[i][j], points[i][j + 1]);
			}
		}
		Arrays.sort(intervals2, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});
		int end = intervals2[0].end;
		int count = 1;
		for (int k = 1; k < intervals2.length; k++) {
			if (intervals2[k].start <= end) {
				continue;
			}
			end = intervals2[k].end;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] test= {{1,6},{2,8},{10,16},{7,12}};
		System.out.println(findMinArrowShots(test));
	}

}
