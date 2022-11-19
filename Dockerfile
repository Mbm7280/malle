FROM openjdk:8-alpine3.9
  # 作者信息
MAINTAINER echo Docker malle "mbm1216@163.com"
  #修改镜像为东八区时间
COPY agent/ /opt/skyagent/
COPY malle.jar /app.jar

EXPOSE 8001
ENTRYPOINT ["java","-jar","/app.jar"]

ENTRYPOINT ["java","-Xmx512m","-javaagent:/opt/skyagent/skywalking-agent.jar","-Dskywalking.agent.service_name=malle","-Dskywalking.collector.backend_service=172.16.128.129:11800","-jar","/app.jar"]