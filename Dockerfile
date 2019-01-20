FROM openjdk:8-jdk-alpine


ADD target/bee-love-1.0.0.jar bee-love-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bee-love-1.0.0.jar"]
HEALTHCHECK --interval=1s --timeout=3s \
  CMD curl -f -X GET --header 'Accept: application/json'   --header 'content-type: application/json'  'http://localhost:8080/' || exit 0

