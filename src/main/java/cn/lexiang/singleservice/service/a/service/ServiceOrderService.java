package cn.lexiang.singleservice.service.a.service;

import cn.lexiang.singleservice.bean.service.ServiceCategory;
import cn.lexiang.singleservice.bean.service.ServiceOrder;
import cn.lexiang.singleservice.bean.service.ServiceOrderQueryVo;

import java.util.List;

public interface ServiceOrderService {
    public ServiceOrder detailOrder(ServiceOrder serviceOrder);

    public boolean orderReport(ServiceOrder serviceOrder);

    public boolean reactOrder(ServiceOrder serviceOrder);

    public List<ServiceOrder> listHistoryOrder(ServiceOrder serviceOrder);

    public ServiceOrder historyOrderDetail(ServiceOrder serviceOrder);

    public List<ServiceCategory> getCatoryName(List<Integer> list);

    public List<ServiceOrder> list(ServiceOrderQueryVo serviceOrderQueryVo);

    public int listSum(ServiceOrderQueryVo serviceOrderQueryVo);
}
