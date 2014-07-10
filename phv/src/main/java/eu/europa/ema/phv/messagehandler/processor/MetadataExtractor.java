/**
 *
 */
package eu.europa.ema.phv.messagehandler.processor;

import eu.europa.ema.phv.common.model.adrhuman.MessageMetadata;
import eu.europa.ema.phv.common.model.adrhuman.icsrr2.IchicsrMessage;
import eu.europa.ema.phv.common.util.XMLRegEx;
import eu.europa.ema.phv.common.xmladapter.IcsrR2DateAdapter;
import eu.europa.ema.phv.messagehandler.constants.MessageConstants;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A camel framework processor to extract message and safety report metadata using regular expression
 * when XML parsing / JAXB unmarshalling fails.  The extracted metadata is used for persisting
 * message information and sending any negative acknowldgement
 *
 * @author Vinay Rao raov (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 8 Jul 2014 $
 * @since 8 Jul 2014 (creation date)
 */
public class MetadataExtractor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(MetadataExtractor.class);

    private static final String P_PATTERN_STRING =
            "\\s*(?><\\?" + XMLRegEx.XMLNodeContentRECTrim + "\\?>)?" + "(?>" + XMLRegEx.XMLBWNodeContentRE +
                    "|" + XMLRegEx.XMLCommentRE + ")*" + "(?><!DOCTYPE\\s+" + XMLRegEx.XMLNodeContentRECTrim +
                    "\\s*>)?" + "(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
                    XMLRegEx.XMLNodeRE(XMLRegEx.XMLNameREC, XMLRegEx.FRE_NodeBeginAttr) + "(?>" +
                    XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
                    XMLRegEx.XMLNodeRE("(?>[a-z]*messageheader)", XMLRegEx.FRE_NodeBeginAttr) + "(?>" +
                    XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
                    XMLRegEx.XMLNodeRE("messagetype",
                            XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeAnyAttr + XMLRegEx.FRE_CaptureContent +
                                    XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim)
                    +
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
                                    XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim)
                    +
                    "(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
                    XMLRegEx.XMLNodeRE("messagesenderidentifier",
                            XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeFullAttr + XMLRegEx.FRE_CaptureContent +
                                    XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim)
                    +
                    "(?>" + XMLRegEx.XMLBWNodeContentRE + "|" + XMLRegEx.XMLCommentRE + ")*" +
                    XMLRegEx.XMLNodeRE("messagereceiveridentifier",
                            XMLRegEx.FRE_NodeAnyNaming + XMLRegEx.FRE_NodeFullAttr + XMLRegEx.FRE_CaptureContent +
                                    XMLRegEx.FRE_NodeOKBroken + XMLRegEx.FRE_ContentStopAtNL + XMLRegEx.FRE_ContentTrim)
                    +
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
            XMLRegEx.compile(P_PATTERN_STRING, Pattern.MULTILINE + Pattern.DOTALL + Pattern.UNICODE_CASE);

    @Inject
    private IcsrR2DateAdapter dateAdapter;

    /* (non-Javadoc)
     * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        LOG.debug(payload);
        MessageMetadata messageMetadata = new MessageMetadata();
        IchicsrMessage icsr = new IchicsrMessage();

        int pNG = 0;
        Matcher pMatcher = PPattern.matcher(payload);
        if (pMatcher.find()) {
            LOG.debug("Declaration: {}", pMatcher.group(++pNG));
            LOG.debug("DocumentType: {}", pMatcher.group(++pNG));
            LOG.debug("Doc Root: {}", pMatcher.group(++pNG));

            if (pMatcher.group(++pNG) == null) {
                icsr.setMessagetype(new Integer(pMatcher.group(++pNG)));
            }
            else {
                icsr.setMessagetype(new Integer(pMatcher.group(pNG++)));
            }

            if (pMatcher.group(++pNG) == null) {
                icsr.setMessagenumber(pMatcher.group(++pNG));
            }
            else {
                icsr.setMessagenumber(pMatcher.group(pNG++));
            }

            icsr.setSenderid(pMatcher.group(++pNG));

            icsr.setReceiverid(pMatcher.group(++pNG));

            if (pMatcher.group(++pNG) == null) {
                icsr.setMessageDateFormat(pMatcher.group(++pNG));
            }
            else {
                icsr.setMessageDateFormat(pMatcher.group(pNG++));
            }

            if (pMatcher.group(++pNG) == null) {
                icsr.setMessagedate(dateAdapter.unmarshal(pMatcher.group(++pNG)));
            }
            else {
                icsr.setMessagedate(dateAdapter.unmarshal(pMatcher.group(pNG++)));
            }

        }

        LOG.debug("ICSR obj : {}", icsr.toString());
        exchange.getIn().setHeader(MessageConstants.MESSAGE_HEADER_ICSR, icsr);
        exchange.getIn().setHeader(MessageConstants.MESSAGE_HEADER_RECEIVER, icsr.getReceiverid());
        exchange.getIn().setHeader(MessageConstants.MESSAGE_HEADER_INVALID, MessageConstants.MESSAGE_HEADER_INVALID);
        exchange.getIn().setHeader(MessageConstants.MESSAGE_HEADER_VALIDATION_DATE, new Date());
    }

}
