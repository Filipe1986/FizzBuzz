FROM openjdk:11

WORKDIR app

ADD target/*.jar /app/fizzbuzz-api.jar

CMD java $JAVA_OPTS -jar /app/fizzbuzz-api.jar