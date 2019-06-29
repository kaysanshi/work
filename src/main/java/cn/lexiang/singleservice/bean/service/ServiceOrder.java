package cn.lexiang.singleservice.bean.service;

import cn.lexiang.singleservice.bean.user.User;
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
 * @Date 2019-03-29 16:40:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors( chain = true )
public class ServiceOrder {
    private String id;
    private String summary;
    private Integer categoryid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date time;
    private Double price;
    private String usercomment;
    private String servicecomment;
    private String report;
    private Integer userid;
    private Integer serviceid;
    private Integer consumeid;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date endTime;
    private Integer status;
    private Integer type;
    private String servicetimejson;

    private Integer level;
    private String categoryname;


    private User consumer;
    private User user;
    private Service service;
    private ServiceCategory serviceCategory;

    private String servicejson;
    private String consumersummary;
    private String consumername;
    private String userheadimg;

}
