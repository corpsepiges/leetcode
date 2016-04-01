#coding=utf-8
__author__ = 'xuxuan'
class NumMatrix(object):
    _board=[]
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        row=len(matrix)+1
        col=1 if row==1 else (len(matrix[0])+1)
        self._board=[([0] * col) for i in range(row)]
        for i in range(1,row):
            for j in range(1,col):
                self._board[i][j]=self._board[i][j-1]+self._board[i-1][j]-self._board[i-1][j-1]+matrix[i-1][j-1]
    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        return self._board[row2+1][col2+1]-self._board[row2+1][col1]-self._board[row1][col2+1]+self._board[row1][col1]

# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix(matrix)
# numMatrix.sumRegion(0, 1, 2, 3)
# numMatrix.sumRegion(1, 2, 3, 4)