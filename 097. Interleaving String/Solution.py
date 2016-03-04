#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        l1=len(s1)
        l2=len(s2)
        if l1+l2!=len(s3):
            return False
        matrix=[[False for col in range(l1+1)] for row in range(l2+1)]
        matrix[l2][l1]=True
        for i in range(1,l1+1):
            ans=s1[-i]==s3[-i]
            if ans:
                matrix[l2][l1-i]=True
            else:
                break
        for i in range(1,l2+1):
            ans=s2[-i]==s3[-i]
            if ans:
                matrix[l2-i][l1]=True
            else:
                break
        for i in range(l2-1,-1,-1):
            for j in range(l1-1,-1,-1):
                matrix[i][j]=(s2[i]==s3[i+j] and matrix[i+1][j]) or (s1[j]==s3[i+j] and matrix[i][j+1])
        return matrix[0][0]