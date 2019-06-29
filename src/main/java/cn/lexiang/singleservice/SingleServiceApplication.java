package cn.lexiang.singleservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Qfeng
 * @Date 2019-05-23 15:52:14
 */
@SpringBootApplication
@MapperScan("cn.lexiang.singleservice.mapper")
public class SingleServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SingleServiceApplication.class, args);
    }
}
