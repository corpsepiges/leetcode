#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    _map={0:0}
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        if self._map.get(n) is None:
            self._map[n]=n%2+self.hammingWeight(n/2)
        return self._map[n]