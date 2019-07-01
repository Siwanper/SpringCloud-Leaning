FROM java:8
VOLUME /tmp
ADD ./target/service-a.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8001
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=pro"]