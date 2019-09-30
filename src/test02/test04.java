package test02;

public class test04 {//值传递

    String str = new String("good");
     char[] ch = { 'a', 'b', 'c' };

             public static void main(String args[]) {
                 test04 ex = new test04();
                ex.change(ex.str, ex.ch);
                System.out.print(ex.str + " and ");
                System.out.print(ex.ch);
            }

            public void change(String str, char ch[])
   {
                str = "test ok";//相当于str=new String("test ok"),str的内存地址变成new之后的String("test ok")的新地址
                                // 所以main中的ex.str内存存的还是旧地址，所以不变
                ch[0] = 'g';
             }
}
