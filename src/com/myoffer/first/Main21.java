package com.myoffer.first;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main21 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = 0;
		List<String> listInput = new ArrayList<String>();
		num = input.nextInt();
		input.nextLine();
		for(int i=0;i<num;i++) {	
			String s = input.nextLine();
			listInput.add(i,s);
		}

		
		for(int i=0;i<num;i++) {
			String string = (String)listInput.get(i);
			String string2 = filterCode1(string);
			String string3 = filterCode2(string2);
			String string4 = filterCode3(string3);
			System.out.println(string4);
		}
				
	}
	
	public static String filterCode1(String str) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i) + "");// 这里就是使用字符串存入到list中，
		}
		for (int m = 0; m < list.size() - 2; m++) {
			if (list.get(m).equals(list.get(m + 1))&&list.get(m+1).equals(list.get(m + 2))) {
				list.remove(m+2);
				m--;				
			}
		}
		StringBuffer sb=new StringBuffer();
		String str3="";
		for(int j=0;j<list.size();j++){
			str3=sb.append(list.get(j)).toString();
		}
		return str3;
	}
	
	public static String filterCode2(String str) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i) + "");// 这里就是使用字符串存入到list中，
		}
		for (int m = 0; m < list.size() - 3; m++) {
			if (list.get(m).equals(list.get(m + 1))&&list.get(m+2).equals(list.get(m + 3))) {
				list.remove(m+3);
				m--;				
			}
		}
		StringBuffer sb=new StringBuffer();
		String str3="";
		for(int j=0;j<list.size();j++){
			str3=sb.append(list.get(j)).toString();
		}
		return str3;
	}
	
	public static String filterCode3(String str) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i) + "");// 这里就是使用字符串存入到list中，
		}
		for (int m = 0; m < list.size() - 5; m++) {
			if (list.get(m).equals(list.get(m + 1))&&list.get(m+2).equals(list.get(m + 3))&&list.get(m+4).equals(list.get(m + 5))) {
				list.remove(m+3);
				m--;				
			}
		}
		StringBuffer sb=new StringBuffer();
		String str3="";
		for(int j=0;j<list.size();j++){
			str3=sb.append(list.get(j)).toString();
		}
		return str3;
	}
}
