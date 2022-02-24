echo @off

SET "scriptdir=%~dp0"
IF NOT "%scriptdir:~-1%"=="\" SET "scriptdir=%scriptdir%\"

java -jar %scriptdir%cli\build\libs\cli.jar