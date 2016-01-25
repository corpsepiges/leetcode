#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs)==0:
            return ''
        ans=strs[0]
        for str in strs:
            ans=self.findSameWord(str,ans)
        return ans

    def findSameWord(self,str1,str2):
        if len(str1)>len(str2):
            return self.findSameWord(str2,str1)
        l=len(str1)
        if l==0:
            return ''
        ans=''
        for i in range(l):
            if str1[i]==str2[i]:
                ans+=str1[i]
            else:
                break
        return ans