package eu.europa.ema.phv.common.xmladapter;

import java.text.SimpleDateFormat;

/**
 * Deine the ICSR R2 Date format type, the formatter for text to date and data to text
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 27/06/2014 $
 * @since 27/06/2014 (creation date)
 */
public enum IcsrR2DateFormat {
    /**
     * Default date format: yyyyMMddHHmmss
     */
    _204("204", "yyyyMMddHHmmss"),
    /**
     * Date format: yyyyMMddHHmm
     */
    _203("203", "yyyyMMddHHmm"),
    /**
     * Date format: yyyyMMdd
     */
    _102("102", "yyyyMMdd"),
    /**
     * Date format: yyyyMM
     */
    _610("610", "yyyyMM"),
    /**
     * Date format: yyyy
     */
    _602("602", "yyyy");

    private final String code;

    private final String format;

    private final SimpleDateFormat formatter;

    private IcsrR2DateFormat(String code, String format) {
        this.code = code;
        this.format = format;
        formatter = new SimpleDateFormat(format);
    }

    /**
     * @return The format code used in the XML
     */
    public String getCode() {
        return code;
    }

    /**
     * @return The java formatter
     */
    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    /**
     * @return the length of the format.
     */
    public int getFormatLength() {
        return format.length();
    }
}
