
# DockerFile ##############################################################################################

#FROM ，表示使用 Jdk8 环境 为基础镜像，如果镜像不是本地的会从 DockerHub 进行下载
FROM openjdk:8-jdk-alpine
#VOLUME 指向了一个/tmp的目录，由于 Spring Boot 使用内置的Tomcat容器，Tomcat 默认使用/tmp作为工作目录。这个命令的效果是：在宿主机的/var/lib/docker目录下创建一个临时文件并把它链接到容器中的/tmp目录
VOLUME /tmp
#拷贝文件并且重命名  先用maven package出 jar包 然后 指定该jar包名称  chapter9-6-1-0.0.1-SNAPSHOT.jar
ADD chapter9-6-1-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
#EXPOSE 8082

# ENV为设置环境变量
ENV JAVA_OPTS=""
#为了缩短 Tomcat 的启动时间，添加java.security.egd的系统属性指向/dev/urandom作为 ENTRYPOINT  ENTRYPOINT为启动时运行的命令
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

# DockerFile ##############################################################################################
# docker run --name hello -p 8961:8961  1b782a155a35

# docker run --name hello -d  -p 8961:8961  1b782a155a35
# docker run --name hello -d    8fd5569cf177
# docker run --name hello   -p 8961:8961  8fd5569cf177docker run --name hello   -p 8961:8961  8fd5569cf177