/**
 *
 */
package eu.europa.ema.phv.common.xmladapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;
import java.util.InputMismatchException;

import static eu.europa.ema.phv.common.xmladapter.IcsrR2DateFormat.*;

/**
 * Convert from and to a String to Date from the format.
 * The format types are from  METABASE.LK_DATEFORMAT. <br/>
 * The class convert always from Date to String using the format 204
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 24 Jun 2014 $
 * @since 24 Jun 2014 (creation date)
 */
public class IcsrR2DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public String marshal(Date v) throws Exception {
        return _204.getFormatter().format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        int length = v.length();
        IcsrR2DateFormat dateFormat;
        if (_204.getFormatLength() == length) {
            dateFormat = _204;
        }
        else if (_203.getFormatLength() == length) {
            dateFormat = _203;
        }
        else if (_102.getFormatLength() == length) {
            dateFormat = _102;
        }
        else if (_610.getFormatLength() == length) {
            dateFormat = _610;
        }
        else if (_602.getFormatLength() == length) {
            dateFormat = _602;
        }
        else {
            throw new InputMismatchException("Date not recognized: " + v);
        }
        return dateFormat.getFormatter().parse(v);
    }

}
