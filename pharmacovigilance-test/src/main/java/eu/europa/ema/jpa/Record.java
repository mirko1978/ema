package eu.europa.ema.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Record entity bean. The table code is the follow:
 * 
 * <pre>
 * CREATE TABLE "ICHICSR"."AAA_MIRKO_RECORD" 
 *    (    "ID" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
 *     "BODY" CLOB, 
 *     "WHEN" TIMESTAMP (6), 
 *     "HEADER" VARCHAR2(4000 BYTE) NOT NULL ENABLE
 *    )
 * </pre>
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @author $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 27 May 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 27 May 2014 $
 */
@Entity
@Table(name = "AAA_MIRKO_RECORD")
public class Record implements Serializable {
    private static final long serialVersionUID = 7745065744023002570L;

    private String id;

    @Lob
    private String body;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date when;

    private String header;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

}
