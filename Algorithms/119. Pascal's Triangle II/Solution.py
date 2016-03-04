#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        ans=[1]
        for i in range(rowIndex):
            b=[]
            for j in range(len(ans)-1):
                b.append(ans[j]+ans[j+1])
            ans=[1]+b+[1]
        return ans