package main.com.bsuir.autoservice.dao.impl.service;

import com.google.inject.Inject;
import main.com.bsuir.autoservice.bean.impl.Service;
import main.com.bsuir.autoservice.dao.database.IDatabase;
import main.com.bsuir.autoservice.dao.database.map.IDatabaseMap;
import main.com.bsuir.autoservice.dao.exception.DaoException;
import main.com.bsuir.autoservice.dao.impl.AbstractCrudDao;
import main.com.bsuir.autoservice.dao.sql.IGeneralSql;
import main.com.bsuir.autoservice.dto.ServiceAvailableDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceDao extends AbstractCrudDao<Integer, Service> implements IServiceDao {

    private static final String SERVICE_ID = "id";
    private static final String SERVICE_NAME = "name";
    private static final String SERVICE_COST = "cost";

    @Inject
    public ServiceDao(IDatabase db, IGeneralSql sql, IDatabaseMap databaseMap) {
        super(db, sql, databaseMap);
    }

    @Override
    public List<Service> parseResultSet(ResultSet rs) throws SQLException {
        return new ArrayList<Service>() {{
            while (rs.next()) {
                Service bean = new Service();
                bean.setId(rs.getInt(SERVICE_ID));
                bean.setName(rs.getString(SERVICE_NAME));
                bean.setCost(rs.getInt(SERVICE_COST));
                add(bean);
            }
        }};
    }

    @Override
    public List<ServiceAvailableDTO> getAvailable() throws DaoException {
        final Map<String, String> namedResult = new HashMap<String, String>() {{
            put(SERVICE_NAME, SERVICE_NAME);
            put(SERVICE_COST, SERVICE_COST);
        }};

        return executeQuery(rs ->
                new ArrayList<ServiceAvailableDTO>() {{
                    while (rs.next()) {
                        add(new ServiceAvailableDTO(rs.getString(SERVICE_NAME), rs.getInt(SERVICE_COST)));
                    }
                }}, sql.getSelectNamedQuery(getTableName(), namedResult));
    }

    @Override
    public List<Service> getFullAvailable() throws DaoException {
        return getAll();
    }

    @Override
    public List<Service> getConcreteServices(List<Integer> allUsers) throws DaoException {
        return executeQuery(this::parseResultSet, sql.getSelectWhereInStatement(getTableName(), SERVICE_ID,
                //convert List<Integer> to List<String>
                allUsers.stream().map(Object::toString).collect(Collectors.toList())));
    }
}
