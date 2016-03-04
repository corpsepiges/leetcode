#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        map={}
        strs.sort()
        for s in strs:
            l=list(s)
            l.sort()
            eigenValue=str(l)
            if map.get(eigenValue) is None:
                map[eigenValue]=[s]
            else:
                map.get(eigenValue).append(s)
        return map.values()