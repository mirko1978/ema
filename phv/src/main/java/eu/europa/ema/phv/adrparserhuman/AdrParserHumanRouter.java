/**
 * 
 */
package eu.europa.ema.phv.adrparserhuman;

import javax.inject.Inject;

import org.apache.camel.spring.SpringRouteBuilder;

import eu.europa.ema.phv.common.util.JmsCamelUrl;

/**
 * Route definition for the ADR pareser Human route
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 13 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 13 Jun 2014 $
 */
public class AdrParserHumanRouter extends SpringRouteBuilder {

    @Inject
    private JmsCamelUrl camelUrl;

    @Override
    public void configure() throws Exception {
        //@formatter:off
        from(camelUrl.getAdrParserHuman())
            .transacted()           
            .log("Message received: ${body.icsr.ichicsrmessageheader.messagenumb.getvalue()}")            
            .split()                                
                .method("ReportSplitter")                
                .parallelProcessing()
        .to(camelUrl.getAdrValidationHuman());
        //@formatter:on
    }

}
