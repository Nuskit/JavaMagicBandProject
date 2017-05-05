package main.com.bsuir.autoservice.service.crud.impl.notifiaction;

import com.google.inject.Inject;
import main.com.bsuir.autoservice.bean.notification;
import main.com.bsuir.autoservice.binding.annotation.Default;
import main.com.bsuir.autoservice.dao.unitOfWork.IDaoUnitOfWork;
import main.com.bsuir.autoservice.service.Dependency;
import main.com.bsuir.autoservice.service.crud.AbstractServiceCrud;
import main.com.bsuir.autoservice.service.crud.exception.ServiceException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationService extends AbstractServiceCrud<Integer, notification> implements INotificationService{

    @Inject
    public NotificationService(@Default IDaoUnitOfWork daoUnitOfWork){
        super(daoUnitOfWork.getNotificationDao());
        this.daoUnitOfWork = daoUnitOfWork;
    }

    @Override
    public List<Dependency> readDependencies(notification bean) throws ServiceException {
        try {
            List<Dependency> dependencies = new ArrayList<>();
            dependencies.addAll(
                    Arrays.asList(

                    )
            );
            return dependencies;
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }

    private IDaoUnitOfWork daoUnitOfWork;
}