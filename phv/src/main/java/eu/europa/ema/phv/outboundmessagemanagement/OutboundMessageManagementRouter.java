/**
 *
 */
package eu.europa.ema.phv.outboundmessagemanagement;

import javax.inject.Inject;

import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spring.SpringRouteBuilder;

import eu.europa.ema.phv.common.util.JmsCamelUrl;

/**
 * Route definition for the Outbound Message Management
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 * @since 13 Jun 2014 (creation date)
 */
public class OutboundMessageManagementRouter extends SpringRouteBuilder {

    private static final String BACKUP_EP = "file:/tmp?fileName=ack-${date:now:yyyyMMddHHmmss}.xml";

    @Inject
    private JmsCamelUrl camelUrl;

    @Override
    public void configure() throws Exception {
        JaxbDataFormat jaxb = new JaxbDataFormat("eu.europa.ema.phv.common.model.adrhuman.icsrr2.xml.ack");
        //@formatter:off
        from(camelUrl.getOutboundMessage())
            .log("Acknowledge received: ${body.toString()}")
            .marshal(jaxb)
        .to(camelUrl.getGatewayOutbox())
        .to(BACKUP_EP);
        //@formatter:on

        // TODO: define the wsdl for the service and add the route WS -> Jms
        // queue
    }

}
