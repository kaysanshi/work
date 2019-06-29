package cn.lexiang.singleservice.controller;

import cn.lexiang.singleservice.bean.Result;
import cn.lexiang.singleservice.bean.service.Service;
import cn.lexiang.singleservice.service.a.service.ServiceService;
import cn.lexiang.singleservice.service.a.sso.SsoService;
import cn.lexiang.singleservice.uitl.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kay三石
 */
@RestController
@RequestMapping("/api/service/sso")
public class ServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    private ServiceService serviceService;

    /**
     * 登录
     * @param service
     * @return
     */
    @PostMapping("/login")
    public Result login(Service service){
        try {
            logger.debug("login");
            if (service.getUsername() != null && service.getPassword() != null) {
                return Result.success(serviceService.login(service));
            }else{
                return Result.createResult(Result.CODE_FAIL,"未能成功登录","null");
            }
        } catch (Exception e) {
            return MyUtils.handlerException(e);
        }

    }

    /**
     * 获得服务者的信息
     * @param service
     * @return
     */
    @PostMapping("/getUserinfo")
    public Result getUserinfoByid(Service service){
        try {
            if (service.getId()!=null){
                return Result.success(serviceService.getUserinfoByid(service));
            }else {
                return Result.createResult(Result.CODE_FAIL,"未能成功获取","null");
            }
        } catch (Exception e) {
            return MyUtils.handlerException(e);
        }

    }
}
