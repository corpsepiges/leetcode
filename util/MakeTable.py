#coding=utf-8
__author__ = 'xuxuan'
import os
import shutil
f=open('E:/leetcode.txt')
titleMap={}
answerPath='e:/leetcode/'
ans=[]
index=0
for line in f.readlines():
    s=line.split('%')[0][:-4]
    s=s.split(' ')
    id=int(s[0])
    # print id
    sid=s[0]
    if id<10:
        sid='00'+sid
    elif id<100:
        sid='0'+sid
    sid+='.'
    s=[sid]+s[1:]
    for i in range(len(s)):
        if s[i].__contains__('\t'):
            s[i]=s[i][1:]
    title=' '.join(s)
    title.replace('\t','')
    titleMap[title[:-1]]=index
    a=[]
    a.append(sid[:-1])
    title=title[5:-1]
    ts=title.split(' ')
    t='-'.join(ts)
    link='['+title+'](https://leetcode.com/problems/'+t+'/)'
    a.append(link)
    a+=['no']*4
    index+=1
    ans.append(a)
    #https://github.com/corpsepiges/leetcode/blob/master/001.%20Two%20Sum/Solution.py
#[id.title,java,python,js,c++]
pyPath = 'E:/github/leetcode/python'
for root, dirs, files in os.walk(pyPath):
    for file in files:
        fileName=file[:-3]
        i=titleMap.get(fileName)
        fileName='[answer](https://github.com/corpsepiges/leetcode/blob/master/'+fileName+'/Solution.py)'
        ans[i][3]=fileName
javaPath = 'E:\github\leetcode\java'
for root, dirs, files in os.walk(javaPath):
    for file in files:
        fileName=file[:-5]
        i=titleMap.get(fileName)
        # print i,ans[i][0],fileName
        fileName='[answer](https://github.com/corpsepiges/leetcode/blob/master/'+fileName+'/Solution.py)'
        ans[i][2]=fileName
print '| ID | Title | Java | Python | JavaScript | C++ |'
print '|----|:--|:--:|:--:|:--:|:--:|'
for a in ans:
    s='|'.join(a)
    print '|'+s+'|'



f.close()


