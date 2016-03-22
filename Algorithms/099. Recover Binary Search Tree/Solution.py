#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution(object):
    _pre=_m1=_m2=None
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        self._pre=self._m1=self._m2=None
        self.findMistakes(root)
        val=self._m1.val
        self._m1.val=self._m2.val
        self._m2.val=val
    def findMistakes(self,root):
        if not root:
            return
        if root.left:
            self.findMistakes(root.left)
        if self._pre and root.val<self._pre.val:
            if not self._m1:
                self._m1=self._pre
            self._m2=root
        self._pre=root
        if root.right:
            self.findMistakes(root.right)
