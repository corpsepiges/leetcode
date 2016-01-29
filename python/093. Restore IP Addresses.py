#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        return list(self.f(s,'',0))
    def f(self,s,state,num):
        if num==4:
            if len(s)==0:
                yield ''
        if num<4:
            if len(s)>0:
                if s[0]=='0':
                    for result in self.f(s[1:],state+'.0',num+1):
                        yield '0'+('.'+result if len(result)!=0 else '')
                else:
                    for j in range(1,min(3,len(s))+1):
                        i=int(s[:j])
                        if i>=0 and i<256:
                            for result in self.f(s[j:],state+'.'+str(i),num+1):
                                yield str(i)+('.'+result if len(result)!=0 else '')