/**
 *
 */
package eu.europa.ema.phv.common.xmladapter;

import com.google.common.collect.ImmutableMap;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Map;

/**
 * Convert from and to a String to Date from the format.
 * The format types are from  METABASE.LK_DATEFORMAT
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 24 Jun 2014 $
 * @since 24 Jun 2014 (creation date)
 */
public class EvDateAdapter extends XmlAdapter<String, Date> {

    public static final Map<String, SimpleDateFormat> FORMATTER = ImmutableMap.of(
            "204", new SimpleDateFormat("yyyyMMddHHmmss"),
            "203", new SimpleDateFormat("yyyyMMddHHmm"),
            "102", new SimpleDateFormat("yyyyMMdd"),
            "610", new SimpleDateFormat("yyyyMM"),
            "602", new SimpleDateFormat("yyyy"));

    @Override
    public String marshal(Date v) throws Exception {
        return FORMATTER.get("204").format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        switch (v.length()) {
            case 14:
                return FORMATTER.get("204").parse(v);
            case 12:
                return FORMATTER.get("203").parse(v);
            case 8:
                return FORMATTER.get("102").parse(v);
            case 6:
                return FORMATTER.get("610").parse(v);
            case 4:
                return FORMATTER.get("602").parse(v);
        }
        throw new InputMismatchException("Date not recognized");
    }

}
