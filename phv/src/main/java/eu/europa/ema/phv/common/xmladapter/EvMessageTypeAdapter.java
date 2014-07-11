/**
 *
 */
package eu.europa.ema.phv.common.xmladapter;

import eu.europa.ema.phv.common.model.DocumentTypeEnum;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Convert the integer database document type in the XML String document type and vice versa
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 24 Jun 2014 $
 * @since 24 Jun 2014 (creation date)
 */
public class EvMessageTypeAdapter extends XmlAdapter<String, DocumentTypeEnum> {

    @Override
    public DocumentTypeEnum unmarshal(String v) throws Exception {
        return DocumentTypeEnum.fromXmlString(v);
    }

    @Override
    public String marshal(DocumentTypeEnum v) throws Exception {
        return v.toXmlString();
    }
}
