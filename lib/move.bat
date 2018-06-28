d:
echo . 
echo ...initing
 
set str_time_first_bit="%time:~0,1%"
if %str_time_first_bit%==" " (
	set str_date_time=%date:~0,4%%date:~5,2%%date:~8,2%_0%time:~1,1%%time:~3,2%%time:~6,2%
)else ( 
	set str_date_time=%date:~0,4%%date:~5,2%%date:~8,2%_%time:~0,2%%time:~3,2%%time:~6,2%
)
set yymmddhhmmss=%str_date_time%
echo %yymmddhhmmss%

set webapps=D:\tomcat\webapps
set tomcatbin=D:\tomcat\bin
set warnamepath=D:\pipegallery.war
set backpath=D:\back

cd %tomcatbin%

for /F "tokens=5" %%i in ('netstat -ano ^| findstr "0.0.0.0:8080"') do (set n=%%i)
taskkill /F /PID %n%

ping 1.1.1.1 -n 1 -w 20000 > nul

md %backpath%\%yymmddhhmmss%

XCOPY /Y %warnamepath%   %backpath%\%yymmddhhmmss%
@echo off
rd /s/q %webapps%
md %webapps%
MOVE /Y %warnamepath% %webapps%

startup

exit