
FROM openjdk:17-alpine
ENV LOCAL_APP_FILE kubeapp-0.0.1-SNAPSHOT.jar
ENV APP_DIR /home/app
ENV IMAGE_APP_FILE kubeapp.jar

EXPOSE 8080

WORKDIR ${APP_DIR}
COPY target/$LOCAL_APP_FILE $APP_DIR/$IMAGE_APP_FILE
ENTRYPOINT exec java -jar ${APP_DIR}/$IMAGE_APP_FILE $CONFIG_FILE

RUN apk update && apk upgrade && \
    apk add --no-cache curl