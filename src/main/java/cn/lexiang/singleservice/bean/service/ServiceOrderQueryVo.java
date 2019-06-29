package cn.lexiang.singleservice.bean.service;

import cn.lexiang.singleservice.bean.QueryVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author Qfeng
 * @Date 2019-03-29 16:40:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors( chain = true )
public class ServiceOrderQueryVo extends QueryVo {
    private Integer status;
    private Integer categoryid;
    private Integer userid;
    private Integer serviceid;
    private Integer consumeid;

    //
    private Integer userconsume;



}
