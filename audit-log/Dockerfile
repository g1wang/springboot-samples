# 基础镜像
FROM openjdk:17
# 复制主机jar包至镜像内，复制的目录需放置在 Dockerfile 文件同级目录下
ADD target/audit-log-0.0.2-SNAPSHOT.jar app1.jar
# 容器启动执行命令
#ENTRYPOINT ["java","-jar", "/app.jar" , "--spring.profiles.active=prod"]
ENTRYPOINT ["java","-jar", "/app1.jar"]
# 对外暴露的端口号
EXPOSE  8080