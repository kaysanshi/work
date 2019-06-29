package cn.lexiang.singleservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author Qfeng
 * @Date 2019-03-24 16:31:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors( chain = true )
public class Result implements Serializable {

    public static final String CODE_SUCCESS = "0";
    public static final String CODE_FAIL  = "1";
    public static final String CODE_EXCEPTION = "-1";
    public static final String CODE_BAD = "-2";
    public static final String CODE_AUTH_FAIL = "-3";

    public static final String MSG_SUCCESS = "操作成功";
    public static final String MSG_FAIL = "操作失败";
    public static final String MSG_EXCEPTION = "发生异常";
    public static final String MSG_BAD = "请求失败，请重试";
    public static final String MSG_AUTH_FAIL = "没有权限";

    private String code;
    private String msg;
    private Object data;
    private Integer count;
    private String desc;
    private Integer flag;

    /**
     * 为了兼容wangEditor
     */
    private String errno;

    /**
     * 为了兼容Eleditor
     */
    private String status;
    private String url;

    public static Result success() {
        return createResult(Result.CODE_SUCCESS, Result.MSG_SUCCESS, null);
    }
    public static Result success(Object data) {
        return createResult(Result.CODE_SUCCESS, Result.MSG_SUCCESS, data);
    }

    public static Result exception() {
        return createResult(Result.CODE_EXCEPTION, Result.MSG_EXCEPTION, null);
    }
    public static Result exception(Object data) {
        return createResult(Result.CODE_EXCEPTION, Result.MSG_EXCEPTION, data);
    }

    public static Result fail() {
        return createResult(Result.CODE_FAIL, Result.MSG_FAIL, null);
    }
    public static Result fail(Object data) {
        return createResult(Result.CODE_FAIL, Result.MSG_FAIL, data);
    }

    public static Result bad() {
        return Result.createResult(Result.CODE_BAD, Result.MSG_BAD, null);
    }
    public static Result bad(Object data) {
        return Result.createResult(Result.CODE_BAD, Result.MSG_BAD, data);
    }

    public static Result authFail() {
        return Result.createResult(Result.CODE_AUTH_FAIL, Result.MSG_AUTH_FAIL, null);
    }
    public static Result authFail(Object data) {
        return Result.createResult(Result.CODE_AUTH_FAIL, Result.MSG_AUTH_FAIL, data);
    }

    public static Result createResult(String code, String msg, Object data) {
        Result result = new Result();
        return result.setCode(code).setMsg(msg).setData(data);
    }
}
