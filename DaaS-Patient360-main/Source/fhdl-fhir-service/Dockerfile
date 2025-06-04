FROM openjdk:11-jre-slim
ARG PROXY
ARG SECURE_PROXY
ARG JARVERSION
ENV http_proxy='http://umbrella.philips.com:80'
ENV https_proxy='http://umbrella.philips.com:443'

EXPOSE 8080

COPY /target/fhdl-fhir-service-${JARVERSION}.jar /target/

CMD java -jar /target/fhdl-fhir-service-*.jar
