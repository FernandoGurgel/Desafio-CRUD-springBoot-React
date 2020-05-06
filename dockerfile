FROM openjdk:8-jre-alpine

ADD build/libs/*.war /ROOT.war

CMD /usr/bin/java -jar /ROOT.war