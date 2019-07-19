package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**�绰�������ĸ���
 * 
 * @author ����
 *
 */
public class LetterCombination {
	
    public static final String[] keys= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
 
    public List<String> letterCombinations(String digits) {
    	
    	List<String> list=new ArrayList<>();
    	if (digits==null || digits.length()==0) {
			return list;
		}
    	StringBuilder prefix=new StringBuilder();
    	doLetterCombination(prefix,list,digits);
    	return list;
    }
	private void doLetterCombination(StringBuilder prefix, List<String> list, String digits) {
		
		if (prefix.length()==digits.length()) {
			list.add(prefix.toString());
			return;
		}
		//��ǰ����
		int curDigit=digits.charAt(prefix.length())-'0';
		String letter=keys[curDigit];
		for(char c:letter.toCharArray()) {
			prefix.append(c);
			doLetterCombination(prefix, list, digits);
			//ɾ��ĩβԪ�أ����б�ǣ���ʾ�Ѿ����ʹ�
			prefix.deleteCharAt(prefix.length()-1);
		}
		
	}
	public static void main(String[] args) {
		
	String string="235";
	List<String> list=new LetterCombination().letterCombinations(string);
	for(String s:list)
		System.out.print(s+" ");
		

	}

}
