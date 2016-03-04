#coding=utf-8
__author__ = 'xuxuan'
import random
import socket
import urllib2
import urllib
import re
import string
import BeautifulSoup
import sys
import cookielib
import time
ERROR = {
        '0':'Can not open the url,checck you net',
        '1':'Creat download dir error',
        '2':'The image links is empty',
        '3':'Download faild',
        '4':'Build soup error,the html is empty',
        '5':'Can not save the image to your disk',
    }

class BrowserBase(object):
    """模拟浏览器"""
    def __init__(self):
        socket.setdefaulttimeout(20)
        self.HTML = ''

    def openurl(self,url):
        """
        打开网页
        """
        cookie_support= urllib2.HTTPCookieProcessor(cookielib.CookieJar())
        self.opener = urllib2.build_opener(cookie_support,urllib2.HTTPHandler)
        urllib2.install_opener(self.opener)
        user_agents = [
                    'Mozilla/5.0 (Windows; U; Windows NT 5.1; it; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11',
                    'Opera/9.25 (Windows NT 5.1; U; en)',
                    'Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)',
                    'Mozilla/5.0 (compatible; Konqueror/3.5; Linux) KHTML/3.5.5 (like Gecko) (Kubuntu)',
                    'Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.0.12) Gecko/20070731 Ubuntu/dapper-security Firefox/1.5.0.12',
                    'Lynx/2.8.5rel.1 libwww-FM/2.14 SSL-MM/1.4.1 GNUTLS/1.2.9',
                    "Mozilla/5.0 (X11; Linux i686) AppleWebKit/535.7 (KHTML, like Gecko) Ubuntu/11.04 Chromium/16.0.912.77 Chrome/16.0.912.77 Safari/535.7",
                    "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:10.0) Gecko/20100101 Firefox/10.0 ",

                    ]

        agent = random.choice(user_agents)
        self.opener.addheaders = [("User-agent",agent),("Accept","*/*"),('Referer','http://www.google.com')]
        try:
            res = self.opener.open(url)
            self.HTML = res.read()
#            print res.read()
        except Exception,e:
            # self.speak(str(e),url)
            raise Exception
        else:
            return res



    def getMainArticle(self):
        """get the main article of CSDN blog"""
        soup = BeautifulSoup.BeautifulSoup(self.HTML)
        title_name=soup.findAll('span',{'class':'link_title'})
        re_rules = r'<span class="(.+?)"><a href="(.+?)">(.+?)</a>'
        p = re.compile(re_rules,re.DOTALL)
        title = p.findall(str(title_name))[0][2].strip()
        # print 'title=',title
        title=title.split('—' if title.__contains__('—') else '-')[1]
        zero=3-len(title.split('.' if title.__contains__('.') else ' ')[0])
        title='0'*zero+title
        index=title[:3]
        content=title[3:]
        while content[0]=='.' or content[0]==' ':
            content=content[1:]
        title=index+'. '+content
        # print title
        main_content=soup.findAll('pre',{'name':'code'})
        re_rules=r'">(.+?)</pre>'
        p = re.compile(re_rules,re.DOTALL)
        code = p.findall(str(main_content))
        code=code[0]
        strinfo = re.compile('&lt;')
        code = strinfo.sub('<',code)
        strinfo = re.compile('&gt;')
        code = strinfo.sub('>',code)
        strinfo = re.compile('&quot;')
        code = strinfo.sub('"',code)
        strinfo = re.compile('&amp;')
        code = strinfo.sub('&',code)
        fileName = "csdn/"+title+".java"
        if fileName.__contains__('\t'):
            fileName=fileName.replace('\t','')
        f = open(fileName,"w+")
        print u"正在保存代码",fileName
        f.write(code)

    def getArticleUrl(self):
        soup = BeautifulSoup.BeautifulSoup(self.HTML)
        # print soup
        title_name=soup.findAll('span',{'class':'link_title'})
        re_rules = r'<span class="link_title"><a href="(.+?)">'
        p = re.compile(re_rules,re.DOTALL)
        title = p.findall(str(title_name))
        return title

flag=False
# flag=not flag
if flag:
    browser = BrowserBase()
    url='http://blog.csdn.net/corpsepiges/article/details/46843959'
    browser.openurl(url)
    browser.getMainArticle()
else:
    for i in range(10,15):
        total_url='http://blog.csdn.net/corpsepiges/article/list/'+str(i)
        print '目录第'+str(i)+'页：'+total_url
        total_browser = BrowserBase()
        total_browser.openurl(total_url)
        articleUrlList=total_browser.getArticleUrl()
        print ' len(articleUrlList)', len(articleUrlList)
        for url in articleUrlList:
            url='http://blog.csdn.net'+url
            print url
            browser = BrowserBase()
            browser.openurl(url)
            browser.getMainArticle()
            time.sleep(2)
        time.sleep(2)



