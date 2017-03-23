#coding=utf-8
__author__ = 'xuxuan'
import requests
import json
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
        #语言信息
        self.java=False
        self.python=False
        self.js=False
        self.ruby=False
    def toString(self):
        print self.id,self.name,self.url,self.difficulty,self.java,self.python,self.js
class fileInfo(object):
    def __init__(self,f,s,t):
        #文件夹
        self.folder=f
        #后缀
        self.suffix=s
        #标题
        self.title=t

#参数1：本地leetcode项目地址
#笔记本
#localPath='D:\workSpace\GitHub\leetcode'
#家里
localPath='F:\workSpace\GitHub\leetcode'
#参数2：自己github项目网址
githubUrl='https://github.com/corpsepiges/leetcode'
githubUrl+='/blob/master/Algorithms/'
#leetcode网站地址
leetcodeUrl='https://leetcode.com'
#构造文件信息
python=fileInfo('python','py','Python')
java=fileInfo('java','java','Java')
javaScript=fileInfo('js','js','JavaScript')
ruby=fileInfo('ruby','rb','Ruby')
fileInfos=[java,python,ruby,javaScript]
#统计各语言完成数量
finishNumber={}
#统计免费的题目数量
freeNumber=0

#建立文件夹
folderName=localPath+'\Algorithms'
if os.path.exists(folderName):
    print 'Algorithms已存在'
else:
    print 'Algorithms不存在，马上建立该文件夹'
    os.mkdir(folderName)
page=requests.get('https://leetcode.com/api/problems/algorithms/').content
infos=json.loads(page)
questions=infos['stat_status_pairs']
tableId=[]
tableInfo={}
difficultyIndex=['Easy','Medium','Hard']
for i in range(len(questions)-1,-1,-1):
    question=questions[i]
    name = question['stat'][u'question__title'].encode("utf-8")
    url = question['stat'][u'question__title_slug'].encode("utf-8")
    id = question['stat'][u'question_id']
    buy = question['paid_only']
    difficulty = question['difficulty'][u'level']
    # [id,url,name,buy,acceptance,difficulty]=question
    id=str(id)
    buy=not buy
    difficulty=difficultyIndex[difficulty-1]
    if int(id)<10:
        id='00'+id
    elif int(id)<100:
        id='0'+id
    url=leetcodeUrl+'/problems/'+url+'/'
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
    finishNum=0
    for root, dirs, files in os.walk(namePath):
        for file in files:
            finishNum+=1
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
    finishNumber[folder]=finishNum
#生成readme.md
print '开始生成README.MD'
readme=localPath+'\\README.md'
f=open(readme,'w')
f.write('| ID | Title | Difficulty | Note | Java | Python | Ruby | JavaScript | C++ |\n')
formatStr='|----|:--|'
formatStr+=(':--:|'*(len(fileInfos)+3))
formatStr+='\n'
f.write(formatStr)
for id in tableId:
    q=tableInfo[id]
    oneLine='|'+q.id+'|['+q.name+']('+q.url+')|'+q.difficulty+'|'
    if q.buy:
        oneLine+='noNote|'
        for fi in fileInfos:
            folder=fi.folder
            title=fi.title
            suffix=fi.suffix
            q.name=q.name.replace(' ','%20')
            statement='oneLine+=((\'['+title+'](\'+githubUrl+q.id+\'. \'+q.name+\'/Solution.'+suffix+')\') if q.'+folder+' else \'no\')'
            exec(statement)
            oneLine+='|'
        oneLine+='no|\n'
        freeNumber+=1
    else:
        oneLine+=('noBuy|'*(len(fileInfos)+2)+'\n')
    f.write(oneLine)
f.close
print 'README.MD生成完毕'
print finishNumber
print freeNumber
