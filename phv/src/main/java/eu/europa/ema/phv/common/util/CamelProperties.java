/**
 *
 */
package eu.europa.ema.phv.common.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * Camel properties used in the full project
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 * @since 23 Jun 2014 (creation date)
 */
public class CamelProperties {
    @Value("${camel.aggregation.timeout}")
    private Long aggregationTimeout;

    /**
     * @return the aggregationTimeout
     */
    public Long getAggregationTimeout() {
        return aggregationTimeout;
    }

    /**
     * @param aggregationTimeout the aggregationTimeout to set
     */
    public void setAggregationTimeout(Long aggregationTimeout) {
        this.aggregationTimeout = aggregationTimeout;
    }

}
