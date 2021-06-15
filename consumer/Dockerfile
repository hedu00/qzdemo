#FROM harbor-poc666.netease.com/hd-hdpro/openjdk:8-jdk-alpine
FROM openjdk:8-jdk-alpine

MAINTAINER hedu

ADD http://console-poc666.netease.com/download/nsf/nsf-agent-v2.6.6-ae06cc43-20200417-150504.jar /nsf-agent.jar
ADD ./target/consumer-0.0.1-SNAPSHOT /consumer.jar
ADD qzlib/consumer.yml /consumer.yml

ENTRYPOINT ["java","-Dnsf.log.level=debug","-javaagent:/nsf-agent.jar=consumer","-jar","/consumer.jar"]