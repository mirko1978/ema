/**
 * 
 */
package eu.europa.ema.phv.messagehandler;

import javax.inject.Inject;

import org.apache.camel.Expression;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spring.SpringRouteBuilder;
import org.xml.sax.SAXParseException;

import eu.europa.ema.phv.common.exception.UnexpectedResultException;
import eu.europa.ema.phv.common.persistence.MessageToEntityMapper;
import eu.europa.ema.phv.common.util.JmsCamelUrl;
import eu.europa.ema.phv.messagehandler.enricher.MetadataEnricher;

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
    private static final String HEADER_REROUTING_RECEIVER = "receiver";
    private static final String RECEIVER_EVHUMAN = "EVHUMAN";
    
    @Inject
    private JmsCamelUrl camelUrl;

    @Override
    public void configure() throws Exception {
    	JaxbDataFormat jaxb =  new JaxbDataFormat("eu.europa.ema.phv.common.model.adrhuman.icsrr2");
    	//jaxb.setSchema("classpath:/schema/icsr21xml.dtd");
    	//jaxb.setEncoding("UTF-16");
    	//@formatter:off
    	onException(SAXParseException.class).handled(true).to(INVALID_EP);
        from(camelUrl.getGatewayHumanAdr())
            .transacted()
            .processRef("HeaderProcessor")
            .unmarshal(jaxb)
            .log("Jaxb Validation and transformation complete ")
            .to(VALID_EP);
            /**
            .choice()
                .when(header("ValidationResult").isEqualTo("valid")).log("Validation Suceeded")
                    .to(VALID_EP)
                 .when(header("ValidationResult").isEqualTo("invalid")).log("Validation Failed")
                     .to(INVALID_EP)
                 .otherwise()
                     .throwException(new UnexpectedResultException("Validation didn't set the right header")); */ 
        //@formatter:on
        invalidXmlBranch();
        validXmlBranch();
    }

    private void invalidXmlBranch() {
        //@formatter:off        
        from(INVALID_EP)
            .transacted()
            .log("Jaxb parsing failed.. extracting meta data from the payload")
            .processRef("MetadataExtractor")
            .log("Meta data extracted from the invlaid message")
            .to(MESSAGE_STORE_EP)
            .beanRef("AckTranslator")
        .to(camelUrl.getOutboundMessage());
        //@formatter:on        
    }

    private void validXmlBranch() {
        //@formatter:off        
        from(VALID_EP)
            .transacted().log("Message is valid.. enriching")
            .beanRef("MetadataEnricher")
            .log("Routing enriched message ...")
            .multicast()
                .to(MESSAGE_STORE_EP)
                .to(CONTINUE_ROUTING_EP);
        //@formatter:on
        
        //@formatter:off        
        from(MESSAGE_STORE_EP)
            .transacted()
            //.beanRef("StoreEnricher")
            .bean(MessageToEntityMapper.class, "mapMessageToEntity")
            .log("Persisting the message meta data")
         .to("jpa:eu.europa.ema.phv.common.persistence.InboundMessageEntity?persistenceUnit=messageJTA");
        // @formatter:on
        // TODO: Call the persistence layer here
        
        //@formatter:off        
        from(CONTINUE_ROUTING_EP)
             .filter(header(HEADER_REROUTING_RECEIVER).isEqualTo(HEADER_REROUTING_RECEIVER)) // TODO: Filter by NOT Webtrader
             .choice()
                .when(header(HEADER_REROUTING_RECEIVER).isEqualTo(RECEIVER_EVHUMAN)) // TODO: is Icsr to EMA
                    .beanRef("MessageEnricher")
                	.log("Routing the valid enriched message to Human ADR Parser")
                	.to(camelUrl.getAdrParserHuman())
                .when(header(HEADER_REROUTING_RECEIVER).isNotEqualTo(RECEIVER_EVHUMAN)) // TODO: is Rerouting
                    .beanRef("RoutingTranslator")
                    .log("Routing web trader messages to storage handler")
                    .to(camelUrl.getOutboundMessage())
                .otherwise()
                	.log("Exception")
                    .throwException(new UnexpectedResultException("Message not recognized by the router"))
                .endChoice()
                .end();
        // @formatter:on
    }
    
}
