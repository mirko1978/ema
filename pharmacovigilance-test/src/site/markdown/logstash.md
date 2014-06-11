Logstash installation & configuration
=====================================

From Logstash website:  
"logstash is a tool for managing events and logs. You can use it to collect logs, parse them, and store them for later use 
(like, for searching). Speaking of searching, logstash comes with a web interface for searching and drilling into all of 
your logs."

The Logstash website is [Logstash](http://logstash.net/), however is it also interesting to read the site of the company
that develop the full elk stack [Elasticsearch](http://www.elasticsearch.org/)

**Logstash** is the agent that manages the collections of logs between different sources.

**Elasticsearch** is the search engine and store that allow fast search inside the logs. It provides a webservices for running 
the searches and display the results.

**Kibana** is the web user interfaces that manage elastisearch in a use friendly way.

Other tools are provided by Elasticsearch website but this tutorial is covering only the three mentioned above.

# 1. Installation

*    Go to Elasticsearch webiste in order to download the latest version of logstash in zip format. The version used in this tutorial is 1.4.1
*    Unzip it in `C:\devtools\logstash` in order to have the folder `C:\devtools\logstash\logstash-1.4.1`
*    Create the `logstash.conf` file in  `C:\devtools\logstash\logstash-1.4.1\bin`. The content should be:

		input {
	
			stdin { 
				# A type is a label applied to an event. It is used later with filters
				# to restrict what filters are run against each event.
	
				type => "human"
			}
		
			tcp {
				# TCP server listeing on port 6000 that expect JSON messages divided by a new line character
	    
				port => 6000		
				type => "app"		
				codec => json_lines
			}
		}
	
		# This filter is used in case the message contains an inner json
	
		# filter { 
		#	json { 
		#		source => "message"
		#		target => "Phv"
		#		} 
		# } 
	
		output {
		# Print each event to stdout.
	
			stdout {
				# Enabling 'rubydebug' codec on the stdout output will make logstash
				# pretty-print the entire event as something similar to a JSON representation.
	
				codec => rubydebug
			}
      
		# You can have multiple outputs. All events generally to all outputs.
		# Output events to elasticsearch
	
			elasticsearch {
				# Setting 'embedded' will run  a real elasticsearch server inside logstash.
				# This option below saves you from having to run a separate process just
				# for ElasticSearch, so you can get started quicker!
	
				embedded => true
			}
		}

# 2. Run Logstash, Elastisearch, Kibana
The logstash configuration file above is including the embedded server of elasticsearch in order to run quickly the stack. No additional configuration are needed for elasticsearch.

*    Go the folder `C:\devtools\logstash\logstash-1.4.1\bin` and then run:

		logstash.bat agent -f logstash.conf web
This start logstash (agent) with the Kibana Ui (web) and read the configuration from the file created before.
Can be useful to run the agent in debug mode with the follow:

		logstash.bat agent --debug -f logstash.conf web

*    Access to the Kibana ui going to [http://localhost:9292/](http://localhost:9292/) 

# 3. Configure the application in order to use logstash
Logstash now is running and it is waiting new logs via TCP on the port 6000.  
The protocol expected is JSON.  

## 3.1 Logback (SLF4J) TCP issue
Logback can be used to send logs via TCP with the class `ch.qos.logback.classic.net.SocketAppender` but the messages sent are the Java serialization of the implementation of `ch.qos.logback.classic.spi.ILoggingEvent`.  
The serialization is done without calling any encoder. That's make impossible to use the default class!  

In order to solve the transport issue a new appender class has been done [eu.europa.ema.log.LogStashSocketAppender](../../main/java/eu/europa/ema/log/LogStashSocketAppender.java).  
 This class is not for production use but enough stable for the tutorial. A refactor and some test should be done before using 
 it in production. [LogStashSocketAppender](../../main/java/eu/europa/ema/log/LogStashSocketAppender.java) is a merge from `SocketAppender` class tree, for more details please look the class source code.

## 3.2 Sending JSON as log messages
Slf4j as default send string messages, not JSON. In order to create the proper logstash JSON with all the necessary java fields 
the library [logstash-logback-encoder](https://github.com/logstash/logstash-logback-encoder). It is doing a good job for the 
translation, however has been written for the use with file system or syslog.   
The missing piece is an encoder that can be configurable for:

*    Encoding charset. The TCP protocol doesn't define the encoding charset then server and client have to have an agreement about. In the tutorial it is used the default (UTF-8)
*    Define the character for the new line. It is a well known problem, Windows uses 2 character for the new line, unix just one.

Again the solution is implementing a proper encoder that utilizes the logstash-logback-encoder library for encoding the messages from log to JSON. 
The encoder is [eu.europa.ema.log.LogStashEncoder](../../main/java/eu/europa/ema/log/LogStashEncoder.java).  
This class is not for production use but enough stable for the tutorial. A refactor and some test should be done before using it in production.  
Please, look at the class for any details.
