package com.myoffer.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class StackOperation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> stack = new Stack<>();
		while (n > 0) {
			String str = null;
			try {
				str = new BufferedReader(new InputStreamReader(System.in)).readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] operate1=str.split(" ");
			if (operate1.length == 2) {
				String operate2 = operate1[0];
				int k = Integer.parseInt(operate1[1]);
				switch (operate2) {
				case "push":
					stack.push(k);
					break;
				case "delete":
					if (!stack.isEmpty()) {
						int a = stack.peek();
						stack.pop();
						if (!stack.isEmpty()) {
							if (stack.peek() == k)
								stack.pop();
						}
						stack.push(a);
					}
					break;
				default:
					break;
				}
			} else {
				switch (operate1[0]) {
				case "pop":
					if (!stack.isEmpty())
						stack.pop();
					break;
				case "query":
					if (!stack.isEmpty()) {
						int b = stack.peek();
						System.out.println(b);
					}else {
						System.out.println(0);
					}
					break;
				default:
					break;
				}
			}
			n--;
		}
		in.close();
	}

}
