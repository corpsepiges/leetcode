#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    _ans=[]
    _nums=[]
    _rows=0
    _cols=0
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        rows=len(matrix)
        if rows==0:
            return 0
        cols=len(matrix[0])
        self._ans=[[0 for col in range(cols)] for row in range(rows)]
        self._nums=matrix
        self._rows=rows
        self._cols=cols
        ans=0
        for i in range(rows):
            for j in range(cols):
                test=self.f(i,j)
                ans=test if test>ans else ans
        print self._ans
        return ans
    def f(self,x,y):
        # if x<0 or x>=self._rows or y<0 or y>=self._cols:
        #     return 0
        if self._ans[x][y]!=0:
            return self._ans[x][y]
        ans=0
        if x>0 and self._nums[x][y]<self._nums[x-1][y]:
            test=self.f(x-1,y)
            ans=test if test>ans else ans
        if x<self._rows-1 and self._nums[x][y]<self._nums[x+1][y]:
            test=self.f(x+1,y)
            ans=test if test>ans else ans
        if y>0 and self._nums[x][y]<self._nums[x][y-1]:
            test=self.f(x,y-1)
            ans=test if test>ans else ans
        if y<self._cols-1 and self._nums[x][y]<self._nums[x][y+1]:
            test=self.f(x,y+1)
            ans=test if test>ans else ans
        self._ans[x][y]=1+ans
        return 1+ans
