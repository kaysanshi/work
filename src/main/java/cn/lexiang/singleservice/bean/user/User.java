package cn.lexiang.singleservice.bean.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author Qfeng
 * @Date 2019-03-28 12:03:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors( chain = true )
public class User {
    private Integer id;
    private String email;
    private String username;
    private String nick;
    private String summary;
    private String headimg;
    private Integer age;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date regtime;
    private String regip;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date logintime;
    private String loginip;
    private Integer isservice;
    private Integer role;
    private Double balance;
    private Integer status;
    private String addcode;

    private String vercode;



//    private List<ServiceCategory> serviceCategoryList;


    private Integer isLink;

}
