package eu.europa.ema;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * 
 * Example of really basic aggregation where the result is just a concatenation
 * of the messages
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @author $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 10 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 10 Jun 2014 $
 */
public class MyAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }
        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);
        String body = oldBody + newBody;
        oldExchange.getIn().setBody(body);
        return oldExchange;
    }

}
