#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        if n==0:
            return [0]
        else:
            ans=self.grayCode(n-1)
        return ans+[pow(2,n-1)+x for x in ans[::-1]]