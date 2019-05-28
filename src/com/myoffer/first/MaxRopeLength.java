package com.myoffer.first;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class MaxRopeLength 
{	

	static Comparator<Double> com=new Comparator<Double>()
	{
		@Override
		public int compare(Double a,Double b)
		{
			return (int)((b-a)*100000);
		}
	};
	
	public void f()
	{
		int n=0, m=0;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		PriorityQueue<Double> pq=new PriorityQueue<Double>(com);
		for(int i=0; i<n; i++)
			pq.add((double)sc.nextInt());
		
		int length=pq.size();
		double[] a=new double[length+1];
		
		for(int i=0; i<pq.size(); i++)
			a[i]=pq.poll();
		
		while(length<m||a[0]<a[m-1]/2.0)
		{
			a[0]=a[0]/2.0;
			a[length]=a[0];
			length++;
			for(int i=0; i<length; i++)
				pq.add(a[i]);
			a=new double[length+1];
			for(int i=0; i<length; i++)
				a[i]=pq.poll();
		}
		System.out.println(a[m-1]);
			
		
		sc.close();
	}
	
	public static void main(String[] args) 
	{
		MaxRopeLength e=new MaxRopeLength();
		e.f();
	}
}
