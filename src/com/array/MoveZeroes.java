package com.array;

/**
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��
 * ͬʱ���ַ���Ԫ�ص����˳��
 * ����: [0,1,0,3,12]
 * ���: [1,3,12,0,0]
 * @author ����
 *
 */
public class MoveZeroes {

	
    public void moveZeroes(int[] nums) {
       // Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++) {
        	if (nums[i]==0) {
        		count+=1;
				continue;
			}
        	if (count!=0) {
        		//����
        		int temp=nums[i];
        		nums[i]=nums[i-count];
        		nums[i-count]=temp;			
			}
        }
    	
    	
    }
	
	
	public static void main(String[] args) {

		int nums[] = { 2,1};
		new MoveZeroes().moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

}
