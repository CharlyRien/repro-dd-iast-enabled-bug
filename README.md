Command to start the spring boot web server containing the problem:

DD_IAST_ENABLED=true java -jar -javaagent:/link-to-the-dd-agent/dd-java-agent-1.30.1.jar /link-to-the-bootJar-file/repro-dd-iast-bug-1.0-SNAPSHOT.jar

After starting the server, an endpoint is accessible reproducing the bug when IAST is enabled. 

the endpoint is accessible locally via http://localhost:8080/bug