package eu.europa.ema.jpa;

import java.util.Calendar;

import javax.annotation.Resource;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * 
 * Convert the message exchange in Record and call the JPA - JTA dao method
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @author $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 27 May 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 27 May 2014 $
 */
@Component("DatabaseJPAWriter")
public class DatabaseJPAWriter {

    @Resource(name = "RecordJPADao")
    private RecordDao recordDao;

    /**
     * Convert the message exchange in Record and call the JPA - JTA dao method
     * @param exchange camel message exchange
     */
    public void save(Exchange exchange) {
        Record record = new Record();
        record.setBody(exchange.getIn().getBody(String.class));
        record.setWhen(Calendar.getInstance().getTime());
        record.setId(exchange.getExchangeId());
        record.setHeader("JPA");
        recordDao.save(record);
    }
}
