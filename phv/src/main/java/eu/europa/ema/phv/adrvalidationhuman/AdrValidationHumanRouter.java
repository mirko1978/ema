/**
 * 
 */
package eu.europa.ema.phv.adrvalidationhuman;

import javax.inject.Inject;

import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.camel.spring.SpringRouteBuilder;

import eu.europa.ema.phv.common.util.CamelProperties;
import eu.europa.ema.phv.common.util.JmsCamelUrl;

/**
 * Route definition for the ADR Validation Human
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 13 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
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
            //TODO: Call persince layer
            .beanRef("AdrHumanExternalProcedure", "runClassification")
            .beanRef("AdrHumanExternalProcedure", "runRecoding")
            .aggregate(adrAggregationStrategy)
                .exchange()
                .completionTimeout(camelProperties.getAggregationTimeout())
                .completionSize(simple("${body.total}"))
        .to(camelUrl.getGatewayOutbox());
        //@formatter:on

        // TODO: define the wsdl for the service and add the route WS -> Jms
        // queue
    }

}
