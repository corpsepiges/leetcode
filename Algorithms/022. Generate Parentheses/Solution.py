#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        return list(self.createAnswer(n,'',0,0))

    def createAnswer(self,n,string,left,right):
        if left==n and right==n-1:
            yield ')'
        else:
            if left==right or (left>right and left!=n):
                 for result in self.createAnswer(n,string+'(',left+1,right):
                    yield '('+result
            if left>right:
                for result in self.createAnswer(n,string+')',left,right+1):
                    yield ')'+result