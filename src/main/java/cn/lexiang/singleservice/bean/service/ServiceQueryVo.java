package cn.lexiang.singleservice.bean.service;

import cn.lexiang.singleservice.bean.QueryVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author Qfeng
 * @Date 2019-04-08 10:50:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors( chain = true )
public class ServiceQueryVo extends QueryVo {
    private Integer start;
    private Integer limit;
    private Integer page;
    private String key;
    private Integer sort;
    private Integer ages;
    private Integer agem;
    private Integer gender;
}
