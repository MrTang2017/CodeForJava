package com.greedy;

import java.util.Arrays;

/**
 * leetcode 455 ��������������һλ�ܰ��ļҳ��� 
 * ��Ҫ����ĺ�����һЩС���ɡ����ǣ�ÿ���������ֻ�ܸ�һ����ɡ�
 *  ��ÿ������ i ������һ��θ��ֵ
 * gi ���������ú���������θ�ڵı��ɵ���С�ߴ磻 ����ÿ����� j ��
 * ����һ���ߴ� sj ����� sj >= gi �� ���ǿ��Խ�������� j ���������
 * i ��������ӻ�õ����㡣 ���Ŀ���Ǿ���������Խ�������ĺ��ӣ�
 * �������������ֵ��
 * 
 * ʾ����[1,2,3],[1,1] �����1 ���ͣ������������Ӻ�����С���ɣ�
 * 3�����ӵ�θ��ֵ�ֱ��ǣ�1,2,3��
 * ��Ȼ��������С���ɣ��������ǵĳߴ綼��1�� ��ֻ����θ��ֵ��1�ĺ������㡣
 *  ������Ӧ�����1��
 * 
 * @author ����
 *
 */

public class FindContentChildren {

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int gl = 0;
		int sl = 0;
		while (gl < g.length && sl < s.length) {
			if (s[sl] >= g[gl])
				gl++;
			sl++;
		}
		return gl;
	}

	public static void main(String[] args) {
		int[] chlidrens = { 1, 2 };
		int[] cookies = { 1, 2, 3 };
		System.out.println(findContentChildren(chlidrens, cookies));

	}

}
