/**
 *
 */
package eu.europa.ema.phv.common.model.adrhuman;

/**
 * Define the ACK codes
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 * @since 23 Jun 2014 (creation date)
 */
public enum IcsrAckCodeEnum {
    /**
     * Reports loaded into database
     */
    OK("01"),
    /**
     * ICSR Error, not all reports loaded into the database, check section B
     */
    ICSR_WARNING("02"),
    /**
     * SGML parsing error, no data extracted
     */
    ICSR_ERROR("03");

    private final String code;

    private IcsrAckCodeEnum(String code) {
        this.code = code;
    }

    /**
     * @return the transmission code
     */
    public String getCode() {
        return code;
    }

}
