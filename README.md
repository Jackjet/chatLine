##��һ��ʹ��git������Ŀ
1. �½�һ���ļ�����Ϊworkspace
2. ������ļ�����,�Ҽ���git bash
3. ��������ָ��

		git init
		git remote add origin git@github.com:SPM12/chatLine.git
		git pull origin master
		git merge origin/master

##֮������
###������Ҫ���湤��
####����Ѿ���ɲ����Ժ���һ������

		git add *
		git commit -m "<����ʲô>"

####����,����û�Ķ���BUGA
		
		git stash
	
���������Ҫ��������,���Ի�ȥ�Ķ�BUGA,

		git stash pop

###�����깤����
		
		git pull origin master
		git merge origin/master

�������merge��״̬,��������:q�˳�merge��Ϣ�༭,֮������ʾ��merge���ļ�,��merge���Ƿ��
		
##������Ŀ��֪
		
		git add *
		git commit -m "<����ʲô>"
		git pull origin master 
		git merge origin/master �����˼��
		git push origin master:dev

		֮�������call me���,��������ҲҪ��һ��ϵͳ����
		
##��һ��������Ŀ��֪
1. ����mysql��schema,����Ϊchatline
2. ���src/main/resources�µ�config.properties�ļ���������ݿ����ò��,���û���,����,url��

##��Ҫ:�汾rm .project
Ϊ�˷�ֹ��������,�汾rm .projectɾ����.project�������ļ�,�����Ҫ���¿���,��Ҫ��ϵ�л����������е����°����Ա