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
    private static final String AXWAY_EP = "jms:queue:jms/axway?concurrentConsumers=20&asyncConsumer=true";
    private static final String VALID_EP ="direct:valid";
    private static final String INVALID_EP ="direct:invalid";
    private static final String OUTBOUND_EP = "jms:queue:/jms/outbound";
    private static final String MESSAGE_STORE_EP="direct:messageStore";
    private static final String CONTINUE_ROUTING_EP="direct:continueRouting";
    private static final String ADR_PARSER_HUMAN_EP="jms:queue:jms/parser/human/adr";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.camel.builder.RouteBuilder#configure()
     */
    @Override
    public void configure() throws Exception {
        //@formatter:off
        from(AXWAY_EP)
            .transacted()
            .processRef("XmlValidator")
            .choice()
                .when(header("ValidationResult").isEqualTo("valid"))
                    .to(VALID_EP)
                 .when(header("ValidationResult").isEqualTo("invalid"))
                     .to(INVALID_EP)
                 .otherwise()
                     .throwException(new UnexpectedResultException("Validation didn't set the right header"));
        //@formatter:on
        invalidXmlBranch();
        validXmlBranch();
    }

    private void invalidXmlBranch() {
        //@formatter:off        
        from(INVALID_EP)
            .transacted()
            .processRef("MetadataExtractor")
            .to("direct:messageStore")
            .beanRef("AckTranslator")
        .to(OUTBOUND_EP);
        //@formatter:on        
    }

    private void validXmlBranch() {
        //@formatter:off        
        from(VALID_EP)
            .transacted()
            .beanRef("MetadataEnricher")            
            .multicast()
                .to(MESSAGE_STORE_EP)
                .to(CONTINUE_ROUTING_EP);
        //@formatter:on
        
        //@formatter:off        
        from(MESSAGE_STORE_EP)
            .beanRef("StoreEnricher");
        // @formatter:on
        // TODO: Call the persistence layer here
        
        //@formatter:off        
        from(CONTINUE_ROUTING_EP)
             .filter(header("foo").isEqualTo("bar")) // TODO: Filter by NOT Webtrader
             .choice()
                .when(header("foo").isEqualTo("bar")) // TODO: is Icsr to EMA
                    .to(ADR_PARSER_HUMAN_EP)
                .when(header("foo").isEqualTo("cheese")) // TODO: is Rerouting
                    .beanRef("RoutingTranslator")
                    .to(OUTBOUND_EP)
                .otherwise()
                    .throwException(new UnexpectedResultException("Message not recognized by the router"));
        // @formatter:on
    }
    
}
