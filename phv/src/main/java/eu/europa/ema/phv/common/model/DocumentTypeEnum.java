package eu.europa.ema.phv.common.model;

/**
 * Define the document type from the table METABASE.LK_DOCUMENTTYPE
 *
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 24 Jun 2014 (creation date)
 */
public enum DocumentTypeEnum {
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
     * Convert a database code number in DocumentTypeEnum
     * @param number from the database
     * @return
     */
    public static DocumentTypeEnum fromNumber(int number) {
        DocumentTypeEnum[] all = DocumentTypeEnum.values();
        if (number > all.length || number < 1) {
            throw new IllegalArgumentException("Document type not mapped for " + number);
        }
        return all[number - 1];
    }

    /**
     * Convert the current DocumentTypeEnum in a database number
     * @return the database number
     */
    public int toNumber() {
        return this.ordinal() + 1;
    }

    /**
     * Convert the XML String in a DocumentTypeEnum
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
     * @return the XML String
     */
    public String toXmlString() {
        String norma = name().toLowerCase();
        return norma.replace('_', '-');
    }
}
