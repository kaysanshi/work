package cn.lexiang.singleservice.service.impl.service;

import cn.lexiang.singleservice.bean.service.Service;
import cn.lexiang.singleservice.mapper.service.ServiceMapper;
import cn.lexiang.singleservice.service.a.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Qfeng
 * @Date 2019-05-23 16:26:43
 */
@org.springframework.stereotype.Service
@Transactional
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public Service login(Service service) {
        return serviceMapper.login(service);
    }

    @Override
    public Service getUserinfoByid(Service service) {
        return serviceMapper.findById(service);
    }
}
