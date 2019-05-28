package com.myoffer.first;
/**
 * 字符串替换
 * @author 汤吉
 *
 */
public class StringReplace {
    public static String replaceSpace(StringBuffer str) {
    	//先算出空格的数量
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                count++;
        }
        int m=3*count;
        char[] c=new char[str.length()+m];
        int k=0;
        for(int j=0;j<str.length();j++){
            if(str.charAt(j)==' '){
                c[k++]='%';
                c[k++]='2';
                c[k++]='0';
               
            }else{
                c[k++]=str.charAt(j);
            }
        }
        return String.valueOf(c);
        
    }
    
    public static void main(String[] args) {
		StringBuffer stringBuffer=new StringBuffer("kk kkkkkkk");
		System.out.println(replaceSpace(stringBuffer));
	}
    
}


