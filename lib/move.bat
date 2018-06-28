e:
echo . 
echo ...initing
echo 脚本开始
set str_time_first_bit="%time:~0,1%"
if %str_time_first_bit%==" " (
	set str_date_time=%date:~0,4%%date:~5,2%%date:~8,2%_0%time:~1,1%%time:~3,2%%time:~6,2%
)else ( 
	set str_date_time=%date:~0,4%%date:~5,2%%date:~8,2%_%time:~0,2%%time:~3,2%%time:~6,2%
)
set yymmddhhmmss=%str_date_time%
echo 设置文件夹名称
echo %yymmddhhmmss%
set webapps=E:\apache-tomcat-7.0.52\webapps
echo 设置webapps路径为%webapps%
set tomcatbin=E:\apache-tomcat-7.0.52\bin
echo 设置tomcatbin路径为%tomcatbin%
set warnamepath=E:\bridge.war
echo 设置warnamepath路径为%warnamepath%

set backpath=E:\back
echo 设置备份路径为%backpath%
cd %tomcatbin%
echo 切换%tomcatbin%路径
set prot=8080
for /F "tokens=5" %%i in ('netstat -ano ^| findstr "0.0.0.0:%prot%"') do (set n=%%i)
taskkill /F /PID %n%
echo 强杀端口执行完毕
ping 1.1.1.1 -n 1 -w 20000 > nul

md %backpath%\%yymmddhhmmss%
echo 创建备份目录%backpath%\%yymmddhhmmss%

XCOPY /Y %warnamepath%   %backpath%\%yymmddhhmmss%
echo 拷贝文件%warnamepath% 到备份目录%backpath%\%yymmddhhmmss%

@echo off

rd /s/q %webapps%
echo 删除旧程序包%webapps%

md %webapps%
echo 新建目录%webapps%

MOVE /Y %warnamepath% %webapps%
echo 移到%warnamepath%文件 到%webapps%目录

startup
echo 执行启动程序脚本完毕
echo 全部脚本执行完毕！！！
exit