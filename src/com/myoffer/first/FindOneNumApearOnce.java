package com.myoffer.first;
/**
 * �ҳ�ֻ����һ�ε����֣��������3��
 * ���ĳһλ�ĺ��ܱ�3������˵��ֻ����һ�ε��Ǹ�����Ӧ��Ϊ0������Ϊ1
 * @author ����
 *
 */
public class FindOneNumApearOnce {

	public static int findOneApearOnce(int[] nums) {
		int[] bitSum=new int[32];
		//���������ֵĶ�����λ������
		for (int i = 0; i < nums.length; i++) {
			int maskBit=1;
			//�ӵ�λ����λ
			for(int j=31;j>=0;j--) {
				int bit=nums[i]&maskBit;
				if(bit!=0) {
					bitSum[j]+=1;
				}
				maskBit=maskBit<<1;//����
			}
		}
		int result=0;
		//����λ�Ƽ�����
		for (int i = 0; i < 32; i++) {
			result=result<<1;
			result+=bitSum[i]%3;
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] test= {2,3,4,3,3,4,4,5,5,5};
		System.out.println(findOneApearOnce(test));
		


		
		
		

	}

}
