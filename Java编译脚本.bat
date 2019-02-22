set currpath = .\
set dest = %currpath%classes
set classpath= %dest%
set lib=%currpath%lib\c3p0-0.9.1.1.jar;%currpath%lib\log4j-1.2.16.jar;%currpath%lib\quartz-2.2.3.jar;%currpath%lib\quartz-jobs-2.2.3.jar;%currpath%lib\slf4j-api-1.7.7.jar;%currpath%lib\slf4j-log4j12-1.7.7.jar
@echo off

if not exist classes md classes
echo %cd%

javac -d classes -sourcepath %currpath%src -classpath %lib% %currpath%src\scheduler\CronTriggerEngine.java
java -classpath %classpath% CronTriggerEngine