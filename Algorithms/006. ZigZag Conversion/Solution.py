#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if(s.__len__()==0):
            return ''
        if(numRows==1):
            return s
        n=2*numRows-2
        ans=[]
        for i in range(numRows):
            a=[]
            ans.append(a)
        for i in range(s.__len__()):
            k=i%n
            if(k<numRows):
                print k
                ans[k].append(s[i])
            else:
                k-=numRows
                ans[numRows-k-2].append(s[i])
        str=''
        for i in range(numRows):
            for j in range(ans[i].__len__()):
                str+=ans[i][j]
        return str


s='A'
numRows=2
print Solution().convert(s,numRows)