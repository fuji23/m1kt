Requirements:
 - Selenium 2.53;
 - Chrome version <= 56 (http://www.geocities.jp/ecvcn/exam/chrome_installer.html);
 - Firefox version <= 46 (https://ftp.mozilla.org/pub/firefox/releases/46.0/win64/en-US/);
 
 Steps how to run:
 1. Run grid (src\test\resources\drivers\grid.bat) to have ability run test in parallel.
 2. Execute maven command: clean test site -Dremote=http://localhost:4445/wd/hub -Dbrowser=firefox (chrome by default);
 3. Find report under "target\site\allure-maven-plugin\index.html".
 
 Note: When opening the report from the local file, either open it in Firefox or launch 
 Chrome with the --allow-file-access-from-files flag. For other browsers, you need to enable cross-origin requests to local files.
