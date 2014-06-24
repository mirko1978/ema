/**
 * 
 */
package eu.europa.ema.phv.common.xmladapter;

import eu.europa.ema.phv.common.model.DocumentTypeEnum;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

/**
 * Convert the integer database document type in the XML String document type and vice versa
 * 
 * @author  Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 24 Jun 2014 (creation date)
 * @revisionDate  $Date: 2003/12/19 10:51:34 24 Jun 2014 $
 */
public class EvMessageTypeAdapter extends XmlAdapter<String, BigDecimal> {

    @Override
    public BigDecimal unmarshal(String v) throws Exception {
        DocumentTypeEnum documentType = DocumentTypeEnum.fromXmlString(v);
        return BigDecimal.valueOf(documentType.toNumber());
    }

    @Override
    public String marshal(BigDecimal v) throws Exception {
        DocumentTypeEnum documentType = DocumentTypeEnum.fromNumber(v.intValue());
        return documentType.toXmlString();
    }
}
