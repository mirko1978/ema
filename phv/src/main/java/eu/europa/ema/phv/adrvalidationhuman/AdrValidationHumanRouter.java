/**
 *
 */
package eu.europa.ema.phv.adrvalidationhuman;

import eu.europa.ema.phv.common.util.CamelProperties;
import eu.europa.ema.phv.common.util.JmsCamelUrl;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.camel.spring.SpringRouteBuilder;

import javax.annotation.Resource;
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

    @Resource(name = "adrReportAggregationStrategy")
    private AggregationStrategy adrAggregationStrategy;

    @Inject
    private CamelProperties camelProperties;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from(camelUrl.getAdrValidationHuman())
            //.transacted()
            // Call the validation process
            .beanRef("adrHumanBRValidation",true)
            // Now the mesage is IcsrR2ReportValidationResult
            .log("Report: ${body.message.report.toString()}")
            // Aggregation is done by the same message ID
            .aggregate(simple("${body.message.header.icsr.pkIchicsrmessage}"), adrAggregationStrategy)
                .completionTimeout(camelProperties.getAggregationTimeout())
                .completionSize(simple("${body.message.total}"))
            .transform(simple("${body.icsrAcks}"))
        .to(camelUrl.getOutboundMessage());
        //@formatter:on

        // TODO: define the wsdl for the service and add the route WS -> Jms
        // queue
    }
}
