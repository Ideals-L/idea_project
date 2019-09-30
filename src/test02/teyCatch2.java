package test02;

public class teyCatch2 {
    public static void main(String[] args) {
        System.out.println(testReturn4());
    }
    private static int testReturn4() {//这里是静态方法原因是main也是静态方法，所以可以直接调用这个静态方法，
        // 非静态方法要声明对象才能调用
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int x = i / 0 ;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;//return 前会执行finally语句，但是相当于复制副本i执行finally，不影响这里的实参
                     // 如果这里不是基本类型，是对象引用类型的话，那么复制的副本指向同一个地址，则会改变到实参的值
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;//实参i

    }
}