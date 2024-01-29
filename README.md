# modern-java

This repo has the code for modern java.

## Table of Contents

- Java Installation
  - [Java Installation using Installer](#java-installation-using-installer)
  - [Java Installation using sdkman](#install-java-using-sdk-man)
- Install "ab - Apache HTTP server benchmarking tool"
  - [Mac Installation](#install-ab-on-mac)
  - [Windows Installation](#install-ab-on-windows)

## Java Installation using Installer

- Download the latest java from the below link
  - [Java 21](https://www.oracle.com/java/technologies/downloads/)

## Install the Latest Version of JAVA using SDK man

### Install sdkMan

- Follow the instructions in the below link to install sdkman in your mac.
    - [sdkMan](https://sdkman.io/install)

### Install Java using sdk man

- Run the below command to view the different version of supported Java
```agsl
sdk list java
```
#### How to install a specific Java Version ?

##### Java 21

```linux
sdk list java | grep '21'
```
- Running the below command will install Java 20.

```linux
sdk install 21.0.1-tem
```

## Install "ab - Apache HTTP server benchmarking tool"

### Install ab on mac

### Install ab on windows
- Follow the instructions in the below link to understand more.
 - https://www.inmotionhosting.com/support/edu/wordpress/performance/stress-test-with-apachebench/#test