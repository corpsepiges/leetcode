#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    _board=[]
    _rows=0
    _cols=0
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        self._board=board
        self._rows=len(board)
        if self._rows!=0:
            self._cols=len(board[0])
        else:
            return board
        arrays=[0]*(self._rows*self._cols)
        for i in range(len(arrays)):
            m=i/self._cols
            n=i%self._cols
            num=self.f(m,n)
            if num==3 or (num==2 and board[m][n]==1):
                arrays[i]=1
        for i in range(len(arrays)):
            m=i/self._cols
            n=i%self._cols
            board[m][n]=arrays[i]
    def f(self,m,n):
        ans=0
        for i in [-1,0,1]:
            for j in [-1,0,1]:
                if i!=0 or j!=0:
                    ans+=self.isLive(m+i,n+j)
        return ans
    def isLive(self,m,n):
        if m<0 or n<0 or m>=self._rows or n>=self._cols:
            return 0
        else:
            return self._board[m][n]