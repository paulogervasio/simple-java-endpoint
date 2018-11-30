from openjdk:8

# TODO - create a custom maven install
RUN echo "deb http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main" >> /etc/apt/sources.list
RUN echo "deb-src http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main" >> /etc/apt/sources.list
RUN apt-get update
RUN apt-get install -y maven
#

RUN wget https://github.com/paulogervasio/simple-java-endpoint/archive/master.zip
RUN unzip master.zip
WORKDIR simple-java-endpoint-master

RUN mvn clean install
WORKDIR target

CMD ["/usr/bin/java", "-jar", "simple-java-endpoint-0.1.0.jar", ";", "sleep 5"]


EXPOSE 8081


