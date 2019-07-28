package com.array;

public class HammingDistance {
	
public int hammingDistance(int x, int y) {
        int flag=1;
        int count=0;
        while(flag>0) {  	
        	int x1=x&flag;
        	int x2=y&flag;
        	if (x1!=x2) {
				count++;
			}     
        	flag=flag<<1; 	
        	
        }
        
    return count;



}


public static void main(String[] args) {
	System.out.println(new HammingDistance().hammingDistance(3, 4));
}
	

}
