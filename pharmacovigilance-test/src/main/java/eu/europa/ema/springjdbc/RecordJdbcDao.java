package eu.europa.ema.springjdbc;

import java.sql.Types;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.europa.ema.jpa.Record;
import eu.europa.ema.jpa.RecordDao;

/**
 * 
 * Uses Spring JDBC template in order to store the record in the database. The
 * transaction is managed by JTA
 * 
 * @author Mirko Bernardoni bernardonim (created by)
 * @author $Author: replacedWhenCheckedIn $ (last change by)
 * @version $Revision: 1.1 $ (cvs revision)
 * @since 27 May 2014 (creation date)
 * @revisionDate $Date: 2003/12/19 10:51:34 27 May 2014 $
 */
@Repository("RecordJdbcDao")
@Transactional
public class RecordJdbcDao extends SqlUpdate implements RecordDao, InitializingBean {
    private static final String UPDATE_SQL = "INSERT INTO AAA_MIRKO_RECORD (id,body, header, when) VALUES (?, ?,  ?, ?)";

    private static final Logger LOG = LoggerFactory.getLogger(RecordJdbcDao.class);

    /**
     * Called after the spring property set in order to initialise the query
     * statement
     */
    @Override
    public void afterPropertiesSet() {
        setSql(UPDATE_SQL);
        declareParameter(new SqlParameter("id", Types.VARCHAR));
        declareParameter(new SqlParameter("body", Types.CLOB));
        declareParameter(new SqlParameter("header", Types.VARCHAR));
        declareParameter(new SqlParameter("when", Types.TIMESTAMP));
        compile();
    }

    /**
     * Assign the bean defined in the spring context.<br/>
     * 
     * <code>
     * &lt;jee:jndi-lookup id="jdbcDataSource" jndi-name="jdbc/ev7" /&gt:
     * </code>
     */
    @Resource(name = "jdbcDataSource")
    @Override
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Transactional
    @Override
    public void save(Record record) {
        LOG.info("Saving via Spring JDBC ..." + record.getBody().substring(0, 20) + " id=" + record.getId());
        update(record.getId(), record.getBody(), record.getHeader(), record.getWhen());
    }
}
