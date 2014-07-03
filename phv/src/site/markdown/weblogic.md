Weblogic installation & configuration
=====================================

This tutorial contains information about how to install weblogic, configure a simple queue, configure a cluster and the different flavours on how configure JMS in a cluster.

# 1. Installation
This guide is about how configure Weblogic 12c (12.1.2) on Windows environment in EMA premises.

Oracle Weblogic [website](http://www.oracle.com/technetwork/middleware/weblogic/downloads/wls-main-097127.html)

*    Download the version Generic (880 MB). The file is `wls121200.jar`
*	Locate the virtual machine that you would use to use with Weblogic. Make sure that is in the path with:

		echo %PATH%  
		echo %JAVA_HOME%  
In this tutorial we are using Java SDK 7

*	Open a cmd as **administrator** in the windows box  
*	Go where you downloaded the jar with the usual `CD` command. Please pay attention to **not have white spaces in the path**
*	Install with the command 

		%JAVA_HOME%\bin\java -jar wls121200.jar

*	The agency standard path for the installation is `C:\devtools\weblogic\12.1.2`. This path is used as reference in the tutorial.

*    Install all the components, including the examples (they can be useful as reference).
*    select "I agree to remain uninformed of critical security issues in my configuration" if a prompt appears.
*    In this tutorial the defualt user is `weblogic` and the passowrd is `weblogic1`
*    Change the permissions property for the folder `C:\devtools\weblogic\12.1.2` in order to have full control from the local user.

# 2. Domain configuration

This section is a tuturial on how configure a domain

*    Open a cmd and go `C:\devtools\weblogic\12.1.2\wlserver\common\bin`
*    Run the configuration command with
*    
		config.cmd

*   Check in the templates _All templates_
*   Do not check any boxes in the Advanced configurations
*   Do not check Start Admin Server
*   The domain name used in this tutorial is *base_domain*
*   Go to the domain folder `C:\devtools\weblogic\12.1.2\user_projects\domains\base_domain` edit the file `startWebLogic.cmd`

At line 2 add the following in order to delete environment variable CLASSPATH. Weblogic cannot handle environment variable with path with white spaces inside.
In addition there is a clash of variable in the default EMA environment for the variable MW_HOME

		SET CLASSPATH=
		SET MW_HOME=

Exit and save the file

*    Launch weblogic server. Can be done executing `startWebLogic.cmd` or via Eclipse. 

# 3. Server creation

This section explain how to create two servers

*    Access to [http://localhost:7001/console/](http://localhost:7001/console/) with user `weblogic` and password `weblogic1`. On first access it will take a while for admin server to deploy and run.  However the browser keeps refreshing to check the availability.
*    In the left box **Domain Structure** expand **Environment** and then click on **Server**. The right part of the page is showing **Summary of Servers** the server configurations.
*    Click on the *New* button. A new page **Create a New Server** appears.
*    Choose a server name like `Server-0` and a server port like `7002`. 
*    Do not configure as a cluster, leave as stand-alone
*    Please note that can be necessary to create also a new machine. In this case just follow the default configuration and name.
*    Then click on *Finish*
*    Replicate the step and create `Server-1`
*    Launch `C:\devtools\weblogic\12.1.2\user_projects\domains\base_domain\bin\startNodeManager.cmd` in order to manage the new created server
*    Go to the console and on **Summary of Servers** click on *Control* tab. Select the server `Server-0` and click the *Start* button.

# 4. JMS queue creation and definition

This section is intended as tutorial on how create a JMS queue

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

*    In the left box **Domain Structure** expand **Services** and then **Messaging** then click on **JMS Servers**. The right part of the page is showing **Summary of JMS Servers**.
*    Click on *New* button. A new page **Create a New JMS Server** appears
*    Go through the creation wizard with the follow configuration:

		Name: JMSServer-0  
		Persistent Store: (none)  
		Target: Server-0  (or choose an available server)

The JMS server should now be visible in the list with Health OK.

### 4.2.3 Create a JMS Module

*    In the left box **Domain Structure** expand **Services** and then **Messaging** then click on **JMS Modules**. The right part of the page is showing **Summary of JMS Modules**.
*    Click on *New* button. A new page **Create JMS System Module** appears
*    Go through the creation wizard with the follow configuration:

		Name: JMSModule-0   
		Leave the other options empty  
		Targets: Server-0  (or choose the same one as the JMS server)
  
*    Press *Next*
  
Leave “Would you like to add resources to this JMS system module” unchecked and  press Finish .

### 4.2.4 Create a SubDeployment

A subdeployment is not necessary for the JMS queue to work, but it allows you to easily target subcomponents of the JMS module to a single target or group of targets. We will use the subdeployment in this example to target the following connection factory and JMS queue to the JMS server we created earlier.

*    In the left box **Domain Structure** expand **Services** and then **Messaging** then click on **JMS Modules**. The right part of the page is showing **Summary of JMS Modules**.
*    Select `JMSModule-0`
*    Select the **Subdeployments** tab and New

		Subdeployment Name: SdQueue-0
  
*    Press Next
*    Here you can select the target(s) for the subdeployment. You can choose either Servers (i.e. WebLogic managed servers, such as the soa_server1) or JMS Servers such as the JMS Server created earlier. As the purpose of our subdeployment in this example is to target a specific JMS server, we will choose the JMS Server option.   
*    Select the `JMSServer-0` created earlier  
*    Press Finish

### 4.2.5 Create a Connection Factory

*    In the left box **Domain Structure** expand **Services** and then **Messaging** then click on **JMS Modules**. The right part of the page is showing **Summary of JMS Modules**.
*    Select (click) `JMSModule-0`
*    Press the *New* button.
*    Select *Connection Factory*  and *Next* button.

		Name: ConnectionFactory-0   
		JNDI Name: jms/cf0  
		Leave the other values at default

*    On the *Targets* page, select the *Advanced Targeting*  button and select *SdQueue-0*
*    Press *Finish*

The connection factory should be listed on the following page with SdQueue-0 and Server-0 as the target.

### 4.2.6 Create a JMS Queue

*    In the left box **Domain Structure** expand **Services** and then **Messaging** then click on **JMS Modules**. The right part of the page is showing **Summary of JMS Modules**.
*    Select (click) `JMSModule-0`
*    Press the *New* button.
*    Select *Queue* and *Next* button

		Name: Queue-0  
		JNDI Name: jms/queue0  
		Template: None  

*    Press Next
  
		Subdeployments: SdQueue-0
  
*    Press *Finish*

# 5. Creating a Data Source

This section is a tutorial on how create a data source

*    Access to [http://localhost:7001/console/](http://localhost:7001/console/) with user `weblogic` and password `weblogic1`
*    In the left box **Domain Structure** expand **Services** and then click on **Data soruce**. The right part of the page is showing **Summary of JDBC Data Sources**.
*    Click on *New* button then select "New Generic datasource*

		Name: EV7 Dev    
		JNDI Name: jdbc/ev7  
		Database type: Oracle

*    Press Next

		Database Driver: Oracle's driver (Thin XA) for Instance connection; Version:9.0.1 and later

*    Press Next
*    Press Next

		Database Name: YourDatabaseName  
		Host Name: YourHostName  
		Port: YourPort  
		Database User Name: YourUserName  
		Password: YourPassword  
		Confirm Password: YourPasswordAgain

*    Press Next
*    Press *Test Configuration* and if everything is fine press *Finish*

# 6. Cluster creation

This section explain how to create and configure a cluster in order to manage JMS Cluster and Service Migration.  
Please note that JMS Cluster option is discarded (see section 6.2.1), however contains information on how handle data store, JMS server and JMS module

*   Access to [http://localhost:7001/console/](http://localhost:7001/console/) with user `weblogic` and password `weblogic1`. On first access it will take a while for admin server to deploy and run.  However the browser keeps refreshing to check the availability.
*   Shutdown `Server-0` and `Server1` if they are running.
*   In the left box **Domain Structure** expand **Environment** and then click on **Clusters**. The right part of the page is showing **Summary of Clusters** the server configurations.
*   Click on the *New* button then *New Cluster*. A new page **Create a New Cluster** appears.
*   Choose a cluster name like `Cluster-0`
*   Then click on *OK*
*   On **Summary of Clusters** clik on `Cluster-0`
*   **Configuration** -> **General** fill *Cluster Address* with `localhost`
*   **Configuration** -> **JTA** select *Enable Cluster-Wide Recovery* in order to enable the JTA transaction to be managed at cluster level. With this configuration in case of failure on one node the transactions are moved in another cluster node.
*   **Configuration** -> **Servers** go to the bottom of the page and click *Add* on the table. 
*   Select `Server-0` and press next.
*	Repeat the process for `Server-1`
*	**Configuration** -> **Migration** on *Candidate Machines For Migratable Servers* select `Machine-0` on *Available* then move on *chosen*. 
*	**Configuration** -> **Migration** on *Migration Basis* select `JDBC`
*	**Configuration** -> **Migration** on *Datasource for Automatic Migration* click on *New*
	*	Create a new datasoruce (see section *Creating a Data Source* below)
	*	The datasource has to be **without XA** transaction. The flag `Supports Global Transactions` has to be unchecked.
	*	Set a name like `Phv_JDBC_datastore`
	*	Create inside the database a table as defined in the DDL `C:\devtools\weblogic\12.1.2\wlserver\server\db\oracle\920\leasing.ddl`	
*	**Configuration** -> **Migration** on *Auto Migration Table Name* put the value `ACTIVE`. Is the name of the table just created
*	**Configuration** -> **Migration** select *Member Death Detector Enabled*

## 6.1 Define the Migratable Targets

*	In the left box **Domain Structure** expand **Environment** expand **Clusters** and then click on **Migratable Targets**. The right part of the page is showing **Summary of Migratable Targets** the server configurations.
*	Click on `Server-0`
*	**Configuration** -> **Migration** on *Service Migration Policy* choose `Auto-migrate failure recovery services`.
*	**Configuration** -> **Migration** on *Constrained Candidate Servers* select `Server-0` and `Server-1` on *Available* then move on *chosen*
*   In the left box **Domain Structure** expand *Environment* expand *Clusters* and then click on *Migratable Targets*.

## 6.2 JMS in HA and load balancing

### 6.2.1 Clustered JMS

Weblogic 12.1.2 offers the new feature called **Clustered JMS**. There are too many limitation as showed in the [oracle documentation](http://docs.oracle.com/middleware/1212/wls/JMSAD/dynamic_messaging.htm#JMSAD684).  
In summary the pros are:

*	really easy to configure and maintain
*	if the system fails the producer doesn't see the effect

The cons are: 

*	there is no HA, the messages stored in the crashed servers are not migrated in another node in the cluster. However, the messages are not looses because the persistent store and at first restart are available again
*	The messages are not shared between the cluster node. Each node knows only the messages sent to him

#### 6.2.1.1 Datastore

*	In the left box **Domain Structure** expand **Services** click on **Persistence Store**
*	Click on *New* then on *Create JDBC Store*

		Name: Phv_JDBCStore
		Target: Cluster-0
		Datasource: Phv_JDBC_datastore (non XA datasource)
		Prefix Name: PHV_WS_

Remember that the associate datasource has to have the flag `Supports Global Transactions` unchecked.

#### 6.2.1.2 JMS Server

*	Create a new JMS Server (see section *Creating JMS Server*)
		
		Name: Phv_JMSServer
		Persistent Store: Phv_JDBCStore
		
*	Press *Next*

		Target: Cluster-0
		
*	Press *Finish*

#### 6.2.1.3 JMS Module

*	Create a new JMS Module (see section *Create JMS Server*) called `Phv_SystemModule`
*	Create a new Subdeploymnet (see section *Create a SubDeployment*) called `Phv_Subdeployment`
*	Set `Phv_Subdeployment` target to `Phv_JMSServer`
*	Create a new connection factory (see section *Create a Connection Factory*) called `Phv_ConnectionFactory`
*	Set `Phv_ConnectionFactory` subdeployment to `Phv_Subdeployment`
*	Create a new Uniform Distributed Queue, the wizard is similar to the one for the queue. Select on the first wizard page `Distributed Queue`
	*	Uniform Distribuited Queue is a queue that is physical realized by more than one server. Every new connection to the queue is balanced between the servers in the cluster. The distribuite queue can define which algorithm use for balancing the load (round-robin or weigh). However, the messages sent to one server are not shared with the other server. Then a consumer connected to `Server-0` can see only the messages produced on `Server-0`
*	       
		
		Name: Phv_UDQ
		Subdeployment: Phv_Subdeployment
		
### 6.2.2 JMS Service Migration

Weblogic offers the possibility to migrate a set of services from one node to another in case of crash, more information can be found on the [oracle documentation](http://docs.oracle.com/middleware/1212/wls/CLUST/service_migration.htm). The service migration can be applied also to the JTA XA services.  
In summary the pros are:

*	In case of failure the messages produced in one node are moved in another in the cluster
*	If configured with Distribuited Queue the load balancing is available with the distribuited queue limitations

The cons are: 

*	The messages are not shared between the cluster node. Each node knows only the messages sent to him
*	In case of node failure and restart the admin has to migrate the services in the original node. 

**How it works**

Each node in the cluster has to have his own JMS Server. This mean that also the datastore has to be replicated for each node.  
The JMS Module is going to define a subdeployment that is targeting all the JMS Servers defined.  
The connection factory and distribuite queue are targeting the subdeployment.  
The services that are moved from one node to another are the JMS Server and the datastore.

The migration of the services is completely transparent for the producer but the consumer get a JMSException when the server dies.  
In addition in order to read the messages in the server crashed it is necessary to create two consumers or create a new connection for every message read because the load balancing.

#### 6.2.2.1 Manual target migration

This procedure has to be called every time a node crash and is restored.

*	In the left box **Domain Structure** expand **Environment** expand **Clusters** and then click on **Migratable Targets**. The right part of the page is showing **Summary of Migratable Targets** the server configurations.
*	Click on the server that is been restarted from *Migratable Targets (Filtered - More Columns Exist)*
*	Click on the tab *Control*
*	Select the server checkbox and then click on *Migrate*
*	Check if the destination server is the right one and then press *Ok*
*	In the table you can see that the *Name* is like `Server-0 (migratable)` and *Current Hosting Server* is like `Server-0`

#### 6.2.2.2 Datastore


*	In the left box **Domain Structure** expand **Services** click on **Persistence Store**
*   Remember that the associate datasource has to have the flag `Supports Global Transactions` unchecked.
*	Click on *New* then on *Create JDBC Store*

		Name: Phv_Store_s0
		Target: Server-0 (migratable)
		Datasource: Phv_JDBC_datastore (non XA datasource)
		Prefix Name: WS_S0_

*	Create a new datastore for the server 1

		Name: Phv_Store_s1
		Target: Server-1 (migratable)
		Datasource: Phv_JDBC_datastore (non XA datasource)
		Prefix Name: WS_S1_

#### 6.2.2.2 JMS Server

*	Create a new JMS Server for the `Server-0` (see section *Creating JMS Server*)
		
		Name: Phv_JS_s0
		Persistent Store: Phv_Store_s0
		
*	Press *Next*

		Target: Server-0 (migratable)
		
*	Press *Finish*
*	Create a new JMS Server for the `Server-1` (see section *Creating JMS Server*)
		
		Name: Phv_JS_s1
		Persistent Store: Phv_Store_s1
		
*	Press *Next*

		Target: Server-1 (migratable)
		
*	Press *Finish*

#### 6.2.1.3 JMS Module

*	Create a new JMS Module (see section *Create JMS Server*) called `Phv_SM_UD`
*	Create a new Subdeploymnet (see section *Create a SubDeployment*) called `Phv_SD_ud`
*	Set `Phv_SD_ud` target to `Phv_JS_s0` and `Phv_JS_s1`
*	Create a new connection factory (see section *Create a Connection Factory*) called `Phv_cf`
*	Set `Phv_cf` subdeployment to `Phv_SD_ud`
*	Create a new Uniform Distributed Queue, the wizard is similar to the one for the queue. Select on the first wizard page `Distributed Queue`
		
		Name: phv_udd
		Subdeployment: Phv_SD_ud
		
## 6.3 JTA in HA

*   Access to [http://localhost:7001/console/](http://localhost:7001/console/) with user `weblogic` and password `weblogic1`. On first access it will take a while for admin server to deploy and run.  However the browser keeps refreshing to check the availability.
*   In the left box **Domain Structure** expand **Environment** and then click on **Clusters**. The right part of the page is showing **Summary of Clusters** the server configurations.
*   Click on `Cluster-0`
*   **Configuration** -> **JTA** then select *Enable Cluster-Wide Recovery*