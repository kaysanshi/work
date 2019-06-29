package cn.lexiang.singleservice.uitl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Qfeng
 * @Date 2019-04-14 11:41:49
 */
public class DateUtils {
    public static String dateFormat(String pattern, Date date) {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String dateFormat(String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }

    public static Date str2dateFormat(String str, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat( pattern);
        return sdf.parse(str);
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.dateFormat("yyyyMMddHHmmss"));
    }
}
