##第一次使用git下载项目
1. 新建一个文件夹作为workspace
2. 在这个文件夹中,右键打开git bash
3. 输入以下指令

		git init
		git remote add origin git@github.com:SPM12/chatLine.git
		git pull origin master
##第一次运行项目须知
1. 创建mysql的schema,起名为chatline
2. 检查src/main/resources下的config.properties文件和你的数据库设置差别,如用户名,密码,url等