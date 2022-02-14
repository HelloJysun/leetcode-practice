package com.jysun.practice.offer2;

/**
 * 实现单例模式
 *
 * @author json
 * @since 2022/2/14
 */
public class Practice2 {
    public static void main(String[] args) {

    }

    /**
     * 饿汉式：加载class即初始化单例对象
     */
    public static class Singleton1 {
        /**
         * 1、单例必备，防止new创建多个对象
         */
        private Singleton1() {

        }

        // static变量，加载class即初始化
        private static final Singleton1 INSTANCE = new Singleton1();

        /**
         * 提供外部访问单例的静态方法
         *
         * @return singleton
         */
        public static Singleton1 getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 懒汉式：只有第一次调用才初始化返回
     * 单线程环境不考虑并发，多线程考虑并发可用synchronized关键字确保线程安全
     */
    public static class Singleton2 {
        /**
         * 1、单例必备，防止new创建多个对象
         */
        private Singleton2() {

        }

        // static变量
        private volatile static Singleton2 INSTANCE;

        /**
         * DCL: double check lock双重校验锁
         * 外层if判断添加可提高并发，如果去掉外层if那么每次获取都会加锁
         * 添加外层if可确保单例初始化后续不用再加锁
         * 内层if不能去掉，因为如果同时多个线程进入synchronized同步块时，其中一个线程初始化完成后，其他线程获取到锁再次进入会重新初始化无法确保单例
         * 考虑到java存在指令重排序，INSTANCE = new Singleton()操作不是原子操作
         * 1、给INSTANCE引用分配内存
         * 2、调用构造函数在堆内存初始化对象
         * 3、将INSTANCE引用指向堆内存初始化好的对象
         * 但是23步骤有可能会被指令重排序，导致3在2前那么多线程环境下就有可能导致INSTANCE已经非null，但实际对象还没有实例化出来
         * 其他线程在走外层if判null时直接return INSTANCE返回一个未初始化好的单例而使用报错
         * 可以在INSTANCE使用volatile关键字确保其不使用指令重排序
         * 这主要借助于内存屏障实现的：按照happens-before原则，变量的写操作先行发生于后边这个变量的读操作
         *
         * @return singleton
         */
        public static Singleton2 getInstance() {
            if (INSTANCE == null) {
                synchronized (Singleton2.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new Singleton2();
                    }
                }
            }
            return INSTANCE;
        }
    }

    /**
     * 静态内部类：Effective Java推荐写法，不依赖于JDK，volatile依赖于JDK1.5之后版本
     * 确保了线程安全，还是懒汉式的，和1不同在于使用了一个静态内部类包裹了单例，确保了只有在第一次调用SingletonHolder才会初始化INSTANCE
     * 性能、安全、不依赖JDK版本
     */
    public static class Singleton3 {
        private Singleton3() {

        }
        private static class SingletonHolder {
            private static final Singleton3 INSTANCE = new Singleton3();
        }

        public static Singleton3 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 枚举：天然线程安全
     * 第一次调用枚举时，才会被JVM加载进堆里，初始化过程线程安全由JVM控制
     * 上述几种方式都是通过代码控制确保线程安全，但序列化后的对象再次反序列化时会调用默认构造函数来初始化对象
     * 即使我们定义了private不允许手动new对象，但反序列化不受影响，依然可以new对象，这就破坏了单例
     * 而枚举类型序列化时Java仅仅将枚举的name输出，反序列化时通过Enum.valueOf根据name查找枚举对象
     * 同时编译器不允许反序列化定制，禁用了writeObject、readObject、readResolve等方法
     * 普通类反序列化通过反射调用默认构造函数初始化对象，枚举反序列化不是通过反射实现的
     * 枚举类型编译后其实是一个 final class T extends Enum，枚举项也会被加以public static final T修饰
     * 这就确保了枚举第一次被调用时，会被当作静态类进行初始化，并且初始化所有静态资源，静态类的加载和初始化都是线程安全的
     * 使用ClassLoader.loadClass方法来加载类，方法中使用synchronized同步代码块确保线程安全
     */
    public enum Singleton4 {
        INSTANCE;
    }
}
