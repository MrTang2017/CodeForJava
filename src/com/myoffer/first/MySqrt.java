package com.myoffer.first;

public class MySqrt {

	public static int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}
		int l = 1, r = x;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int sqrt = x / mid;
			if (mid == sqrt) {
				return mid;
			} else if (mid > sqrt) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return r;

	}

	public static void main(String[] args) {
		System.out.println(mySqrt(8));
	}

}
