#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        rootList=[]
        if root is None:
            return rootList
        rootList.append([root])
        while True:
            a=[]
            for i in range(len(rootList[-1])):
                if rootList[-1][i].left is not None:
                    a.append(rootList[-1][i].left)
                if rootList[-1][i].right is not None:
                    a.append(rootList[-1][i].right)
            if len(a)==0:
                break;
            rootList.append(a)
        ans=[]
        for i in range(len(rootList)):
            a=[]
            for node in rootList[i]:
                a.append(node.val)
            ans.append(a)
        return ans