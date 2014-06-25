/**
 * 
 */
package eu.europa.ema.phv.messagehandler.processor;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import eu.europa.ema.phv.common.model.adrhuman.IcsrR2Header;
import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Ichicsr;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Ichicsrmessageheader;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagedate;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagedateformat;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagenumb;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagesenderidentifier;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagetype;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Messagereceiveridentifier;
import eu.europa.ema.phv.common.util.XMLRegEx;

/**
 * Extract the metadata and add to the message
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 12 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 12 Jun 2014 $
 */
public class MetadataExtractor implements Processor {
   
	private static final Logger log = LoggerFactory.getLogger(MetadataExtractor.class);
	
	private static final String PPatternString =
			"\\s*(?><\\?" + XMLRegEx.XMLNodeContentRECTrim + "\\?>)?" + "(?>" + XMLRegEx.XMLBWNodeContentRE +
			"|" + XMLRegEx.XMLCommentRE + ")*" + "(?><!DOCTYPE\\s+" + XMLRegEx.XMLNodeContentRECTrim +
			"\\s*>)?" + "(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE(XMLRegEx.XMLNameREC, XMLRegEx.FRE_NodeBeginAttr) + "(?>" +
			XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE("(?>[a-z]*messageheader)", XMLRegEx.FRE_NodeBeginAttr) + "(?>" +
			XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE("messagetype",
											 XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeAnyAttr + XMLRegEx.FRE_CaptureContent +
											 XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim) +
			"(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE("messageformatversion",
											 XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeAnyAttr + XMLRegEx.FRE_CaptureNone +
											 XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim,
											 "?") + "(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE("messageformatrelease",
											 XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeAnyAttr + XMLRegEx.FRE_CaptureNone +
											 XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim,
											 "?") + "(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE("messagenumb",
											 XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeAnyAttr + XMLRegEx.FRE_CaptureContent +
											 XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim) +
			"(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE("messagesenderidentifier",
											 XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeFullAttr + XMLRegEx.FRE_CaptureContent +
											 XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim) +
			"(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE("messagereceiveridentifier",
											 XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeFullAttr + XMLRegEx.FRE_CaptureContent +
											 XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim) +
			"(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE("messagedateformat",
											 XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeAnyAttr + XMLRegEx.FRE_CaptureContent +
											 XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim,
											 "?") + "(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
			XMLRegEx.XMLNodeRE("messagedate",
											 XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeAnyAttr + XMLRegEx.FRE_CaptureContent +
											 XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim,
											 "?") + ".*";

		private Pattern PPattern =
			XMLRegEx.compile(PPatternString, Pattern.MULTILINE + Pattern.DOTALL + Pattern.UNICODE_CASE);
	
    /* (non-Javadoc)
     * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        log.debug(payload);
        MessageMetadata messageMetadata = new MessageMetadata();
        Ichicsr icsr = new Ichicsr();
        Ichicsrmessageheader icsrHeader = new Ichicsrmessageheader();
        //messageMetadata.setFileName((String)exchange.getOut().getHeader("fileName"));
        //messageMetadata.setReceived(new Date((String)exchange.getOut().getHeader("receivedDate")));
        //icsrHeader.setLang(payload);
        //icsrHeader.setMessageformatrelease(value);
        //icsrHeader.setMessageformatversion(value);
       
        int pNG = 0; 
        Matcher pMatcher = PPattern.matcher(payload);
		if (pMatcher.find())
		{
			log.debug("Declaration: " + pMatcher.group(++pNG));
			log.debug("DocumentType: " + pMatcher.group(++pNG));
			log.debug("Doc Root: " + pMatcher.group(++pNG));
			
			Messagetype type = new Messagetype();
			if (pMatcher.group(++pNG) == null)
				type.setvalue(pMatcher.group(++pNG));
			else
				type.setvalue(pMatcher.group(pNG++));
			icsrHeader.setMessagetype(type);
			
			Messagenumb numb = new Messagenumb();
			if (pMatcher.group(++pNG) == null)
				numb.setvalue(pMatcher.group(++pNG));
			else
				numb.setvalue(pMatcher.group(pNG++));
			icsrHeader.setMessagenumb(numb);
			
			Messagesenderidentifier sender =  new Messagesenderidentifier();
			sender.setvalue(pMatcher.group(++pNG));
			icsrHeader.setMessagesenderidentifier(sender);
			
			Messagereceiveridentifier receiver = new Messagereceiveridentifier();
			receiver.setvalue(pMatcher.group(++pNG));
			icsrHeader.setMessagereceiveridentifier(receiver);
			
			Messagedateformat dateFormat =  new Messagedateformat();
			if (pMatcher.group(++pNG) == null)
				dateFormat.setvalue(pMatcher.group(++pNG));
			else
				dateFormat.setvalue(pMatcher.group(pNG++));
				icsrHeader.setMessagedateformat(dateFormat);
			
			Messagedate msgDate = new Messagedate(); 
			if (pMatcher.group(++pNG) == null)
				msgDate.setvalue(pMatcher.group(++pNG));
			else
				msgDate.setvalue(pMatcher.group(pNG++));
			icsrHeader.setMessagedate(msgDate);
		
		}
        icsr.setIchicsrmessageheader(icsrHeader);
        log.debug("ICSR obj :" + icsr.toString());

    }
    


}
