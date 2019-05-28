package com.myoffer.first;

import java.util.Scanner;

/**
 * 剑指Offer题目2：不修改数组找出重复的数字(n+1个数字的数组，数字在1~n之间)
 * 
 * @author 汤吉
 *
 */
public class DuplicateNumber {

	private static int duplicate(int[] numbers, int length) {

		if (length <= 0) {
			return -1;
		}
		for (int i = 0; i < length; i++) {
			if (numbers[i] < 1 || numbers[i] > length - 1) {
				return -1;
			}
		}

		int start = 1;
		int end = length - 1;
		while (end >= start) {
			int middle = (end - start) / 2 + start;
			int count = countRange(numbers, length, start, middle);
			if (start == end) {
				if (count > 1) {
					return start;
				} else {
					break;
				}
			}

			if (count >= (middle - start + 1)) {
				end = middle;
			} else {
				start = middle + 1;
			}
		}

		return -1;
	}

	private static int countRange(int[] numbers, int length, int start, int end) {

		int totalCount = 0;
		for (int i = 0; i < length; i++) {
			if (numbers[i] >= start && numbers[i] <= end) {
				totalCount += 1;
			}
		}
		return totalCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		int[] numbers = new int[length];
		for (int i = 0; i < length; i++) {
			int randomNumber = (int) (Math.random() * length);
			numbers[i] = randomNumber == 0 ? 1 : randomNumber;
		}
		for (int k : numbers) {
			System.out.print(k + " ");
		}
		System.out.println();
		System.out.println(duplicate(numbers, length));
		input.close();
	}

}
