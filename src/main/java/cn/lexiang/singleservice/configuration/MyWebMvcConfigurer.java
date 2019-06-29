package cn.lexiang.singleservice.configuration;

import cn.lexiang.singleservice.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author Qfeng
 * @Date 2019-05-19 22:24:22
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurationSupport {

    @Autowired
    private LogInterceptor logInteceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInteceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(UploadConfig.IMG_URL + "**").addResourceLocations("file:" + UploadConfig.IMG_PATH);
//        registry.addResourceHandler(UploadConfig.TTS_URL + "**").addResourceLocations("file:" + UploadConfig.TTS_PATH);
        super.addResourceHandlers(registry);
    }
}
