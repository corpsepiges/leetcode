#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    _words=['One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
    _tens=['Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
    _unit=['Billion','Million','Thousand']
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num==0:
            return 'Zero'
        ans=[]
        for i in range(4):
            ans.append(num%1000)
            num/=1000
        res=''
        unit=self._unit
        for i in range(4):
            if ans[3-i]!=0:
                if len(res)!=0:
                    res+=' '
                res+=self.n2w(ans[3-i])
                if i!=3:
                    res+=(' '+unit[i])
        return res
    def n2w(self,num):
        if num==0:
            return ''
        hund=num/100
        other=num%100
        res='' if hund==0 else (self._words[hund-1]+' Hundred')
        if other==0:
            return res
        else:
            if len(res)!=0:
                res+=' '
            if other<20:
                return res+self._words[other-1]
            else:
                o1=other/10
                o2=other%10
                return res+self._tens[o1-2]+('' if o2==0 else (' '+self._words[o2-1]))