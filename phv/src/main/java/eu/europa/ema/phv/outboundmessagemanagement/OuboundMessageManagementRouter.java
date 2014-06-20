/**
 * 
 */
package eu.europa.ema.phv.outboundmessagemanagement;

import javax.inject.Inject;

import org.apache.camel.spring.SpringRouteBuilder;

import eu.europa.ema.phv.common.util.JmsCamelUrl;

/**
 * Route definition for the Outbound Message Management
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 13 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 */
public class OuboundMessageManagementRouter extends SpringRouteBuilder {

    @Inject
    private JmsCamelUrl camelUrl;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from(camelUrl.getOutboundMessage())
            .choice()
            .when(header("foo").isEqualTo("bar")) // TODO: Translate to Ack Xml Message
                .beanRef("AckXmlTranslator")
            .when(header("foo").isEqualTo("cheese")) // TODO: Translate to Icsr Xml Message
                .beanRef("IcsrXmlTranslator")            
            .endChoice()
        .to(camelUrl.getGatewayOutbox());
        //@formatter:on

        // TODO: define the wsdl for the service and add the route WS -> Jms
        // queue
    }

}
