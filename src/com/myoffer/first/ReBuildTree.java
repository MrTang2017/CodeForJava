package com.myoffer.first;

public class ReBuildTree {
		
		 public TreeNode buildTree(int[] preorder, int[] inorder) {
	            
		        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
		    }
		    public TreeNode buildTree(int[] preorder,int preLeft,int preRight,int[] inorder,int inLeft, int inRight){
		        
		        if(preLeft>preRight || inLeft>inRight){
		            return null;
		        }
		        TreeNode root=new TreeNode(preorder[preLeft]);
		        //指向同一个节点，即只有一个节点
		        if(preorder==inorder)
		            return root;
		        int k=0;
		        for(int i=inLeft;i<=inRight;i++){
		            if(inorder[i]==root.value){
		                k=i;
		                break;
		            }
		        }
		        int length=k-inLeft;
		        root.left=buildTree(preorder,preLeft+1,preLeft+length,inorder,inLeft,inLeft+length-1);
		        root.right=buildTree(preorder,preLeft+length+1,preRight,inorder,k+1,inRight);
		        return root;
		    }
}
