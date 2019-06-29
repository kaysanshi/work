package cn.lexiang.singleservice.service.impl.service;

import cn.lexiang.singleservice.bean.service.ServiceCategory;
import cn.lexiang.singleservice.bean.service.ServiceOrder;
import cn.lexiang.singleservice.bean.service.ServiceOrderQueryVo;
import cn.lexiang.singleservice.mapper.service.ServiceOrderMapper;
import cn.lexiang.singleservice.service.a.service.ServiceOrderService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Qfeng
 * @Date 2019-05-23 16:12:45
 */
@Service
@Transactional
public class ServiceOrderServiceImpl implements ServiceOrderService {

    @Autowired
    private ServiceOrderMapper serviceOrderMapper;

    @Override
    public ServiceOrder detailOrder(ServiceOrder serviceOrder) {
        return  serviceOrderMapper.detailOrder(serviceOrder);
    }

    @Override
    public boolean orderReport(ServiceOrder serviceOrder) {
        serviceOrder.setEndTime(new Date());
        return serviceOrderMapper.fillOrder(serviceOrder);
    }

    @Override
    public boolean reactOrder(ServiceOrder serviceOrder) {
        serviceOrder.setStartTime(new Date());
        System.out.print(serviceOrder.getStartTime());
        int res = serviceOrderMapper.updateOrder(serviceOrder);
        System.out.println(res);
        if (res > 0)
            return true;
        return false;
    }

    @Override
    public List<ServiceOrder> listHistoryOrder(ServiceOrder serviceOrder) {
        return serviceOrderMapper.listHistoryOrder(serviceOrder);
    }

    @Override
    public ServiceOrder historyOrderDetail(ServiceOrder serviceOrder) {
        return  serviceOrderMapper.detailOrder(serviceOrder);
    }

    @Override
    public List<ServiceCategory> getCatoryName(List<Integer> list) {
        return serviceOrderMapper.getCatoryName(list);
    }

    @Override
    public List<ServiceOrder> list(ServiceOrderQueryVo serviceOrderQueryVo) {
        return serviceOrderMapper.list(serviceOrderQueryVo);
    }

    @Override
    public int listSum(ServiceOrderQueryVo serviceOrderQueryVo) {
        return serviceOrderMapper.listSum(serviceOrderQueryVo);
    }
}
