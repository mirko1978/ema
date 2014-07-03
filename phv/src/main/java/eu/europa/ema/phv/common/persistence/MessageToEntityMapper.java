package eu.europa.ema.phv.common.persistence;

import eu.europa.ema.phv.common.exception.InvalidMessageHeaderException;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.messagehandler.enricher.MetadataEnricher;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;

public class MessageToEntityMapper {
	
	private static final Logger LOG = LoggerFactory.getLogger(MessageToEntityMapper.class);
	
	public InboundMessageEntity mapMessageToEntity(Exchange exchange, IchicsrMessage icsr) throws Exception {
		
		if(icsr==null){
			icsr = (IchicsrMessage) exchange.getIn().getHeader("icsr");
		}
		if(icsr==null) {
			return null; //throw exception to rollback?
		}
		
		//As per the database constraints incoming message can be saved only if
		//senderid, receive date and doctype are not null
		
		if(icsr.getSenderid() == null ||
				icsr.getMessagedate() == null){
			LOG.error("Message not persisted as the mandatory icsr message headers have invalid value - senderId = {} , recevied date = {}",icsr.getSenderid(), icsr.getMessagedate()); //throw exception to rollback?
			throw new InvalidMessageHeaderException("Message not persisted as the mandatory icsr message headers have invalid value");
		}
		
		InboundMessageEntity entity = new InboundMessageEntity();
		entity.setDocument((String)exchange.getIn().getBody().toString());
		entity.setMessagenumb(icsr.getMessagenumber());
		entity.setReceivedate(icsr.getMessagedate());
		entity.setSenderid(icsr.getSenderid());
		entity.setStatus(exchange.getIn().getHeader("validationResult").toString().equalsIgnoreCase("valid")? "Y":"N");
		entity.setStatusStamp(new Date());//(Date)exchange.getIn().getHeader("ValidationDate"));
		//entity.setXMessagebox(XMessagebox)
		entity.setArchived(0);
		entity.setDoctype(icsr.getDocumenttype().intValue());
		
		//populate messagebox foriegn key, need to fetch the pk for the receiver id from db
		//for the time being dummy
		MessageBoxEntity msgBox = null;
		try{
			msgBox = msgBox.findByOwner(icsr.getReceiverid());
		}catch(Exception e){
			LOG.warn("Message Box for the receiver= {} not available, new one will be created",icsr.getReceiverid() ); //no data found exception
			
		}
		
		if(msgBox ==null){ //should throw an exception as they should be present, temporary object for sprint1
			msgBox = new MessageBoxEntity();
			msgBox.setPkMessagebox(Double.valueOf(Math.random()).intValue());
			msgBox.setCreationdate(new Date());
			msgBox.setMessageboxname(icsr.getReceiverid());
			BigDecimal num = new BigDecimal(100);
			msgBox.setArchiveinterval(num);
			msgBox.setNumarchivedin(num);
			msgBox.setNumarchivedout(num);
			msgBox.setNummaxmessagein(num);
			msgBox.setNummessagein(num);
			msgBox.setNummessageout(num);
			msgBox.setOwner(icsr.getReceiverid());
		}
		entity.setXMessagebox(msgBox);
		return entity;
	}

}
