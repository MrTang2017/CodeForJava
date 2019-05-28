package com.myoffer.first;
import java.util.Scanner;
public class TEST2 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		StringBuffer sBuffer=new StringBuffer();
		int i=0;
		for(;i<str.length();i++) {
			if (str.charAt(i)>='0' && str.charAt(i)<='9') {
				int count=Integer.parseInt(String.valueOf(str.charAt(i)));
				StringBuffer sBuffer2=new StringBuffer();
				for(int j=i+1;j<str.length();j++) {
					if(str.charAt(j)==')' || str.charAt(j)=='[' || str.charAt(j)=='{') {
						i=j;
						break;
					}
					if (str.charAt(j)!='(' && str.charAt(j)!='[' && str.charAt(j)!='{') {
						sBuffer2.append(str.charAt(j));
					}		
				}
				String s=sBuffer2.toString();
				System.out.println(s);
				for(int c=1;c<=count-1;c++) {
					sBuffer2.append(s);
				}
				sBuffer.append(sBuffer2.reverse().toString());	
			}
			else if((str.charAt(i)>='a' && str.charAt(i)<='z') || (str.charAt(i)>='A' && str.charAt(i)<='Z')){
				sBuffer.append(str.charAt(i));
			}		
		}
		
		sBuffer.reverse();
		System.out.println(sBuffer.toString());
		scanner.close();
		
	}

}
