package cn.lexiang.singleservice.interceptor;

import cn.lexiang.singleservice.bean.Result;
import cn.lexiang.singleservice.uitl.HttpUtil;
import cn.lexiang.singleservice.uitl.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Qfeng
 * @Date 2019-05-15 18:48:16
 */
@Component
@CrossOrigin
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
//
//    @Autowired
//    private SsoService ssoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug(" 收到来自IP: " + MyUtils.getIP(request) + "的请求, 请求路径: " + request.getRequestURI());

        //过滤图片
        if (request.getRequestURI().startsWith("/img/")) {
            return true;
        }

//        //放行URL
//        if (UrlConfig.urls.contains(request.getRequestURI())) {
//            return true;
//        }

//        //处理token
//        String token = request.getParameter("token");
//        if (StringUtils.isEmpty(token)) {
//            HttpUtil.responseToJson(response, Result.createResult(Result.CODE_AUTH_FAIL, "没有口令", null));
//            logger.debug("没有口令");
//            return false;
//        }
//        logger.debug("token: " + token);
//        User user = ssoService.isLogin(token);
//        if (user == null) {
//            HttpUtil.responseToJson(response, Result.createResult(Result.CODE_AUTH_FAIL, "未登录", null));
//            logger.debug("未登录");
//            return false;
//        }
//        logger.debug("user===>" + user);
//        request.setAttribute("user", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
