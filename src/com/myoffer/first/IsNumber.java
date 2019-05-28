package com.myoffer.first;

import java.util.Stack;

/**
 * 
 * 
 * 判断一个字符串是否可以表示数值 忽略空格比如“1 ” 判断为false; 
 * 末尾非数字判断为false,例如4.,4+,4-,4a,,4e,
 * 
 * @author 汤吉
 *
 */
public class IsNumber {
	public static boolean isNumeric(char[] str) {
		if (str.length == 0)
			return false;
		Stack<Character> stack = new Stack<>();
		// 先入栈
		for (int i = 0; i < str.length; i++)
			stack.push(str[i]);
		char preC = stack.pop();// 後一個字符
		int count = 0;// 记录小数点的个数
		if (preC >= '0' && preC <= '9') {
			while (!stack.isEmpty()) {
				// 出栈
				char c = stack.pop();
				// 如果前后都是数值，继续
				if ((c >= '0' && c <= '9') && (preC >= '0' && preC <= '9')) {
					preC = c;
					continue;
				}
				// 当前是数字，但是后面一个字符是正负号
				if ((c >= '0' && c <= '9') && (preC == '+' || preC == '-')) {
					return false;
				} else if ((c >= '0' && c <= '9') && (preC == 'e' || preC == 'E' || preC == '.')) {
					continue;
				}
				// 如果当前字符不是数值，但是后面一个字符是数值
				if ((preC >= '0' && preC <= '9') && (c == '.' || c == 'E' || c == 'e' || c == '+' || c == '-')) {
					if (c == '.') {
						count += 1;
						if (count >= 2)
							return false;
					}
					preC = c;
				}
				// 如果当前字符不是数值，且后面字符也不是数值
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
		 * 以下对正则进行解释:
		 * [\\+\\-]?            -> 正或负符号出现与否
		 * \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
		 * (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字； 否则一起不出现
		 *  ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
		 *  紧接着必须跟着整数；或者整个部分都不出现
		 */
		return str.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
	}

}
