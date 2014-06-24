/**
 * 
 */
package eu.europa.ema.phv.common.model.adrhuman;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.ack.Transmissionacknowledgmentcode;

/**
 * Define the ACK codes
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 23 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 */
public enum IcsrAckCode {
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

    private final Transmissionacknowledgmentcode code;

    private IcsrAckCode(String code) {
        this.code = new Transmissionacknowledgmentcode();
        this.code.setvalue(code);
    }

    /**
     * @return the transmission code
     */
    public Transmissionacknowledgmentcode getCode() {
        return code;
    }

}
