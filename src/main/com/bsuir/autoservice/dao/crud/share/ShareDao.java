package main.com.bsuir.autoservice.dao.crud.share;

import com.google.inject.Inject;
import main.com.bsuir.autoservice.bean.share;
import main.com.bsuir.autoservice.dao.crud.AbstractDaoCrud;
import main.com.bsuir.autoservice.dao.database.IDatabase;
import main.com.bsuir.autoservice.dao.exception.DaoException;
import main.com.bsuir.autoservice.dao.sql.ISql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ShareDao extends AbstractDaoCrud<Integer, share> implements IShareDao {

    @Inject
    public ShareDao(IDatabase db, ISql sql) {
        super(db, sql);
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public List<share> parseResultSet(ResultSet rs) throws DaoException {
        LinkedList<share> result = new LinkedList<>();
        try {
            while (rs.next()) {
                share bean = new share();
                result.add(bean);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    private final String tableName = "share";
}