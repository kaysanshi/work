package cn.lexiang.singleservice.bean.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author Qfeng
 * @Date 2019-04-08 10:50:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors( chain = true )
public class Service {
    private Integer id;
    private String username;
    private String realname;
    private String nick;
    private String password;
    private String headimg;
    private Integer age;
    private Integer gender;
    private String summary;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date regTime;
    private String regIp;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date loginTime;
    private String loginIp;
    private Integer userid;
    private Integer role;
    private String address;
    private Integer serviceStatus;
    private Integer status;
    private String phone;

    /**
     * 服务订单总数
     */
    private Integer ordersum;

    /**
     * 好评率
     */
    private Integer avglevel;

    /**
     * 申请id
     */
    private Integer applyid;

    /**
     * 表示是否关注
     */
    private Integer isStar;

    /**
     * 服务类别的子集
     */
    private List<ServiceCategory> serviceCategoryList;

    /**
     * 服务前10个订单
     */
    private List<ServiceOrder> serviceOrderList;


}
