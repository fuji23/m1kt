cmd /C start/MIN java -jar selenium-server-standalone-2.53.0.jar -role hub -port 4445 -timeout 0 -browserTimeout 0
cmd /C start/MIN java -jar selenium-server-standalone-2.53.0.jar -Dwebdriver.chrome.driver=chromedriver.exe -role node -hub http://localhost:4445/grid/register -port 25697
cmd /C start/MIN java -jar selenium-server-standalone-2.53.0.jar -Dwebdriver.chrome.driver=chromedriver.exe -role node -hub http://localhost:4445/grid/register -port 25698
cmd /C start/MIN java -jar selenium-server-standalone-2.53.0.jar -Dwebdriver.chrome.driver=chromedriver.exe -role node -hub http://localhost:4445/grid/register -port 25696
cmd /C start/MIN java -jar selenium-server-standalone-2.53.0.jar -Dwebdriver.chrome.driver=chromedriver.exe -role node -hub http://localhost:4445/grid/register -port 25699
