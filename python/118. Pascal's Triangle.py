#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        ans=[]
        for i in range(numRows):
            a=[]
            for j in range(i+1):
                if j in (0,i):
                    a.append(1)
                else:
                    a.append(ans[i-1][j-1]+ans[i-1][j])
            ans.append(a)
        return ans