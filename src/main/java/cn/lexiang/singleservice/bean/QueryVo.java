package cn.lexiang.singleservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author Qfeng
 * @Date 2019-03-26 10:36:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors( chain = true )
public class QueryVo {
    private Integer page;
    private Integer limit;
    private String key;
    private Integer start;
}
