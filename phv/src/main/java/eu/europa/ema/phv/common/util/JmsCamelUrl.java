/**
 * 
 */
package eu.europa.ema.phv.common.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * JMS connection Url definition
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 13 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 */
public class JmsCamelUrl {

    @Value("${jms.gateway.human.adr.camel}")
    private String gatewayHumanAdr;

    @Value("${jms.outbound.message.camel}")
    private String outboundMessage;

    @Value("${jms.adr.parser.human.camel}")
    private String adrParserHuman;

    @Value("${jms.adr.validation.human.camel}")
    private String adrValidationHuman;

    @Value("${jms.gateway.outbox.camel}")
    private String gatewayOutbox;

    public String getGatewayHumanAdr() {
        return gatewayHumanAdr;
    }

    public String getOutboundMessage() {
        return outboundMessage;
    }

    public String getAdrParserHuman() {
        return adrParserHuman;
    }

    public String getAdrValidationHuman() {
        return adrValidationHuman;
    }

    public String getGatewayOutbox() {
        return gatewayOutbox;
    }

    /**
     * @param gatewayHumanAdr the gatewayHumanAdr to set
     */
    public void setGatewayHumanAdr(String gatewayHumanAdr) {
        this.gatewayHumanAdr = gatewayHumanAdr;
    }

    /**
     * @param outboundMessage the outboundMessage to set
     */
    public void setOutboundMessage(String outboundMessage) {
        this.outboundMessage = outboundMessage;
    }

    /**
     * @param adrParserHuman the adrParserHuman to set
     */
    public void setAdrParserHuman(String adrParserHuman) {
        this.adrParserHuman = adrParserHuman;
    }

    /**
     * @param adrValidationHuman the adrValidationHuman to set
     */
    public void setAdrValidationHuman(String adrValidationHuman) {
        this.adrValidationHuman = adrValidationHuman;
    }

    /**
     * @param gatewayOutbox the gatewayOutbox to set
     */
    public void setGatewayOutbox(String gatewayOutbox) {
        this.gatewayOutbox = gatewayOutbox;
    }

}
