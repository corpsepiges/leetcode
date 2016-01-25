#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if(s.__len__()==0):
            return 0
        map={}
        max=0
        begin=0
        for i in range(s.__len__()):
            if(map.get(s[i])!=None):
                if(i-begin>max):
                    max=i-begin
                if(map.get(s[i])+1>begin):
                    begin=map.get(s[i])+1
            map[s[i]]=i
        print begin
        if(s.__len__()-begin>max):
            max=s.__len__()-begin
        return max
s="abcb"
print Solution().lengthOfLongestSubstring(s)