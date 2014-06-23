/**
 * 
 */
package eu.europa.ema.phv.common.model.adrhuman;

import java.io.Serializable;

import eu.europa.ema.phv.common.model.adrhuman.icsrr2.Ichicsrmessageheader;

/**
 * Collect all the ICSR R2 header
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 23 Jun 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 23 Jun 2014 $
 */
public class IcsrR2Header implements Serializable {

    private static final long serialVersionUID = -8766415689110080494L;

    private Ichicsrmessageheader ichicsrmessageheader;

    private String lang;

    /**
     * @param ichicsrmessageheader
     * @param lang
     */
    public IcsrR2Header(Ichicsrmessageheader ichicsrmessageheader, String lang) {
        this.ichicsrmessageheader = ichicsrmessageheader;
        this.lang = lang;
    }

    public IcsrR2Header() {
    }

    /**
     * @return the ichicsrmessageheader
     */
    public Ichicsrmessageheader getIchicsrmessageheader() {
        return ichicsrmessageheader;
    }

    /**
     * @param ichicsrmessageheader the ichicsrmessageheader to set
     */
    public void setIchicsrmessageheader(Ichicsrmessageheader ichicsrmessageheader) {
        this.ichicsrmessageheader = ichicsrmessageheader;
    }

    /**
     * @return the lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

}
