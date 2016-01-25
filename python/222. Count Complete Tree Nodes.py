#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        leftHigh=self.getOneSide(root,False)
        rightHigh=self.getOneSide(root,True)
        if leftHigh==rightHigh:
            return (2<<(leftHigh-1))-1
        return 1+self.countNodes(root.left)+self.countNodes(root.right)
    def getOneSide(self,root,direction):
        return 0 if root is None else 1+self.getOneSide(root.right if direction else root.left,direction)