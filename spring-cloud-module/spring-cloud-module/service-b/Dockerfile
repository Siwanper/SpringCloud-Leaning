FROM java:8
VOLUME /tmp
ADD ./target/service-b.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8002
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=pro"]