package eu.europa.ema;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import eu.europa.ema.jpa.DatabaseJPAWriter;
import eu.europa.ema.springjdbc.DatabaseJdbcWriter;
/**
 * 
 * Camel route configuration
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @author  $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 10 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 10 Jun 2014 $
 */
@Component("MyRouteBuilder")
public class MyRouteBuilder extends SpringRouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // Shutdown timeout to 5 seconds (default 5 minutes)
        getContext().getShutdownStrategy().setTimeout(5);

        // Avoid to resent in the queue as loop
        // errorHandler(
        // deadLetterChannel("mock:dead")
        // .logStackTrace(true)
        // .disableRedelivery()
        // );
        // errorHandler(transactionErrorHandler()
        // .logStackTrace(true)
        // .disableRedelivery()
        // );

        // from("file:src/data?noop=true")
        from("jms:queue:jms/queue0?concurrentConsumers=20&asyncConsumer=true")
            .transacted()
            .log("Load ${header.CamelFileName}")
            .bean(XMLValidator.class).log("Valid message")
            .wireTap("direct:persistanceCopy")
            .wireTap("direct:backupcopy")
            .split()
                .tokenizeXML("safetyreport")
                // .parallelProcessing()
        .to("seda:safetyreports");

        from("direct:persistanceCopy")
            .transacted()
            .log("Message sent to persistence layer")
            .bean(DatabaseJPAWriter.class)
            .bean(DatabaseJdbcWriter.class)
            .log("Simply save to db... done")
            .bean(MessageToEntity.class)
        .to("jpa://eu.europa.ema.jpa.Record?persistenceUnit=recordJTA")
        .log("saved with camel jpa");

        from("direct:backupcopy")
            .log("Message backuped")
        .to("file:target/backup"); 

        // from("seda:safetyreports?multipleConsumers=true")
        // .bean(BusinessRules.class)
        // .aggregate(new MyAggregationStrategy())
        // .exchange()
        // .completionTimeout(1000)
        // .parallelProcessing()
        // .to("file:target/messages?fileName=reports.xml");

        from("seda:safetyreports")
            .beanRef("BusinessRules")
            
        // Drools Endpoint
        // valid 'action' values are:
        // 'execute' that takes a 'Command' object (default)
        // 'insertBody' that inserts the Exchange.in.body, and executes rules
        // 'insertMessage' that inserts the Exchange.in (type org.apache.camel.Message), and executes rules
        // 'insertExchange' that inserts the Exchange (type org.apache.camel.Exchange), and executes rules            
            .to("kie:ksession1?action=insertMessage")
            
            .aggregate(new MyAggregationStrategy())
                .exchange()
                .completionTimeout(1000)
        .to("file:target/messages?fileName=reports.xml");

    }

}
