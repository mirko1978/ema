# Eclipse configurations

## Code templates.

Open the eclipse preferences then go into

		Java -> Code Styles -> Code templates

Click on *Import* and select the [codetemplates.xml](codetemplates.xml) file.  
Please note that in `Comments -> Types` your name and email has to be put there.

## Formatter

Open the eclipse preferences then go into

		Java -> Code Styles -> Formatter

Click on *Import* and select [formatter.xml](formatter.xml) file.  
Please note that this version enable the tags:

*	`// @formatter:off` in order to disable the automatic format of the code for a code section
*	`// @formatter:on` in order to enable again the format of the code

This tags are really useful when you are handling the fluent interface and API on Java.
