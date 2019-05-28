package com.myoffer.first;
/**
 * 找出只出现一次的数字，其余出现3次
 * 如果某一位的和能被3整除，说明只出现一次的那个数对应的为0，否则为1
 * @author 汤吉
 *
 */
public class FindOneNumApearOnce {

	public static int findOneApearOnce(int[] nums) {
		int[] bitSum=new int[32];
		//将所有数字的二进制位加起来
		for (int i = 0; i < nums.length; i++) {
			int maskBit=1;
			//从低位到高位
			for(int j=31;j>=0;j--) {
				int bit=nums[i]&maskBit;
				if(bit!=0) {
					bitSum[j]+=1;
				}
				maskBit=maskBit<<1;//左移
			}
		}
		int result=0;
		//利用位移计算结果
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
