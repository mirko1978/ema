Weblogic installation & configuration
=====================================

This guide is about how configure Weblogic 12c (12.1.2) on Windows environment in EMA premises.

# 1. Installation

Oracle Weblogic [website](http://www.oracle.com/technetwork/middleware/weblogic/downloads/wls-main-097127.html)

*    Download the version Generic (880 MB). The file is `wls121200.jar`
*    Weblogic installation

>*    Locate the virtual machine that you would use to use with Weblogic. Make sure that is in the path with:
>>`echo %PATH%`  
>>`echo %JAVA_HOME%`  
>> In this tutorial we are using Java SDK 7

>*    Open a cmd as administrator in the windows box  
>*    Go where you downloaded the jar with the usual `CD` command. Please pay attention to **not have white spaces in the path**
>*    Install with the command 
>>`java -jar wls121200.jar`  

>*    The agency standard path for the installation is `C:\devtools\weblogic\12.1.2`. This path is used as reference in the tutorial.

*    Install all the components, including the examples (they can be useful as reference).
*    In this tutorial the defualt user is `weblogic` and the passowrd is `weblogic1`
*    Change the permissions property for the folder `C:\devtools\weblogic\12.1.2` in order to have full control from the local user.

# 2. Domain configuration

*    Open a cmd and go `C:\devtools\weblogic\12.1.2\wlserver\common\bin`
*    Run the configuration command with
>>`config.cmd`

*   Check in the templates _All templates_
*   Do not configure as a cluster
*   The domain name used in this tutorial is *base_domain*
*   Go to the domain folder `C:\devtools\weblogic\12.1.2\user_projects\domains\base_domain` edit the file `startWebLogic.cmd`

> Add in the line 2 the follow in order to delete environment variable CLASSPATH. Weblogic cannot handle environment variable with path with white spaces inside.

>> `SET CLASSPATH=`

> Exit and save the file

*    Launch weblogic server. Can be done executing `startWebLogic.cmd` or via Eclipse. 

# 3. Server creation

This tutorial is using Weblogic as JPA. JMS, JTA provider. In order to do that it is necessary to configure a new server. The assumption is that the weblogic server is running. You can start it through Eclipse or via script.

*    Access to [http://localhost:7001/console/](http://localhost:7001/console/) with user `weblogic` and password `weblogic1`
*    In the left box **Domain Structure** expand *Environment* and then click on *Server*. The right part of the page is showing **Summary of Servers** the server configurations.
*    Click on the *New* button. A new page **Create a New Server** appears.
*    Choose a server name like `Server-0` and a server port like `7002`. Then click on *Finish*
*    Launch `C:\devtools\weblogic\12.1.2\user_projects\domains\base_domain\bin\startNodeManager.cmd` in order to manage the new created server
*    Go to the console and on **Summary of Servers** click on *Control* tab. Select the server `Server-0` and click the *Start* button.

# 4. Creating JMS queue

## 4.1 Introduction and Definitions
A JMS queue in Weblogic Server is associated with a number of additional resources:

### 4.1.1 JMS Server

A JMS server acts as a management container for resources within JMS modules. Some of its responsibilities include the maintenance of persistence and state of messages and subscribers. A JMS server is required in order to create a JMS module.

### 4.1.2 JMS Module

A JMS module is a definition which contains JMS resources such as queues and topics. A JMS module is required in order to create a JMS queue.

### 4.1.3 Subdeployment

JMS modules are targeted to one or more WLS instances or a cluster. Resources within a JMS module, such as queues and topics are also targeted to a JMS server or WLS server instances. A subdeployment is a grouping of targets. It is also known as advanced targeting.

### 4.1.4 Connection Factory

A connection factory is a resource that enables JMS clients to create connections to JMS destinations.

### 4.1.5 JMS Queue

A JMS queue (as opposed to a JMS topic) is a point-to-point destination type. A message is written to a specific queue or received from a specific queue

## 4.2 Configuration Steps

The following steps are done in the WebLogic Server Console, beginning with the left-hand navigation menu.  
Access to [http://localhost:7001/console/](http://localhost:7001/console/) with user `weblogic` and password `weblogic1`

### 4.2.1 Create a JMS Server

*    In the left box **Domain Structure** expand *Services* and then *Messaging* then click on *JMS Servers*. The right part of the page is showing **Summary of JMS Servers**.
*    Click on *New* button. A new page **Create a New JMS Server** appears
*    Go through the creation wizard with the follow configuration:

>> Name: JMSServer-0  
>> Persistent Store: (none)  
>> Target: Server-0  (or choose an available server)

> The JMS server should now be visible in the list with Health OK.

### 4.2.3 Create a JMS Module

*    In the left box **Domain Structure** expand *Services* and then *Messaging* then click on *JMS Modules*. The right part of the page is showing **Summary of JMS Modules**.
*    Click on *New* button. A new page **Create JMS System Module** appears
*    Go through the creation wizard with the follow configuration:

>> Name: JMSModule-0   
>> Leave the other options empty  
>> Targets: Server-0  (or choose the same one as the JMS server)
  
*    Press *Next*
  
>> Leave “Would you like to add resources to this JMS system module” unchecked and  press Finish .

### 4.2.4 Create a SubDeployment

A subdeployment is not necessary for the JMS queue to work, but it allows you to easily target subcomponents of the JMS module to a single target or group of targets. We will use the subdeployment in this example to target the following connection factory and JMS queue to the JMS server we created earlier.

*    In the left box **Domain Structure** expand *Services* and then *Messaging* then click on *JMS Modules*. The right part of the page is showing **Summary of JMS Modules**.
*    Select `JMSModule-0`
*    Select the **Subdeployments** tab and New

>> Subdeployment Name: SdQueue-0
  
*    Press Next
*    Here you can select the target(s) for the subdeployment. You can choose either Servers (i.e. WebLogic managed servers, such as the soa_server1) or JMS Servers such as the JMS Server created earlier. As the purpose of our subdeployment in this example is to target a specific JMS server, we will choose the JMS Server option.   
*    Select the 'Server-0' created earlier  
*    Press Finish

### 4.2.5 Create a Connection Factory

*    In the left box **Domain Structure** expand *Services* and then *Messaging* then click on *JMS Modules*. The right part of the page is showing **Summary of JMS Modules**.
*    Select `JMSModule-0`
*    Press the *New* button.
*    Select *Connection Factory*  and *Next* button.

>> Name: ConnectionFactory-0   
>> JNDI Name: jms/cf0  
>> Leave the other values at default

*    On the *Targets* page, select the *Advanced Targeting*  button and select *SdQueue-0*
*    Press *Finish*

The connection factory should be listed on the following page with SdQueue-0 and Server-0 as the target.

### 4.2.6 Create a JMS Queue

*    In the left box **Domain Structure** expand *Services* and then *Messaging* then click on *JMS Modules*. The right part of the page is showing **Summary of JMS Modules**.
*    Select `JMSModule-0`
*    Press the *New* button.
*    Select *Queue* and *Next* button

>> Name: Queue-0  
>> JNDI Name: jms/queue0  
>> Template: None  

*    Press Next
  
>> Subdeployments: SdQueue-0
  
*    Press *Finish*

# 5. Creating a Data Source

*    Access to [http://localhost:7001/console/](http://localhost:7001/console/) with user `weblogic` and password `weblogic1`
*    In the left box **Domain Structure** expand *Services* and then click on *Data soruce*. The right part of the page is showing **Summary of JDBC Data Sources**.
*    Click on *New* button then select "New Generic datasource*

>> Name: EV7 Dev    
>> JNDI Name: jdbc/ev7  
>> Database type: Oracle

*    Press Next

>> Database Driver: Oracle's driver (Thin XA) for Instance connection; Version:9.0.1 and later

*    Press Next
*    Press Next

>> Database Name: YourDatabaseName  
>> Host Name: YourHostName  
>> Port: YourPort  
>> Database User Name: YourUserName  
>> Password: YourPassword  
>> Confirm Password: YourPasswordAgain

*    Press Next
*    Press *Test Configuration* and if everything is fine press *Finish*


