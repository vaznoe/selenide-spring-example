# Selenide Spring Example

### Prerequisites:
Java should be already installed.
If you need to install the Java SDK [https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html] (e.g. from Oracle's download site).
Once Java is installed, you must ensure that the commands from the Java SDK are in your PATH environment variable. 
Running, for example,
```
java -version
```
must show the right version number.

Example writing PATH environment variable for macOS:
Open up a Terminal window.
Enter the follow commands:
```
touch ~/.bash_profile 
open ~/.bash_profile
```
or if you have .bash_profile already created enter this command:
```
nano ~/.bash_rofile
```
Add the following line to the end of the file adding whatever additional directory you want in your path, for example:
```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home
export PATH=$PATH:$JAVA_HOME/bin
```
Save the .bash_profile file and Quit (Command + Q) Text Edit.
“use :wq! if using nano-editor”

Force the .bash_profile to execute. This loads the values immediately without having to reboot. In your Terminal window, run the following command:
```
source ~/.bash_profile
```

### Please perform following steps:

Clone project:
```
git clone git@github.com:vaznoe/selenide-spring-example.git
```
Open the project directory, you can use the following command:
```
cd selenide-spring-example/
```
From the project directory run test:
```
./mvnw clean test site
```
Generated and open the report:
```
./mvnw io.qameta.allure:allure-maven:serve
```
