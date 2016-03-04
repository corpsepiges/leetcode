#coding=utf-8
__author__ = 'xuxuan'
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ans=[]
        if not root:
            return ans
        treeList=[]
        treeList.append(root)
        ans.append(root.val)
        while len(treeList)!=0:
            newTreeList=[]
            test=None
            for tree in treeList:
                if tree.left:
                    newTreeList.append(tree.left)
                    test=tree.left.val
                if tree.right:
                    newTreeList.append(tree.right)
                    test=tree.right.val
            if test:
                ans.append(test)
            treeList=newTreeList
        return ans