package cn.lexiang.singleservice.service.a.service;

import cn.lexiang.singleservice.bean.service.Service;

public interface ServiceService {
    public Service login(Service service);

    public Service getUserinfoByid(Service service);
}
