package eu.europa.ema.phv.common.persistence;

import java.util.Date;

import org.apache.camel.Exchange;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Ichicsr;

public class MessageToEntityMapper {
	
	public InboundMessageEntity mapMessageToEntity(Exchange exchange, Ichicsr icsr){
		
		if(icsr==null){
			icsr = (Ichicsr) exchange.getIn().getHeader("icsr");
		}
		if(icsr==null) 
			return null; //throw exception to rollback?
		
		//As per the database constraints incoming message can be saved only if
		//senderid, receive date and doctype are not null
		
		if(icsr.getIchicsrmessageheader().getMessagesenderidentifier().getvalue() == null ||
				icsr.getIchicsrmessageheader().getMessagedate().getvalue() == null){
			return null; //throw exception to rollback?
		}
		
		InboundMessageEntity entity = new InboundMessageEntity();
		entity.setDocument((String)exchange.getIn().getBody().toString());
		entity.setMessagenumb(icsr.getIchicsrmessageheader().getMessagenumb().getvalue());
		entity.setReceivedate(new Date());//icsr.getIchicsrmessageheader().getMessagedate().getvalue());
		entity.setSenderid(icsr.getIchicsrmessageheader().getMessagesenderidentifier().getvalue());
		entity.setStatus("Y"); //exchange.getIn().getHeader("ValidationStatus").toString());
		entity.setStatusStamp(new Date());//(Date)exchange.getIn().getHeader("ValidationDate"));
		//entity.setXMessagebox(XMessagebox)
		entity.setArchived(0);
		entity.setDoctype(1);
		
		//populate messagebox foriegn key, need to fetch the pk for the receiver id from db
		//for the time being dummy
		MessageBoxEntity msgBox = new MessageBoxEntity();
		msgBox.setPkMessagebox(1);
		entity.setXMessagebox(msgBox);
		return entity;
		
		
	}

}
