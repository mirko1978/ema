package eu.europa.ema;

import java.util.Calendar;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import eu.europa.ema.jpa.Record;
/**
 * 
 * Simple example of message translaction, from {@link Exchange} to {@link Record}
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @author  $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 10 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 10 Jun 2014 $
 */
@Component("MessageToEntity")
public class MessageToEntity {

    public static Record translate(Exchange exchange) {
        Record record = new Record();
        record.setId(exchange.getExchangeId());
        record.setBody(exchange.getIn().getBody(String.class));
        record.setHeader("Camel JPA");
        record.setWhen(Calendar.getInstance().getTime());
        return record;
    }
}
