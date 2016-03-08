#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    _numsToRoman=[
        ['','I','II','III','IV','V','VI','VII','VIII','IX','X'],
        ['','X','XX','XXX','XL','L','LX','LXX','LXXX','XC','C'],
        ['','C','CC','CCC','CD','D','DC','DCC','DCCC','CM','M'],
        ['','M','MM','MMM'],
    ]
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        s='0'*(4-len(str(num)))+str(num)
        ntr=self._numsToRoman
        return ntr[3][int(s[0])]+ntr[2][int(s[1])]+ntr[1][int(s[2])]+ntr[0][int(s[3])]