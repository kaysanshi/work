package cn.lexiang.singleservice.bean.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Objects;

/**
 * @Author Qfeng
 * @Date 2019-03-29 16:56:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors( chain = true )
public class ServiceCategory {
    private Integer id;
    private String name;
    private Double price;
    private Integer pid;
    private Integer status;
    private Integer type;

    private List<ServiceCategory> subList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceCategory that = (ServiceCategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(status, that.status);
//                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, pid, status);
    }
}
