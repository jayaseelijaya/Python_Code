FROM ubuntu:16.04
#FROM python:3.7.5-slim
#ENV no_proxy=127.0.0.1,localhost,0.0.0.0
ENV http_proxy=http://185.46.212.98:9480
ENV https_proxy=https://185.46.212.98:9480

#RUN python --version

RUN apt-get update && apt-get install -y \
        apt-transport-https \
        ca-certificates \
        curl \
        gnupg \
        #python \
        python-requests \
        python-pip \
        lsb-release \
        build-essential  \
        openssh-server \
        git \
        sudo \
        openjdk-8-jdk \
        maven\
        awscli

RUN aws --version

RUN apt install software-properties-common -y
RUN add-apt-repository ppa:deadsnakes/ppa
RUN apt-get update
RUN apt-get install python3.7 -y
RUN python3.7 --version
RUN apt-get install python3-pip
RUN pip3 --version

RUN apt-get install python3-pip -y
RUN pip3 --version
RUN pip3 install pydicom
#RUN pip3 install requests_ntlm
RUN apt-get update && pip3 install PyYAML==5.4.1 \
	pip3 install jinja2

RUN mkdir cf-cli
RUN cd cf-cli
RUN curl -L "https://cli.run.pivotal.io/stable?release=linux64-binary&source=github" | tar -zx
RUN ./cf -v

RUN curl -fsSL get.docker.com | CHANNEL=stable sh

RUN chmod -R 755 /usr/share/maven/conf
RUN mkdir /var/run/sshd
# User settings
RUN echo "root:root" | chpasswd
RUN useradd jenkins -m -d /home/jenkins
RUN echo "jenkins:jenkins" | chpasswd
RUN cd /usr/share/maven/conf
RUN chown -R root:jenkins /home/jenkins
RUN chmod -R 777 /usr/share/maven/conf

EXPOSE 22
CMD ["/usr/sbin/sshd", "-D"]