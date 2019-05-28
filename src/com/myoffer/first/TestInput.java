package com.myoffer.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestInput {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		List<String> list=new ArrayList<>();
		int n=3;
		while(n>0) {
			list.add(scanner.nextLine());
			n--;
	}
		for(String s:list)
			System.out.println(s);
		scanner.close();
	}
}
