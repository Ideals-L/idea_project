package test;

public class test01 {

    public static void main(String[] args) {
        System.out.println( titleToNumber("ABC"));
    }
    public static int titleToNumber(String s) {
        if(s.length()==1){
            return s.charAt(0)-'A'+1;//一位数时，charAt(0)是取字符串的第0个字符，减去A的ASCII码，再加1；
        }else{
            int a = s.length();
            int sum = 0;
            for(int i=0;i<a;i++){
                if(i==a-1){
                    sum = sum+(s.charAt(i)-'A')+1;//最后一位，指数取0，直接加字母对应的数字即可
                }else{
                    sum = sum+(int)Math.pow(26,a-i-1)*(s.charAt(i)-'A'+1);//长度对应取26的指数，再乘以字母对应的数字
                }

            }
            return sum;
        }

    }

}
