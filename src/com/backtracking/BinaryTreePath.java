package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ӡ������·��
 * @author ����
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
	      //�����ַ����Ĳ��ɱ䣬�мǲ�����StringBuilder
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
