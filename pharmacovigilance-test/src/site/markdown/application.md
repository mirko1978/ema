# 0. Install Maven 

Download software and install from here. Version 3.2.1
URL: http://maven.apache.org/download.cgi

# 1. Maven configuration

[Pom.xml](../../../pom.xml) contains a set of exclusion in order to use the right dependencies inside Weblogic 12c.  
The dependency conflict are visible to the weblogic CAT application.   
One instance of CAT for server is running for example: [CAT main server](http://localhost:7001/wls-cat/) or [CAT for Server-0](http://localhost:7002/wls-cat/)  

## 1.1 External libraries added manually

### 1.1.1 Pitchfork

URL: [https://oss.oracle.com/projects/pitchfork/](https://oss.oracle.com/projects/pitchfork/)    
Manually download the file `pitchfork-1.0-m11.jar`

	mvn install:install-file -Dfile=pitchfork-1.0-m11.jar -DgroupId=com.oracle -DartifactId=pitchfork -Dversion=1.0-m11 -Dpackaging=jar

### 1.1.2 Weblogic libraries in your dev enviroment (scope: provided)

Local path: `C:\devtools\weblogic\12.1.2\wlserver\server\lib\wlthint3client.jar`  

	mvn install:install-file -Dfile=C:\devtools\weblogic\12.1.2\wlserver\server\lib\wlthint3client.jar -DgroupId=com.oracle -DartifactId=wlthint3client -Dversion=12.1.2 -Dpackaging=jar

### 1.1.3 Eclipse link

Weblogic 12c is using toplink as default technology for JTA.   
The version included in the server is using an old version of Eclipse Link, in some situation can be useful to use the latest version in order to have better error messages.  
In order to use it properly it is necessary to add the follow line to [weblogic.xml](../../main/webapp/WEB-INF/weblogic.xml) file:

	<wls:prefer-application-packages>
		<wls:package-name>org.eclipse.persistence.*</wls:package-name>` 
	</wls:prefer-application-packages>
Add the follow dependecy to Maven

	<dependency>
		<groupId>org.eclipse.persistence</groupId>
		<artifactId>eclipselink</artifactId>
		<version>2.5.1</version>
	</dependency>`

# 2. Camel configuration

In this tutorial Camel is using Spring but the routes are done via Java DSL.  
The [web.xml](../../main/webapp/WEB-INF/web.xml) loads the Spring context that loads all the Camel routes.  
When a new message appear in the JMS queue the routes are triggered.  
In short terms the application is event-driven.  
The main class that contains all the routes is `MyRouteBuilder.class`.  
Please, look the implementation of `MyRouteBuilder.java` in order to understand the routing.

# 3. Spring configuration

Spring is used as glue between the different components: Camel, Drools, JTA, JMS.  
The configuration is really straightforward and commented, the main file is [camel-context.xml](../../main/webapp/WEB-INF/spring/camel-context.xml)  
The [weblogic.xml](../../main/webapp/WEB-INF/web.xml) files is used in order to avoid libraries conflicts.

# 4. JTA configuration

JTA and datasources are configured into weblogic.  
The references between weblogic server and the application code is done by [persistence.xml](../../main/resources/META-INF/persistence.xml)

# 5. Drools

Drools is configured at minimum in order to run the Hello World example.  
The business rules configured is printing a text everytime is called.  
Drools configuration file is [drools-context.xml](../../main/webapp/WEB-INF/spring/drools-context.xml).   
The rule configured is [empty.drl](../../main/resources/drls/empty.drl).
