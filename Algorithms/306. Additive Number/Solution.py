#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        l=len(num)
        for i in range(2,l*2/3+2):
            for j in range(1,i):
                first=num[:j]
                second=num[j:i]
                other=num[i:]
                if len(first)<=len(other) and len(second)<=len(other) and self.isTrue(first,second,other):
                    return True
        return False

    def isTrue(self,first,second,other):
        if (first[0]=='0' and len(first)>1) or (second[0]=='0' and len(second)>1):
            return False
        a=int(first)
        b=int(second)
        l=len(str(a+b))
        if l<=len(other) and a+b==int(other[:l]):
            if l==len(other):
                return True
            return self.isTrue(second,other[:l],other[l:])
        return False