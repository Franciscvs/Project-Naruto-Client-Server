@ECHO OFF
SETLOCAL
set DIR=%~dp0
set WRAPPER_JAR=%DIR%\.mvn\wrapper\maven-wrapper.jar
set WRAPPER_PROPERTIES=%DIR%\.mvn\wrapper\maven-wrapper.properties
FOR /F "usebackq tokens=1,* delims==" %%A IN (`type "%WRAPPER_PROPERTIES%" ^| findstr /R "^distributionUrl="`) DO set DISTRIBUTION_URL=%%B
IF NOT EXIST "%WRAPPER_JAR%" (
  echo Downloading Maven Wrapper...
  mkdir "%DIR%\.mvn\wrapper" 2>NUL
  powershell -Command "(New-Object Net.WebClient).DownloadFile('https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar','%WRAPPER_JAR%')"
)
java -jar "%WRAPPER_JAR%" -Dmaven.multiModuleProjectDirectory="%DIR%" %*
ENDLOCAL
