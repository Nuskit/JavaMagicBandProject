package main.com.bsuir.autoservice.service.crud;

import main.com.bsuir.autoservice.service.IService;
import main.com.bsuir.autoservice.service.crud.exception.ServiceException;

import java.util.List;

public interface IServiceCrud<PrimaryKey, Entity>{
    int readTotalCount() throws ServiceException;
    List<Entity> read(int index, int count) throws ServiceException;
    int create(List<Entity> createEntities) throws ServiceException;
    int update(List<Entity> updateEntities) throws ServiceException;
    int delete(List<PrimaryKey> deleteKeys) throws ServiceException;
    String getTableName() throws ServiceException;
}