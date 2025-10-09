@ECHO OFF

CALL %CATALINA_HOME%\bin\shutdown.bat

CALL mvn clean package

REM DEL %CATALINA_HOME%\webapps\myechoservlet.war
REM RD %CATALINA_HOME%\webapps\myechoservlet /s /q


DEL %CATALINA_HOME%\webapps\ROOT.war
RD %CATALINA_HOME%\webapps\ROOT /s /q

COPY target\ROOT.war %CATALINA_HOME%\webapps

CALL %CATALINA_HOME%\bin\startup.bat