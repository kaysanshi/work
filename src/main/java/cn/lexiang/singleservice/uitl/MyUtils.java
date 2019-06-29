package cn.lexiang.singleservice.uitl;



import cn.lexiang.singleservice.bean.QueryVo;
import cn.lexiang.singleservice.bean.Result;
import cn.lexiang.singleservice.bean.user.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Qfeng
 * @Date 2019-03-24 21:17:11
 */
public class MyUtils {

//    public static void main(String[] args) {
//        System.out.println(MyUtils.UUID());
//    }

    public static User user(HttpServletRequest request) {
        return (User) request.getAttribute("user");
    }

    public static String UUID(int machineId) {
        //        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return (String.format("%02d", machineId) + String.format("%09d", hashCodeV)).substring(0, 11);
    }

    public static String code() {
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        return String.format("%09d", hashCodeV).substring(0, 9);
    }

    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x - forwarded - for");
        if (ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("Proxy - Client - IP");
        if (ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("WL - Proxy - Client - IP");
        if (ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip))
            ip = request.getRemoteAddr();
        return ip;
    }

    /**
     * 异常处理
     * @param e
     * @return
     */
    public static Result handlerException(Exception e) {
        e.printStackTrace();
        return Result.createResult(Result.CODE_EXCEPTION, e.getMessage().toString(), null);
    }

    public static void initQueryVo(QueryVo queryVo) {
        if (queryVo.getPage() == null)
            queryVo.setPage(1);
        if (queryVo.getLimit() == null)
            queryVo.setLimit(10);
    }
    public static void calcStart(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getLimit());
    }

    public static void initAndCalcStart(QueryVo queryVo) {
        initQueryVo(queryVo);
        calcStart(queryVo);
    }

    public static boolean isAuth(String json) throws Exception {
        if (json == null || json.equals("null"))
            return false;
        System.out.println("json: " + json);
        Map resmap = MapperUtils.json2map(json);

        if (resmap == null || resmap.get("code").toString().equals(Result.CODE_FAIL))
            return false;
        Map map = (Map) resmap.get("data");
        System.out.println(map);
        if (map.get("role") == null || Integer.parseInt(map.get("role").toString()) != 2)
            return false;
        return true;
    }

    public static boolean isAuth(User user) {
        if (user == null)
            return false;
        if (user.getRole() == null || user.getRole() != 2)
            return false;
        return true;
    }

    public static String mapValue(Map map, String key) {
        if (map.get(key) == null)
            return null;
        return map.get(key).toString();
    }

    public static Integer stirngToInteger(String s) {
        if (s == null || s.equals("null") || s.isEmpty())
            return null;
        return Integer.parseInt(s);
    }

    public static Date stringToDate(String s) throws ParseException {
        if (s == null || s.equals("null") || s.isEmpty())
            return null;
        SimpleDateFormat simpleDateFormat =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(s);
    }

    public static Double stringToDouble(String s) {
        if (s == null || s.equals("null") || s.isEmpty())
            return null;
        return Double.parseDouble(s);
    }


    public static String now() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
