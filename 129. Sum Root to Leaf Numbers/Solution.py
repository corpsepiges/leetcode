#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        strs=list(self.f(root,''))
        ans=0
        for s in strs:
            ans+=int(s)
        return ans
    def f(self,root,s):
        if root is None:
            yield ''
        elif root.left is None and root.right is None:
            yield str(root.val)
        else:
            if root.left is not None:
                for result in self.f(root.left,s+str(root.val)):
                        yield str(root.val)+result
            if root.right is not None:
                for result in self.f(root.right,s+str(root.val)):
                        yield str(root.val)+result