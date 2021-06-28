FROM openjdk:8-jdk-alpine

MAINTAINER hedu

ADD nsf-agent-v2.6.6-ae06cc43-20200417-150504.jar /nsf-agent.jar
ADD ./consumer/target/consumer-0.0.1-SNAPSHOT.jar /consumer.jar
ADD consumer.yml /consumer.yml

ENTRYPOINT ["java","-Dnsf.log.level=debug","-javaagent:/nsf-agent.jar=consumer","-jar","/consumer.jar"]
