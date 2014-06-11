# Pharmacovigilance

Pharmacovigilance "Poller & Parser" technology refresh in Java 7.


The technology stack used is:

*    J2EE 6 application server (Weblogic 12c)
*    JMS queue
*    Camel
*    Spring framework
*    Drools
*    Persistance layer done with JTA (XA), JPA fully managed by Weblogic 12c 

## Servers naming conventions

PHV[1][2]_{environment].domain  

Where:  
**[1]** can be:

* **A** in case of Application layer
* **D** in case of database server
* **W** in case of Web layer

**[2]** is the server number

**[environment]** is the environment like **DEV**, **TEST**

Example:

PHVA01-DEV	is a PHV related server number 01 in the Application layer in the DEV environment

## Package naming convention

The packaging start with `eu.europa.ema.phv` followed by the components name or by `common`.  
The `common` package contains the common library used between the different components (e.g. data persistence)

## Build instructions

This project uses Maven then in order to produce the war:

    mvn package
    
In order to create the documentation

    mvn site
    