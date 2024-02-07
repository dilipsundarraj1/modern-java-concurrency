# modern-java

This repo has the code for modern java.

## Table of Contents

- Java Installation
  - [Java Installation using Installer](#java-installation-using-installer)
  - [Java Installation using sdkman](#install-java-using-sdk-man)
- Install "ab - Apache HTTP server benchmarking tool"
  - [Mac Installation](#install-ab-on-mac)
  - [Windows Installation](#install-ab-on-windows)
- [Spring Boot using Virtual Threads](#spring-boot-using-virtual-threads)
  - [Remote Service](#remote-service)
  - [Benchmarking with "ab - Apache HTTP server benchmarking tool"](#benchmarking-with-ab---apache-http-server-benchmarking-tool)
    - [Benchmark with 10 requests with the 10 concurrent users ](#benchmark-with-10-requests-with-the-10-concurrent-users-)
    - [Benchmark with 20 requests with the 10 concurrent users](#benchmark-with-20-requests-with-the-10-concurrent-users)
    - [Benchmark with 60 requests with the 20 concurrent users](#benchmark-with-60-requests-with-the-20-concurrent-users)

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

## Spring Boot using Virtual Threads

### application.yml

- Add the below config in the application.yml

```yml
spring:
  threads:
    virtual:
      enabled: true
```

### Validate virual threads are enabled

- Run the below command to check the thread executing the request

```curl
curl -i http://localhost:8080/currentThread  
```

### Remote Service

```curl
curl -i http://localhost:8085/remote/2  
```

### Client Call to remote Service

```curl
curl -i  http://localhost:8080/blocking/1
```

## Benchmarking with "ab - Apache HTTP server benchmarking tool"

### Set Up

#### application.yml

- We are just going to have 10 tomcat threads to handle our requests
  - This is to simplify our testing and comparison will be straightforward with this config
```
server:
  tomcat:
    threads:
      max: 10
```

### Benchmark with 10 requests with the 10 concurrent users 

- This command will run ten requests with the concurrency of 10.
  - This means all the 10 requests will be run in parallel.
  - Since we are passing **2**, then it should take approximately 2 seconds to complete.
  
```bash
ab -n 10 -c 10  http://localhost:8080/blocking/2
```

### Benchmark with 20 requests with the 10 concurrent users

- This command will run ten requests with the concurrency of 10.
  - This means all the 10 requests will be run in parallel.
  - Since we are passing **2**, then it should take approximately 4 seconds to complete.

```bash
ab -n 20 -c 10  http://localhost:8080/blocking/2
```

#### With Virtual Threads

- It took **6.055** seconds to complete
  - Ideally it should have completed in ~4 seconds, but the benchmarking tool adds a little bit of delay to the overall time to complete.

#### Without Virtual Threads

- It took **6.199** seconds to complete

### Benchmark with 60 requests with the 20 concurrent users

```bash
ab -n 60 -c 20  http://localhost:8080/blocking/2
```
- Each batch we will send 20 requests and wait for it to complete.
  - So in this case, there will be 3 batches of 20 concurrent requests will be sent.
  
#### With Virtual Threads

- It took **8.078** seconds to complete
  - Ideally it should have completed in ~6 seconds, but the benchmarking tool adds a little bit of delay to the overall time to complete.
  - The Average time for each request is ~2 seconds
  ```text
  Percentage of the requests served within a certain time (ms)
  50%   2022
  66%   2023
  75%   2023
  80%   2024
  90%   2025
  95%   2026
  98%   2026
  99%   2026
  100%   2026 (longest request)
  ```
  
#### Without Virtual Threads

- It took **14.179** seconds to complete
  - The Average time for each request is ~4 seconds
  ```text
  Percentage of the requests served within a certain time (ms)
    50%   4037
    66%   4037
    75%   4038
    80%   4039
    90%   4040
    95%   4040
    98%   4041
    99%   4041
   100%   4041 (longest request)
  
  ```

#### Summary 

- The results above prove virtual-threads are far better in handling blocking IO calls better than the platform threads.