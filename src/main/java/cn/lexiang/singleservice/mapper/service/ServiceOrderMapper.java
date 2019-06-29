package cn.lexiang.singleservice.mapper.service;

import cn.lexiang.singleservice.bean.service.ServiceCategory;
import cn.lexiang.singleservice.bean.service.ServiceOrder;
import cn.lexiang.singleservice.bean.service.ServiceOrderQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Qfeng
 * @Date 2019-05-23 16:35:21
 */
@Repository
public interface ServiceOrderMapper {
    public List<ServiceOrder> list(ServiceOrderQueryVo serviceOrderQueryVo);

    public ServiceOrder detailOrder(ServiceOrder serviceOrder);

    public boolean fillOrder(ServiceOrder serviceOrder);

    public int updateOrder(ServiceOrder serviceOrder);

    public List<ServiceOrder> listHistoryOrder(ServiceOrder serviceOrder);

    public int listSum(ServiceOrderQueryVo serviceOrderQueryVo);

    public List<ServiceCategory> getCatoryName(List<Integer> list);
}
