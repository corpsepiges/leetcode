#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        leftVal=self.maxNodeVal(root.left)
        rightVal=self.minNodeVal(root.right)
        return False if (leftVal and leftVal>=root.val) or (rightVal and rightVal<=root.val) else self.isValidBST(root.left) and self.isValidBST(root.right)
    def maxNodeVal(self,root):
        if root is None:
            return None
        midVal=root.val
        leftVal=self.maxNodeVal(root.left)
        rightVal=self.maxNodeVal(root.right)
        return max(leftVal if leftVal else midVal,rightVal if rightVal else midVal,midVal)
    def minNodeVal(self,root):
        if root is None:
            return None
        midVal=root.val
        leftVal=self.minNodeVal(root.left)
        rightVal=self.minNodeVal(root.right)
        return min(leftVal if leftVal else midVal,rightVal if rightVal else midVal,midVal)