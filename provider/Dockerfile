#FROM harbor-poc666.netease.com/hd-hdpro/openjdk:8-jdk-alpine
FROM openjdk:8-jdk-alpine

MAINTAINER hedu

ADD http://console-poc666.netease.com/download/nsf/nsf-agent-v2.6.6-ae06cc43-20200417-150504.jar /nsf-agent.jar
ADD ./target/provider-0.0.1-SNAPSHOT /provider101.jar
ADD qzlib/provider101.yml /provider101.ym

ENTRYPOINT ["java","-Dnsf.log.level=debug","-javaagent:/nsf-agent.jar=provider101","-jar","/provider101.jar"]