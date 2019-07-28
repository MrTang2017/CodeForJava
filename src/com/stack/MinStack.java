package com.stack;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack=new Stack<>();

	/** initialize your data structure here. */
	public MinStack() {
		this.stack = new Stack<>();
	}

	public void push(int x) {
		
		stack.push(x);
		if (!minStack.isEmpty()) {
			if (x < minStack.peek()) {
				minStack.push(x);
			}else {
				minStack.push(minStack.peek());
			}
		} else {
			minStack.push(x);
		}

	}

	public void pop() {
		stack.pop();
		minStack.pop();
	
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {

		MinStack minStack = new MinStack();
		minStack.push(2);
		minStack.push(4);
		minStack.push(0);
		minStack.push(1);
		minStack.push(3);
		System.out.println(minStack.getMin());
		minStack.pop();
		minStack.pop();
		minStack.pop();
		System.out.println(minStack.getMin());
	}

}
