/**
 * 
 */
package eu.europa.ema.phv.messagehandler;

import javax.inject.Inject;

import org.apache.camel.spring.SpringRouteBuilder;

import eu.europa.ema.phv.common.exception.UnexpectedResultException;
import eu.europa.ema.phv.common.util.JmsCamelUrl;

/**
 * Route definition for the Message Handler component
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 12 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 12 Jun 2014 $
 */
public class MessageHandlerRouter extends SpringRouteBuilder {
    
    // Component internal camel route
    private static final String VALID_EP ="direct:valid";
    private static final String INVALID_EP ="direct:invalid";
    private static final String MESSAGE_STORE_EP="direct:messageStore";
    private static final String CONTINUE_ROUTING_EP="direct:continueRouting";
    
    @Inject
    private JmsCamelUrl camelUrl;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from(camelUrl.getGatewayHumanAdr())
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
            .to(MESSAGE_STORE_EP)
            .beanRef("AckTranslator")
        .to(camelUrl.getOutboundMessage());
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
            .transacted()
            .beanRef("StoreEnricher");
        // @formatter:on
        // TODO: Call the persistence layer here
        
        //@formatter:off        
        from(CONTINUE_ROUTING_EP)
             .filter(header("foo").isEqualTo("bar")) // TODO: Filter by NOT Webtrader
             .choice()
                .when(header("foo").isEqualTo("bar")) // TODO: is Icsr to EMA
                    .to(camelUrl.getAdrParserHuman())
                .when(header("foo").isEqualTo("cheese")) // TODO: is Rerouting
                    .beanRef("RoutingTranslator")
                    .to(camelUrl.getOutboundMessage())
                .otherwise()
                    .throwException(new UnexpectedResultException("Message not recognized by the router"));
        // @formatter:on
    }
    
}