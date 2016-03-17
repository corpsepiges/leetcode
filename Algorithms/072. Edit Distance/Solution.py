#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        l1=len(word1)
        l2=len(word2)
        dict=[[0 for col in range(l1+1)] for row in range(l2+1)]
        for x in range(l2+1):
            for y in range(l1+1):
                if x*y==0:
                    dict[x][y]=max(x,y)
                else:
                    dict[x][y]=dict[x-1][y-1] if word1[y-1]==word2[x-1] else (1+min(dict[x-1][y],dict[x][y-1],dict[x-1][y-1]))
        return dict[-1][-1]