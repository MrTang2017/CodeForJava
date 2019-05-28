package com.myoffer.first;

/**
 * ������һ�������̣����̵ĺ�������9���� ��������10���ߣ����衰������λ��Ϊ(1��0) ��k���ߵ�(x,y)�ķ����ж�����
 * 
 * @author ����
 *
 */
public class HorseStepMethodNum {

	public static int getValue(int x, int y, int step) {
		return process(x, y, step);

	}

	/**
	 * �����ݹ����
	 * 
	 * @param x
	 * @param y
	 * @param step
	 * @return
	 */
	private static int process(int x, int y, int step) {
		// Խ��
		if (x < 0 || y < 0 || x > 8 || y > 9) {
			return 0;
		}
		// �����λ�ã�����
		if (step == 0) {
			return (x == 1 && y == 0) ? 1 : 0;
		}
		return process(x - 1, y + 2, step - 1) + process(x - 1, y - 2, step - 1) + process(x - 2, y - 1, step - 1)
				+ process(x - 2, y + 1, step - 1) + process(x + 1, y + 2, step - 1) + process(x + 1, y - 2, step - 1)
				+ process(x + 2, y + 1, step - 1) + process(x + 2, y - 1, step - 1);
	}

	public static void main(String[] args) {
		System.out.println(getValue(2, 4, 5));

	}

}
