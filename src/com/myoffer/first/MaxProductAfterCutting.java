package com.myoffer.first;

/*
 * МєЩўзг
 */
public class MaxProductAfterCutting {

	/*public static int maxProductAfterCutting(int number) {
		if (number < 2)
			return 0;
		if (number == 2)
			return 1;
		if (number == 3)
			return 2;
		int []products=new int[number+1];
		products[0]=0;
		products[1]=1;
		products[2]=2;
		products[3]=3;
		
		int max;
		for(int i=4;i<=number;i++) {
			max=0;
			for(int j=1;j<=i/2;j++) {
				int product=products[j]*products[i-j];
				if (max<product) {
					max=product;
				}
			}
			products[i]=max;		
		}	
		return products[number];
	}*/
	
	public static int maxProductAfterCutting(int number) {
	if (number < 2)
		return 0;
	if (number == 2)
		return 1;
	if (number == 3)
		return 2;
	
	int timesOf3=number/3;
	if (number-timesOf3*3==1) {
		timesOf3-=1;
	}
	int timesOf2=(number-timesOf3*3)/2;
	return (int)Math.pow(3, timesOf3)*(int)Math.pow(2, timesOf2);
}
	

	public static void main(String[] args) {
		System.out.println(maxProductAfterCutting(8));
	}

}
