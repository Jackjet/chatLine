##第一次使用git下载项目
1. 新建一个文件夹作为workspace
2. 在这个文件夹中,右键打开git bash
3. 输入以下指令

		git init
		git remote add origin git@github.com:SPM12/chatLine.git
		git pull origin master
		git merge origin/master

##之后下载
###首先需要保存工作
####如果已经完成并测试好了一个功能

		git add *
		git commit -m "<做了什么>"

####否则,若还没改动完BUGA
		
		git stash
	
等完成了需要做的事情,可以回去改动BUGA,

		git stash pop

###保存完工作后
		
		git pull origin master
		git merge origin/master

如果出现merge的状态,可以输入:q退出merge信息编辑,之后检查提示的merge的文件,看merge的是否对
		
##推送项目须知
		
		git add *
		git commit -m "<做了什么>"
		git pull origin master 
		git merge origin/master 别忘了检查
		git push origin master:dev

		之后请务必call me检查,否则至少也要做一次系统测试
		
##第一次运行项目须知
1. 创建mysql的schema,起名为chatline
2. 检查src/main/resources下的config.properties文件和你的数据库设置差别,如用户名,密码,url等

##重要:版本rm .project
为了防止覆盖设置,版本rm .project删除了.project等配置文件,如果需要重新拷贝,需要联系有还能正常运行的最新版的组员