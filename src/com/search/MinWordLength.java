package com.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典， 
 * 找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则： 
 * 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典中的单词。
 * 
 *  输入: beginWord =
 * "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 *  输出:
 * 5 "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * 
 * @author 汤吉
 *
 */


public class MinWordLength {

	
	//超时，缺失优化，比如双端BFS
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		if (!wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		// 访问记录
		List<String> visited = new ArrayList<>();
		int minLength = 1;
		while (queue.size() > 0) {
			minLength++;
			int size = queue.size();
			while (size-- > 0) {
				String curWord = queue.poll();
				visited.add(curWord);
				for (int i = 0; i < curWord.length(); i++) {
					char[] chars = curWord.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						chars[i] = c;
						String word = new String(chars);
						if (wordList.contains(word) && word.equals(endWord)) {
							return minLength;
						}
						if (wordList.contains(word) && !visited.contains(word)) {
							queue.add(word);
							visited.add(word);
						}
					}

				}
			}
		}

		return 0;

	}

	
/**
 * 使用双端BFS,37ms
 * @param beginWord
 * @param endWord
 * @param wordList
 * @return
 */
	public static int ladderLength3(String beginWord, String endWord, List<String> wordList) {
	 if (wordList == null || wordList.size() == 0) return 0;
     HashSet<String> start = new HashSet<>();
     HashSet<String> end = new HashSet<>();
     //转换成hashset
     HashSet<String> dic = new HashSet<>(wordList);
     start.add(beginWord);
     end.add(endWord);
     int step=1;
     if (!dic.contains(endWord)) return 0;
     while(!start.isEmpty()){
         step++;
         HashSet<String> tmpSet=new HashSet<>();//下一层的临近点
         dic.removeAll(start);//使用过的移除
         for(String s:start){
             char[] arr=s.toCharArray();
             for(int i=0;i<arr.length;i++){
                 char tmp=arr[i];
                 //变化
                 for(char c='a';c<='z';c++){
                	 //与当前一样的跳过
                     if(tmp==c) continue;
                     arr[i]=c;
                     String strTmp=new String(arr);
                     if(dic.contains(strTmp)){
                         if(end.contains(strTmp)){
                             return step;
                         }else{
                             tmpSet.add(strTmp);
                         }
                     }
                 }
                 //还原
                 arr[i]=tmp;
             }
         }
         //用最少的找最多的
         if(tmpSet.size()<end.size()){
             start=tmpSet;
         }else{
             start=end;
             end=tmpSet;
         }
         
     }
     return 0;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "hot";
		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> list = (List<String>) Arrays.asList(wordList);
		// System.out.println(list.size());
		System.out.println(ladderLength3(beginWord, endWord, list));
	}
}
