package main.com.bsuir.autoservice.service.impl.order.impl;

import main.com.bsuir.autoservice.bean.Order;
import main.com.bsuir.autoservice.dao.unitOfWork.IDaoUnitOfWork;
import main.com.bsuir.autoservice.service.impl.crud.AbstractServiceCrud;
import main.com.bsuir.autoservice.service.impl.order.IOrderService;

public class OrderService extends AbstractServiceCrud<Integer,Order> implements IOrderService {
    private final IDaoUnitOfWork daoUnitOfWork;

    public OrderService(IDaoUnitOfWork daoUnitOfWork) {
        super(daoUnitOfWork.getOrderDao());
        this.daoUnitOfWork = daoUnitOfWork;
    }
}
