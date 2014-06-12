/**
 * 
 */
package eu.europa.ema.phv.messagehandler;

import org.apache.camel.spring.SpringRouteBuilder;

import eu.europa.ema.phv.common.exception.UnexpectedResultException;

/**
 * T
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 12 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 12 Jun 2014 $
 */
public class MessageHandlerRouter extends SpringRouteBuilder {

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.camel.builder.RouteBuilder#configure()
     */
    @Override
    public void configure() throws Exception {
        //@formatter:off
        from("jms:queue:jms/queue0?concurrentConsumers=20&asyncConsumer=true")
            .transacted()
            .processRef("XmlValidator")
            .choice()
                .when(header("ValidationResult").isEqualTo("valid"))
                    .to("direct:valid")
                 .when(header("ValidationResult").isEqualTo("invalid"))
                     .to("direct:invalid")
                 .otherwise()
                     .throwException(new UnexpectedResultException("Validation didn't set the right header"));
        //@formatter:on
        invalidXmlBranch();
        validXmlBranch();
    }

    private void invalidXmlBranch() {
        //@formatter:off        
        from("direct:invalid")
            .transacted()
            .processRef("MetadataExtractor")
            .to("direct:messageStore")
            .beanRef("AckTranslator")
        .to("jms:queue:jms/ack");
        //@formatter:on        
    }

    private void validXmlBranch() {
        //@formatter:off        
        from("direct:valid")
            .transacted()
            .beanRef("MetadataEnricher")            
            .multicast()
            .to("direct:messageStore")
            .to("direct:notWebtrader");
        //@formatter:on
        
        //@formatter:off        
        from("direct:messageStore")
            .beanRef("StoreEnricher");
        // @formatter:on
        // TODO: Call the persistence layer here
        
        //@formatter:off        
        from("direct:notWebtrader")
             .filter(header("foo").isEqualTo("bar")) // TODO: Filter by NOT Webtrader
             .choice()
                .when(header("foo").isEqualTo("bar"))
                    .to("jms:queue:/jms/icsrEma")
                .when(header("foo").isEqualTo("cheese"))
                    .beanRef("RoutingTranslator")
                    .to("jms:queue:/jms/outbound")
                .otherwise()
                    .throwException(new UnexpectedResultException("Message not recognized by the router"));
        // @formatter:on
    }
    
}
