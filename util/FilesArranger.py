#coding=utf-8
__author__ = 'xuxuan'
import os
import shutil
f=open('E:/leetcode.txt')
titleMap={}
answerPath='e:/leetcode/'
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
    titleMap[title[:-1]]=sid[:-1]
    #https://github.com/corpsepiges/leetcode/blob/master/001.%20Two%20Sum/Solution.py
    # os.mkdir('e:\leetcode\\'+title[:-1])
pyPath = 'E:/github/leetcode/python'
for root, dirs, files in os.walk(pyPath):
    for file in files:
        fileName=file[:-3]
        oldName=pyPath+"/"+fileName+'.py'
        newName=answerPath+fileName+'/Solution.py'
        shutil.copyfile(oldName,newName)
        print titleMap.get(file[:-3])
javaPath = 'E:\github\leetcode\java'
for root, dirs, files in os.walk(javaPath):
    for file in files:
        fileName=file[:-5]
        oldName=javaPath+"/"+fileName+'.java'
        newName=answerPath+fileName+'/Solution.java'
        print oldName,newName
        shutil.copyfile(oldName,newName)



f.close()
