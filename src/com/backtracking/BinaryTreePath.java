package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印二叉树路径
 * @author 汤吉
 *
 */
public class BinaryTreePath {

	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val) {
			this.val=val;
			this.left=null;
			this.right=null;
		}
			
	}
	
	 public List<String> binaryTreePaths(TreeNode root) {
	      List<String> list=new ArrayList<>();
	      if (root==null) {
			return list;
		}
	      //利用字符串的不可变，切记不可用StringBuilder
	      String pathStr="";
	      df(root,pathStr,list);
	      return list;
	 
	 }
	
	private void df(TreeNode root, String pathStr, List<String> list) {
		if (root==null) {
			return;
		}
		pathStr=pathStr+(root.val);
		if (root.left==null && root.right==null) {
			list.add(pathStr.toString());
			return;
		}		
		pathStr=pathStr+("->");
		if (root.left!=null) {
			df(root.left, pathStr, list);
		}
		if (root.right!=null) {
			df(root.right, pathStr, list);
		}	
	}

	public static void main(String[] args) {
		

	}

}
