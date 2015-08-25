@ECHO OFF

rem %~dp0 is the expanded pathname of the current script under NT
set LOCAL_ZSM_HOME=
if "%OS%"=="Windows_NT" set LOCAL_ZSM_HOME=%~dp0
::set JAVA_HOME=c:\Programme\Java\jre1.5.0_13\
set LIBDIR=%LOCAL_ZSM_HOME%..\lib
::set LOCALCLASSPATH=%LOCAL_ZSM_HOME%zsm.jar
set LOCALCLASSPATH=%LOCAL_ZSM_HOME%zsm_gui.jar
set LOCALCLASSPATH=%LOCALCLASSPATH%;%LIBDIR%\options.jar
set LOCALCLASSPATH=%LOCALCLASSPATH%;%LIBDIR%\ant.jar
set LOCALCLASSPATH=%LOCALCLASSPATH%;%LIBDIR%\ant-javamail.jar
set LOCALCLASSPATH=%LOCALCLASSPATH%;%LIBDIR%\mail.jar
set LOCALCLASSPATH=%LOCALCLASSPATH%;%LIBDIR%\smtp.jar
::echo %LOCALCLASSPATH%
java -cp "%LOCALCLASSPATH%" de.ich_bin_am_wandern_gewesen.gui.ZSMGui %*
