#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        return self.f(inorder,postorder,0,len(inorder)-1,0,len(postorder)-1)
    def f(self, inorder, postorder, ib,ie,pb,pe):
        if ib>ie:
            return None
        val=postorder[pe]
        root=TreeNode(val)
        i=inorder.index(val)
        left=self.f(inorder,postorder,ib,i-1,pb,pb+(i-1-ib))
        right=self.f(inorder,postorder,i+1,ie,pb+(i-1-ib)+1,pe-1)
        root.left=left
        root.right=right
        return root