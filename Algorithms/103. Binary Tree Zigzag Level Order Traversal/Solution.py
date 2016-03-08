#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        treeList=[root]
        ans=[]
        i=0
        while len(treeList)>0:
            newTreeList=[]
            a=[]
            for node in treeList:
                if node:
                    a.append(node.val)
                    newTreeList.append(node.left)
                    newTreeList.append(node.right)
            if i%2==1:
                a.reverse()
            if len(a)>0:
                ans.append(a)
            treeList=newTreeList
            i+=1
        return ans