package eu.europa.ema;

import java.util.Calendar;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import eu.europa.ema.jpa.Record;

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
