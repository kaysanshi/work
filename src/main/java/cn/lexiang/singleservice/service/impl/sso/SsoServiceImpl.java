package cn.lexiang.singleservice.service.impl.sso;

import cn.lexiang.singleservice.bean.user.User;
import cn.lexiang.singleservice.service.a.sso.SsoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Qfeng
 * @Date 2019-05-23 16:01:26
 */
@Service
@Transactional
public class SsoServiceImpl implements SsoService {
    @Override
    public String login(User user) throws Exception {
        return null;
    }

    @Override
    public String login(cn.lexiang.singleservice.bean.service.Service service) throws Exception {
        return null;
    }

    @Override
    public User isLogin(String token) throws Exception {
        return null;
    }

    @Override
    public boolean send(User user) throws Exception {
        return false;
    }

    @Override
    public String getcode(User user) {
        return null;
    }

    @Override
    public String register(User user) throws Exception {
        return null;
    }

    @Override
    public cn.lexiang.singleservice.bean.service.Service getUserinfoByid(cn.lexiang.singleservice.bean.service.Service service) {
        return null;
    }
}
