package cn.lexiang.singleservice.service.a.sso;

import cn.lexiang.singleservice.bean.service.Service;
import cn.lexiang.singleservice.bean.user.User;

/**
 * @Author
 * @Date 2019-03-28 12:03:00
 */
public interface SsoService {
    public String login(User user) throws Exception;

    public String login(Service service) throws Exception;

    public User isLogin(String token) throws Exception;

    public boolean send(User user) throws Exception;

    public String getcode(User user);

    public String register(User user) throws Exception;

    public Service getUserinfoByid(Service service);

//    public boolean
}
