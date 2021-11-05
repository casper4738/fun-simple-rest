# UnitTestSample
[![Generic badge](https://img.shields.io/badge/UnitTestSample-v1.0.0-light.svg)](https://shields.io/) [![Generic badge](https://img.shields.io/badge/Language-Java-green.svg)](https://shields.io/)



## Development
**Build**
`folder result` :  build\libs\unit-test.war
```
gradlew assemble 
'or'  gradlew clean assemble
'or'  gradlew build   
'or'  gradlew clean build
```

**Test**
`folder reports` :  build\reports\tests\test\index.html
`folder code coverage`: build\reports\jacoco\test\html\index.html
```
gradlew test
'or' gradlew clean test
```

**Integration Test**
`folder reports` :  build\reports\integrationTest\test\index.html
`folder code coverage`: build\reports\jacoco\test\html\index.html
```
gradlew test
'or' gradlew clean test
```

**Run**
```
gradlew bootRun
```

**Run With Spesific Environment**
```
SPRING_ACTIVE_PROFILE=dev  
gradlew bootRun
```


## Installation

Service require [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) v11+ to  run.

Install the dependencies and devDependencies and start the server.

```
cd "{FOLDER_PROJECT}"
gradlew build
```

## Tools

Tools yang dibutuhkan untuk `coding` di PC.
baik `IDE` maupun tools lainnya yang digunakan bersifat opsional dan dapat diganti dengan yang lain

| Tools | Deskripsi |
| ------ | ------ |
| GIT (mandatory) | [Portal](https://git-scm.com/downloads) -- [Windows 2.31.1-64-bit](https://github.com/git-for-windows/git/releases/download/v2.31.1.windows.1/Git-2.31.1-64-bit.exe) |
| Intelij | [Portal](https://www.jetbrains.com/idea/download/)   --  [Community Version](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)   |
| Source Tree | [Portal](https://www.sourcetreeapp.com/) -- [Windows version 3.4.4](https://product-downloads.atlassian.com/software/sourcetree/windows/ga/SourceTreeSetup-3.4.4.exe) |

## _Copyright_
ATA, All Rights Reserved
**2021@ATA**
