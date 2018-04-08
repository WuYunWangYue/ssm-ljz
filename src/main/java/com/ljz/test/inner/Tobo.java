package com.ljz.test.inner;

public class Tobo {
    private int size = 5, y = 7;

    public Object makeInner(int localVar) {
        /*
         *
         * 按理说局部内部类访问局部变量,局部变量应该用final修饰,但是不用final修饰也是可以访问的,
         * 这是因为在JDK8以下必须用final修饰,不然会报错,
         * Cannot refer to a non-final variable a inside an inner class defined in a different method,
         * 但是在JDK8之后就不会出现这种状况
         *
         * */
//        final int finalLocalVar = localVar;

        //创建内部类，该类只在makeInner（）方法有效，就像局部变量一样。在方法体外部不能创建MyInner类的对象
        class MyInner {
            int y = 4;

            public String toString() {
                return "OuterSize:" + size +
                        "\nfinalLocalVar : " + localVar +
                        "\nthis.y : " + this.y;
            }
        }
        return new MyInner();

    }
}

class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

        Object obj = new Tobo().makeInner(47);//创建Tobo对象obj，并调用它的makeInner（）方法，该方法返回一个
        //该方法返回一个MyInner类型的的对象obj，然后调用其同toString方法。
        System.out.println(obj.toString());
        // TODO Auto-generated method stub

    }


}  