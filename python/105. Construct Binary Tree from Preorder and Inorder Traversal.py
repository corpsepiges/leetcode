#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def buildTree(self,preorder, inorder, ):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        return self.f(inorder,preorder,0,len(inorder)-1,0,len(preorder)-1)
    def f(self, inorder, preorder, ib,ie,pb,pe):
        if ib>ie:
            return None
        val=preorder[pb]
        root=TreeNode(val)
        i=inorder.index(val)
        left=self.f(inorder,preorder,ib,i-1,pb+1,pb+1+(i-1-ib))
        right=self.f(inorder,preorder,i+1,ie,pb+1+(i-1-ib)+1,pe)
        root.left=left
        root.right=right
        return root