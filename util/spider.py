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
        self.js=False
    def toString(self):
        print self.id,self.name,self.url,self.difficulty,self.java,self.python,self.js
class fileInfo(object):
    def __init__(self,f,s,t):
        self.folder=f
        self.suffix=s
        self.title=t

#参数1：本地leetcode项目地址
#办公室
localPath='E:\github\leetcode'
#本机
# localPath='D:\workSpace\pythonWorkSpace\leetcode'
#参数2：自己github项目网址
githubUrl='https://github.com/corpsepiges/leetcode'
githubUrl+='/blob/master/Algorithms/'
#leetcode网站地址
leetcodeUrl='https://leetcode.com'

python=fileInfo('python','py','Python')
java=fileInfo('java','java','Java')
javaScript=fileInfo('js','js','JavaScript')
fileInfos=[java,python,javaScript]



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
re_rules = r'"None"> </span>\n</td>\n<td>(.+?)</td>\n<td>\n<a href="(.+?)">(.+?)</a>(.+?)</td>(.+?)%">(.+?)</td>\n</tr>'
print '建立规则'
p = re.compile(re_rules,re.DOTALL)
print '生成p'
questions = p.findall(str(q))
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
    if name.__contains__('&#39;'):
        name=name.replace('&#39;','\'')
    q=questionInfo(id,name,url,buy,difficulty)
    tableInfo[id]=q
    questionFolderName=folderName+'\\'+id+'. '+name
    if not os.path.exists(questionFolderName):
        print questionFolderName+'不存在，马上建立该文件夹'
        os.mkdir(questionFolderName)
#复制答案
for fi in fileInfos:
    folder=fi.folder
    suffix=fi.suffix
    l=len(suffix)+1
    namePath=localPath+'\\'+folder
    for root, dirs, files in os.walk(namePath):
        for file in files:
            fileName=file[:-(l)]
            questionInfo=tableInfo[fileName[:3]]
            statement='questionInfo.'+folder+'=True'
            exec(statement)
            oldName=namePath+"/"+fileName+'.'+suffix
            newName=folderName+"/"+fileName+'/Solution.'+suffix
            if not os.path.exists(newName):
                print file+'文件未调整位置，马上复制'
                print oldName
                print newName
                shutil.copyfile(oldName,newName)

#生成readme.md
print '开始生成README.MD'
readme=localPath+'\\README.md'
f=open(readme,'w')
f.write('| ID | Title | Difficulty | Note | Java | Python | JavaScript | C++ |\n')
f.write('|----|:--|:--:|:--:|:--:|:--:|:--:|:--:|\n')
for id in tableId:
    q=tableInfo[id]
    oneLine='|'+q.id+'|['+q.name+']('+q.url+')|'+q.difficulty+'|'
    if q.buy:
        oneLine+='noNote|'
        for fi in fileInfos:
            folder=fi.folder
            title=fi.title
            suffix=fi.suffix
            statement='oneLine+=((\'['+title+'](\'+githubUrl+q.id+\'. \'+q.name+\'/Solution.'+suffix+')\') if q.'+folder+' else \'no\')'
            exec(statement)
            oneLine+='|'
        oneLine+='no|\n'
    else:
        oneLine+=('noBuy|'*5+'\n')
    f.write(oneLine)
f.close
print 'README.MD生成完毕'

