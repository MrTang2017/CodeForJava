package com.myoffer.first;

import java.util.Stack;

/**
 * 
 * 
 * �ж�һ���ַ����Ƿ���Ա�ʾ��ֵ ���Կո���硰1 �� �ж�Ϊfalse; 
 * ĩβ�������ж�Ϊfalse,����4.,4+,4-,4a,,4e,
 * 
 * @author ����
 *
 */
public class IsNumber {
	public static boolean isNumeric(char[] str) {
		if (str.length == 0)
			return false;
		Stack<Character> stack = new Stack<>();
		// ����ջ
		for (int i = 0; i < str.length; i++)
			stack.push(str[i]);
		char preC = stack.pop();// ��һ���ַ�
		int count = 0;// ��¼С����ĸ���
		if (preC >= '0' && preC <= '9') {
			while (!stack.isEmpty()) {
				// ��ջ
				char c = stack.pop();
				// ���ǰ������ֵ������
				if ((c >= '0' && c <= '9') && (preC >= '0' && preC <= '9')) {
					preC = c;
					continue;
				}
				// ��ǰ�����֣����Ǻ���һ���ַ���������
				if ((c >= '0' && c <= '9') && (preC == '+' || preC == '-')) {
					return false;
				} else if ((c >= '0' && c <= '9') && (preC == 'e' || preC == 'E' || preC == '.')) {
					continue;
				}
				// �����ǰ�ַ�������ֵ�����Ǻ���һ���ַ�����ֵ
				if ((preC >= '0' && preC <= '9') && (c == '.' || c == 'E' || c == 'e' || c == '+' || c == '-')) {
					if (c == '.') {
						count += 1;
						if (count >= 2)
							return false;
					}
					preC = c;
				}
				// �����ǰ�ַ�������ֵ���Һ����ַ�Ҳ������ֵ
				else {
					if ((c == 'e' || c == 'E') && (preC == '+' || preC == '-') && (count == 0)) {
						return true;
					}
					if ((c == '+' || c == '-') && (preC == '.') && stack.size() == 0)
						return true;
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static boolean isNumber(String str) {
		/**
		 * ���¶�������н���:
		 * [\\+\\-]?            -> ���򸺷��ų������
		 * \\d*                 -> ���������Ƿ���֣���-.34 �� +3.34������
		 * (\\.\\d+)?           -> �������С���㣬��ôС���������������֣� ����һ�𲻳���
		 *  ([eE][\\+\\-]?\\d+)? -> �������ָ�����֣���ôe��E�϶����֣�+��-���Բ����֣�
		 *  �����ű�����������������������ֶ�������
		 */
		return str.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
	}

}
