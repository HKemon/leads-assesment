FROM java:8
VOLUME /tmp
ADD target/assesment.jar assesment.jar
RUN bash -c 'touch /assesment.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/assesment.jar"]