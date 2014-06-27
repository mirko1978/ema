/**
 *
 */
package eu.europa.ema.phv.adrvalidationhuman;

import eu.europa.ema.phv.common.util.CamelProperties;
import eu.europa.ema.phv.common.util.JmsCamelUrl;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.camel.spring.SpringRouteBuilder;

import javax.inject.Inject;

/**
 * Route definition for the ADR Validation Human
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 * @since 13 Jun 2014 (creation date)
 */
public class AdrValidationHumanRouter extends SpringRouteBuilder {

    @Inject
    private JmsCamelUrl camelUrl;

    @Inject
    private AggregationStrategy adrAggregationStrategy;

    @Inject
    private CamelProperties camelProperties;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from(camelUrl.getAdrValidationHuman())
            .transacted()
            .beanRef("AdrHumanBRValidation")
            // TODO: JPA endpoint for storing the message
            .beanRef("AdrHumanExternalProcedure", "runClassification")
            .beanRef("AdrHumanExternalProcedure", "runRecoding")
            .aggregate(simple("${body.message.messageId}"), adrAggregationStrategy)
                .completionTimeout(camelProperties.getAggregationTimeout())
                .completionSize(simple("${body.message.total}"))
        .to(camelUrl.getGatewayOutbox());
        //@formatter:on

        // TODO: define the wsdl for the service and add the route WS -> Jms
        // queue
    }

}
