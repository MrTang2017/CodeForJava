package com.myoffer.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Test23
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<n; i++)
		{
			String str = in.next();
			if(str.length() < 8)
			{
				int tmplen = 8-str.length();
				for(int j=0; j<tmplen; j++)
				{
					str = str+"0";
				}
				list.add(str);
			}
			else
			{
				while(str.length() > 8)
				{
					String ss = str.substring(0, 8);
					list.add(ss);
					str = str.substring(8, str.length());
				}
				if(str.length() == 8)
				{
					list.add(str);
				}
				else if(str.length() < 8)
				{
					int tmplen = 8-str.length();
					for(int j=0; j<tmplen; j++)
					{
						str = str+"0";
					}
					list.add(str);
				}
			}
		}
		Collections.sort(list, new StringComparator());
		Object[] res = list.toArray();
		for(int i=0; i<res.length-1; i++)
		{
			System.out.print((String)res[i]+" ");
		}
		System.out.println((String)res[res.length-1]);
		
		in.close();
	}
}
class StringComparator implements Comparator<String>
{
	@Override
	public int compare(String o1, String o2)
	{
		return o1.compareTo(o2);
	}
}

