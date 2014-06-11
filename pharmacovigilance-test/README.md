# Pharmacovigilance tutorial

In this small tutorial is showed how to create a Camel application that uses the follow technologies:
- J2EE 6 application server (Weblogic 12c)
- JMS queue
- Camel
- Spring framework
- Drools
- Persistance layer done with JTA (XA), JPA fully managed by Weblogic 12c


## Table of contents

*    [Weblogic installation and configuration](src/site/markdown/weblogic.md)
*    [Application tutorial](src/site/markdown/application.md)
*    [LogStash tutorial](src/site/markdown/logstash.md)

## Build instructions

This project uses Maven then in order to produce the war:

    mvn package
    
In order to create the documentation

    mvn site
    