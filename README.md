# FEUP - Sistemas Distribuidos 2018/2019

## L01

Change directory to lab1 folder and compile using `javac Server.java` and `javac Client.java`

### Server
To open server, use command `java Server 4445`

### Client
To send client requests use `java Client localhost 4445 REGISTER 12-12-12 Claudio` and `java Client localhost 4445 LOOKUP 12-12-12`

## L02

Change directory to lab2 folder and compile using `javac Server.java` and `javac Client.java`

### Server
To open server, use command `java Server 8080 225.0.0 8000`

### Client
To send client requests use `java Client 225.0.0.0 8000 REGISTER 12-12-12 Claudio` and `java Client 225.0.0.0 8000 LOOKUP 12-12-12`