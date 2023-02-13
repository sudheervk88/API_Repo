FROM sudheerdocker/java11-3.6.3-testdep
COPY src home/ApiFrameWork/src
COPY index.html home/ApiFrameWork/index.html
COPY pom.xml home/ApiFrameWork/pom.xml
COPY testng.xml home/ApiFrameWork/testng.xml
WORKDIR home/ApiFrameWork
ENTRYPOINT mvn clean test
