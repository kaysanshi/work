package cn.lexiang.singleservice.uitl;

import cn.lexiang.singleservice.bean.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;

/**
 * @Author Qfeng
 * @Date 2019-03-28 15:58:47
 */
public class TokenUtils {
    public static String getToken(User user) throws UnsupportedEncodingException {
        String token = "";
        token = JWT.create().withAudience(user.getUsername()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
