#coding=utf-8
__author__ = 'xuxuan'
import requests
import BeautifulSoup
import re
import os
import shutil
#本项目只需要配置2个参数：
#1.本地leetcode项目地址
#2.github项目地址
#备注：
#1.本地拷贝下来后项目文件夹明明分别为java，python（语言名命名，小写字母）
#2.所有答案直接复制题目本身的提供的命名，后缀名对应语言本身（例如python—>py,java—>java）
#2-1.文件命名格式样例：004. Median of Two Sorted Arrays.py
#2-2.文件数字必须为三位数，不够用0补齐
#2-3.文件名id后的小点后面有一个空格
#3.每次写完答案后对应格式的语言答案放入对应的语言文件夹中
class questionInfo(object):
    def __init__(self,i,n,u,b,d):
        self.id=i
        self.name=n
        self.url=u
        self.buy=b
        self.difficulty=d
        self.java=False
        self.python=False
    def toString(self):
        print self.id,self.name,self.url,self.difficulty,self.java,self.python


#参数1：本地leetcode项目地址
localPath='D:\workSpace\pythonWorkSpace\leetcode'
#参数2：自己github项目网址
githubUrl='https://github.com/corpsepiges/leetcode'
githubUrl+='/blob/master/Algorithms/'
#leetcode网站地址
leetcodeUrl='https://leetcode.com'
#python答案文件夹
pythonPath=localPath+'\python'
#java答案文件夹
javaPath=localPath+'\java'
#建立文件夹
folderName=localPath+'\Algorithms'
if os.path.exists(folderName):
    print 'Algorithms已存在'
else:
    print 'Algorithms不存在，马上建立该文件夹'
    os.mkdir(folderName)
page=requests.get('https://leetcode.com/problemset/algorithms/')
page=page.content
soup = BeautifulSoup.BeautifulSoup(page)
q=soup.findAll('tr')
print len(q)
re_rules = r'"None"> </span>\n</td>\n<td>(.+?)</td>\n<td>\n<a href="(.+?)">(.+?)</a>(.+?)</td>(.+?)%">(.+?)</td>\n</tr>'
print '建立规则'
p = re.compile(re_rules,re.DOTALL)
print '生成p'
questions = p.findall(str(q))
print len(questions)
tableId=[]
tableInfo={}

for i in range(len(questions)-1,-1,-1):
    question=questions[i]
    [id,url,name,buy,acceptance,difficulty]=question
    if int(id)<10:
        id='00'+id
    elif int(id)<100:
        id='0'+id
    url=leetcodeUrl+url
    buy=len(buy)<5
    tableId.append(id)
    q=questionInfo(id,name,url,buy,difficulty)
    tableInfo[id]=q
    questionFolderName=folderName+'\\'+id+'. '+name
    if not os.path.exists(questionFolderName):
        print questionFolderName+'不存在，马上建立该文件夹'
        os.mkdir(questionFolderName)
#复制python答案
for root, dirs, files in os.walk(pythonPath):
    print type(files)
    for file in files:
        fileName=file[:-3]
        questionInfo=tableInfo[fileName[:3]]
        questionInfo.python=True
        oldName=pythonPath+"/"+fileName+'.py'
        newName=folderName+"/"+fileName+'/Solution.py'
        if not os.path.exists(newName):
            print file+'文件未调整位置，马上复制'
            shutil.copyfile(oldName,newName)
#复制java答案
for root, dirs, files in os.walk(javaPath):
    print type(files)
    for file in files:
        fileName=file[:-5]
        questionInfo=tableInfo[fileName[:3]]
        questionInfo.java=True
        oldName=javaPath+"/"+fileName+'.java'
        newName=folderName+"/"+fileName+'/Solution.java'
        if not os.path.exists(newName):
            print file+'文件未调整位置，马上复制'
            shutil.copyfile(oldName,newName)
#生成readme.md
readme=localPath+'\\README.md'
f=open(readme,'w')
f.write('| ID | Title | Note | Java | Python | JavaScript | C++ |\n')
f.write('|----|:--|:--:|:--:|:--:|:--:|:--:|\n')
for id in tableId:
    q=tableInfo[id]
    oneLine='|'+q.id+'|['+q.name+']('+q.url+')|'
    if q.buy:
        oneLine+='noNote|'
        if q.java:
            oneLine+='[Java]('+githubUrl+q.id+'. '+q.name+'/Solution.java)'
        else:
            oneLine+='no'
        oneLine+='|'
        if q.python:
            oneLine+='[Python]('+githubUrl+q.id+'. '+q.name+'/Solution.py)'
        else:
            oneLine+='no'
        oneLine+='|no|no|\n'
    else:
        oneLine+='noBuy|'*5
    f.write(oneLine)
f.close


