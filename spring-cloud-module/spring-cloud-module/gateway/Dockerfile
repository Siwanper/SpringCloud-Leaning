FROM java:8
VOLUME /tmp
ADD ./target/gateway.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=pro"]