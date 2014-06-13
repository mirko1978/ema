package eu.europa.ema.phv.common.persistence;


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
 * Not used at all. It is here just for not having errors on persistence.xml
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
