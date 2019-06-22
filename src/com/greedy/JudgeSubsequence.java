package com.greedy;


//判断一个
public class JudgeSubsequence {
	public static boolean isSubsequence(String s,String t) {
		int flag=s.indexOf(t.charAt(0));
		int count=0;
		if (flag>=0) {
			s=s.replaceFirst(String.valueOf(s.charAt(flag)), "");
			count+=1;
			for(int i=1;i<t.length();i++) {
				int index=s.indexOf(t.charAt(i));
				if (index>=0) {
					if((index+count)<=flag)
						return false;
				}
				else {
					return false;
				}
				flag=index+count;
				//返回新的字符串
				s=s.replaceFirst(String.valueOf(s.charAt(index)), "");
				System.out.println(s);
				count+=1;		
			}
		}
		else {
			return false;
		}
		return true;		
	}
	public static void main(String[] args) {
		System.out.println(isSubsequence("lyyeeeeyeyytyycoyyyde", "leeeeetcoeY"));

	}

}
