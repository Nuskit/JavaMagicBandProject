package main.com.bsuir.autoservice.service.impl;

import main.com.bsuir.autoservice.bean.impl.order;
import main.com.bsuir.autoservice.bean.impl.service;
import main.com.bsuir.autoservice.command.param.MechanicViewOrdersInfo;
import main.com.bsuir.autoservice.service.IServiceCrud;
import main.com.bsuir.autoservice.service.exception.ServiceException;

import java.util.List;


public interface IOrderService extends IServiceCrud<Integer, order> {
    boolean makeOrder(Integer userId, List<service> orderServices) throws ServiceException;
    List<order> getUserOrders(int userId, int currentGroup, int elementCount) throws ServiceException;
    List<order> getOrderServices(Integer userId, int detailOrderId) throws ServiceException;
    List<order> getServiceShopOrders(int staffId, MechanicViewOrdersInfo.SortedType orderSortType,
                                     int orderPage, int orderCount) throws ServiceException;
    boolean changeOrderState(int changedStaffId, int orderId, order.State newOrderState) throws ServiceException;
    boolean addOrderNotification(int staffWriterId, int orderId, String notificationMessage) throws ServiceException;
}
