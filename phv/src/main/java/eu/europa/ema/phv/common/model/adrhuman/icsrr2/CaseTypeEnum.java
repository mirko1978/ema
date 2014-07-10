package eu.europa.ema.phv.common.model.adrhuman.icsrr2;

/**
 * Descripes the CASETYPE fileds in the SAFETYREPORT table for the human ICSR
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @revisionDate $Date: 09/07/2014 $
 * @since 09/07/2014 (creation date)
 */
public enum CaseTypeEnum {

    /**
     * The value 0 is not used
     */
    NOT_USED,
    /**
     * Authority = 1
     */
    AUTHORITY,
    /**
     * Company = 2
     */
    COMPANY
}
