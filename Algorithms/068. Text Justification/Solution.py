#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        ansList=[]
        a=[]
        l=maxWidth
        for word in words:
            if len(word)<=l:
                a.append(word)
                l-=(len(word)+1)
            else:
                l+=len(a)
                if len(a)==1:
                    text=a[0]+' '*l
                    ansList.append(text)
                else:
                    eachSpaceLength=l/(len(a)-1)
                    extra=l%(len(a)-1)
                    text=a[0]
                    for i in range(1,len(a)):
                        text+=(' '*(eachSpaceLength+(1 if i<=extra else 0))+a[i])
                    ansList.append(text)
                l=maxWidth-len(word)-1
                a=[word]
        if len(a)!=0:
            text=''
            for word in a:
                text+=(word+' ')
            text=text[:-1]+' '*(l+1)
            ansList.append(text)
        return ansList