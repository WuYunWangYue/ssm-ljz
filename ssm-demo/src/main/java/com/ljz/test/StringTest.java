package com.ljz.test;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "abcd";

        String str2 = "abcd";

        String str3 = new String("abcd");

        String str4 = new String("abcd");

        String str5 = new String("ljz");
        String str6 = "ljz";


        System.out.println(str1 == str2);//true地址一样

        System.out.println(str1 == str3);//false,但地址不一样
        System.out.println(str3 == str4);//false,但地址不一样
        System.out.println(str5 == str6);//false,但地址不一样

        System.out.println(str3.equals(str3));//true,值一样

        System.out.println(str2.equals(str3));//true,值一样

        System.out.println((str1 + "a") == (str2 + "a"));//false;进行了+连接地址不一样
    }
}
