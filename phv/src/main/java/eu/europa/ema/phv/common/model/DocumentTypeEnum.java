package eu.europa.ema.phv.common.model;

/**
 * Define the document type from the table METABASE.LK_DOCUMENTTYPE
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 24 Jun 2014 (creation date)
 */
public enum DocumentTypeEnum {
    /**
     * Value 0 is not used in the database
     */
    NOT_USED,
    ICHICSR,
    BACKLOG,
    SUSAR,
    MASTER_PMICSR,
    PSURMESSAGE,
    PRODUCT,
    VETPRODUCT,
    VETADR,
    ATTACHMENT,
    PRODUCTSYNC,
    ORGSYNC,
    BACKLOGCT,
    CTASR,
    EMEADATA,
    MASTER_CTASR,
    MASTER_CTICSR,
    MASTER_PMPSUR,
    MASTER_CTPSUR;

    /**
     * Convert the XML String in a DocumentTypeEnum
     *
     * @param value the XML String
     * @return
     */
    public static DocumentTypeEnum fromXmlString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot convert null to Document Type");
        }
        String norma = value.toUpperCase();
        return DocumentTypeEnum.valueOf(norma.replace('-', '_'));
    }

    /**
     * Convert the current DocumentTypeEnum in a XML String
     *
     * @return the XML String
     */
    public String toXmlString() {
        String norma = name().toLowerCase();
        return norma.replace('_', '-');
    }
}
