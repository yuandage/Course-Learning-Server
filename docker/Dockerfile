

#FROM java:8
FROM registry.cn-chengdu.aliyuncs.com/yh-dcoker/yh:8_server-jre_unlimited
MAINTAINER yuanhong <1027928543@qq.com>
VOLUME /file
ARG profile=prod
ENV SPRING_PROFILES_ACTIVE ${profile}
# 将jar包添加到容器中并更名为 CourseLearning.jar
ADD course-learning-server.jar CourseLearning.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","CourseLearning.jar"]
