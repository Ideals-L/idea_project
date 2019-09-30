package test02;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test3 {//正则表达式获取身份证年龄

    public static void main(String[] args) {
        System.out.println("年龄："+test3.getAge("440552199307016213"));

    }
    public static int getAge(String idCard) {
        if (idCard == null) {
            return -1;
        }
        Pattern p1 = Pattern.compile("(\\d{6})(\\d{4})"); // 用于提取出生日字符串
        Matcher matcher = p1.matcher(idCard);
        if (matcher.find()) {
            String birth = matcher.group(2);//获取匹配第二组，即出生年份
            Calendar cale = Calendar.getInstance();
            int year = cale.get(Calendar.YEAR);//获取当前年份

            int age=year-Integer.parseInt(birth);//年份相减得到年龄
            return age;
        }
       return -1;
    }
}
