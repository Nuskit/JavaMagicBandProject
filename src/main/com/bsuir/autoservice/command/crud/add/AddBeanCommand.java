package main.com.bsuir.autoservice.command.crud.add;

import com.google.inject.Inject;
import main.com.bsuir.autoservice.bean.Bean;
import main.com.bsuir.autoservice.bean.exception.BeanException;
import main.com.bsuir.autoservice.command.ICommand;
import main.com.bsuir.autoservice.command.exception.CommandException;
import main.com.bsuir.autoservice.command.param.BeanAddPageInfo;
import main.com.bsuir.autoservice.dao.database.map.IDatabaseMap;
import main.com.bsuir.autoservice.exception.ExceptionUnwrapper;
import main.com.bsuir.autoservice.service.IServiceCrud;
import main.com.bsuir.autoservice.service.exception.ServiceException;
import main.com.bsuir.autoservice.service.unitOfWork.IServiceUnitOfWork;

public class AddBeanCommand implements ICommand<BeanAddPageInfo, BeanAddPageInfo>{

    @Inject
    public AddBeanCommand(IServiceUnitOfWork serviceUnitOfWork, IDatabaseMap databaseMap){
        this.serviceUnitOfWork = serviceUnitOfWork;
        this.databaseMap = databaseMap;
    }

    @Override
    public BeanAddPageInfo execute(BeanAddPageInfo crudPageInfo) throws CommandException{
        try {
            IServiceCrud serviceCrud = serviceUnitOfWork.getServiceCrudForBean(crudPageInfo.tableName);
            Bean bean = databaseMap.getBeanInstance(crudPageInfo.tableName, crudPageInfo.fields);
            serviceCrud.create(bean);
            crudPageInfo.result = "Operation success";
            return crudPageInfo;
        }catch (ServiceException | BeanException e){
            //log
            crudPageInfo.result = String.format(
                    "Failed to add new '%s': %s.",
                    crudPageInfo.tableName,
                    ExceptionUnwrapper.getRootException(e).getMessage()
            );
            return crudPageInfo;
        }catch (Exception e){
            throw new CommandException(e);
        }
    }

    private final IServiceUnitOfWork serviceUnitOfWork;
    private final IDatabaseMap databaseMap;
}
