package main.com.bsuir.autoservice.command.crud.get;

import com.google.inject.Inject;
import main.com.bsuir.autoservice.binding.annotation.Default;
import main.com.bsuir.autoservice.command.ICommand;
import main.com.bsuir.autoservice.command.exception.CommandException;
import main.com.bsuir.autoservice.command.param.CrudPageInfo;
import main.com.bsuir.autoservice.service.unitOfWork.IServiceUnitOfWork;

public class GetBeanEditPageCommand implements ICommand<CrudPageInfo> {

    @Inject
    public GetBeanEditPageCommand(@Default IServiceUnitOfWork serviceUnitOfWork){
        this.serviceUnitOfWork = serviceUnitOfWork;
    }

    @Override
    public CrudPageInfo execute(CrudPageInfo crudPageInfo)
            throws CommandException {
        try {
            crudPageInfo.action = "edit";
            return crudPageInfo;
        }catch (Exception e){
            throw new CommandException(e);
        }
    }

    private final IServiceUnitOfWork serviceUnitOfWork;
}