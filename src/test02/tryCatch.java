package test02;

public class tryCatch {


        public static void main(String[] args) {
            System.out.println(test());
        }
        private static int test() {
            int b = 10;
            try{
                System.out.println("try:");
                b+=10;
                throw new Exception();
            }catch(Exception e){
                System.out.println("error:"+e);
                b+=20;
                System.out.println(b);
            }finally{
                System.out.println("finally:");
                b+=10;
                System.out.println(b);
            }
            return b;
        }


}
