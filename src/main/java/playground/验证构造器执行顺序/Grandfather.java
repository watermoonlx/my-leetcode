package playground.验证构造器执行顺序;

public class Grandfather {
    static {
        System.out.println("静态构造器：Grandfather");
    }

    {
        System.out.println("实例初始化块：Grandfather");
    }

    public Grandfather() {
        System.out.println("实例构造器：Grandfather");
    }
}
