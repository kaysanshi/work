package cn.lexiang.singleservice.mapper.service;

import cn.lexiang.singleservice.bean.service.Service;
import org.springframework.stereotype.Repository;

/**
 * @Author Qfeng
 * @Date 2019-05-23 16:29:16
 */
@Repository
public interface ServiceMapper {

    public Service findById(Service service);

    public Service login(Service service);

}
