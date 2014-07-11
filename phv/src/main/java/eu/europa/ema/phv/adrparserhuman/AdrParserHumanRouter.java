/**
 *
 */
package eu.europa.ema.phv.adrparserhuman;

import eu.europa.ema.phv.common.util.JmsCamelUrl;
import org.apache.camel.spring.SpringRouteBuilder;

import javax.inject.Inject;

/**
 * Route definition for the ADR pareser Human route.<br/>
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 * @since 13 Jun 2014 (creation date)
 */
public class AdrParserHumanRouter extends SpringRouteBuilder {
    public static final String PERSIST = "direct:persistIcsr";

    private static final String SAVE_HEADER = "Save received message";

    @Inject
    private JmsCamelUrl camelUrl;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from(camelUrl.getAdrParserHuman())
            .transacted()           
            .log("Message received: ${body.icsr.toString()}")

            // Save in the header the body in order to restore after the persist action
            .setHeader(SAVE_HEADER, body())
            .to(PERSIST)
            .setBody(header(SAVE_HEADER))

            .split()
                .method("reportSplitter")
                .parallelProcessing()
        .to(camelUrl.getAdrValidationHuman());

        // Prepare the message for storing
        from(PERSIST)
            .transacted()
            .log("Persisting: ${body.icsr.toString()}")
            .beanRef("icsrStoreService", "prepareForStoring", true)
            .transform(simple("${body.icsr}"))
        .to("jpaIcsr://?persistenceUnit=icsrJta");
        //@formatter:on

    }

}
