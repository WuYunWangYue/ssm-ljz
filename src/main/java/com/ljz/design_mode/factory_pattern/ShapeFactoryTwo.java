package com.ljz.design_mode.factory_pattern;

//使用反射机制可以解决每次增加一个产品时，都需要增加一个对象实现工厂的缺点
public class ShapeFactoryTwo {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
