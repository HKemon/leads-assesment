## How to run it with Docker

## Run MySQL in Docker container:

`docker run --name students-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=leads_assesment -e MYSQL_USER=emon -e MYSQL_PASSWORD=emon -d mysql`

wait until students-mysql fully run

Then find out on which host students-mysql is running. then change the `custom.host` from application.properties file

You can see the host by the following command

`docker inspect students-mysql` 

From `Networks > IPAddress`

For my case it was `172.17.0.2`

(I found in internet that they use the container name but it did not work for me.)

## Then create the jar file 

`mvn clean package`

## Build docker file

`docker build . -t assesment.jar`

Run demo application in Docker container and link to demo-mysql:

`docker run -p 8080:8080 --name assesment --link students-mysql -d assesment.jar`

## Rest Api

List of All Students : `http://localhost:8080/get-student-list` 

Get a specific student : `http://localhost:8080/get-student/{id}`

Create student Record: `http://localhost:8080/save`

Edit student Record: `http://localhost:8080/update-student/{id}`

Pathc student Record: `http://localhost:8080/update-student/{id}`



Frontend is not still complete