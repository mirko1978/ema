# How to test the HA in a weblogic cluster

To proper emulate a server crash it is necessary to kill the java virtual machine that runs the weblogic server to crash.  
In order to identify the right process I've used the *Process Explorer* utility on windows. This is can done looking the command line used to create the process.  
Every time a process crashes the node manager automatically tries to relaunch then it is necessary to kill two time.  
The second kills has to happen quickly after the first time because in that way nodemanager assume that the process is not restartable.

## Testing environment

Two classes has been created in order to produce messages and consume it.  
The classes can be found in the package `eu.europa.ema.phv.cluster` inside the test folder.   
`QueueReceive` Junit test that implements a synchronized consumer in order to handle easily eventually exceptions.  
In order to read from the two different servers, for each message read the current connection is closed and a new one is open.  
 `QueueSend` Junit test that implements a producer that sends a messages every predefined time.
