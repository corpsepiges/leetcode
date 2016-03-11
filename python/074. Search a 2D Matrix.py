#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row=len(matrix)
        if row==0:
            return False
        col=len(matrix[0])
        begin=0
        end=row*col
        while begin<end:
            middle=(begin+end)/2
            x=middle/col
            y=middle%col
            if matrix[x][y]==target:
                return True
            else:
                if matrix[x][y]>target:
                    end=middle
                else:
                    begin=middle+1
        return False