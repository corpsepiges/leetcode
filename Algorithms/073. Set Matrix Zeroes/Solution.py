#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        #列
        n=[1 for col in range(len(matrix[0]))]
        #行
        m=[1 for row in range(len(matrix))]
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j]==0:
                    n[j]=0
                    m[i]=0
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if m[i]==0 or n[j]==0:
                    matrix[i][j]=0