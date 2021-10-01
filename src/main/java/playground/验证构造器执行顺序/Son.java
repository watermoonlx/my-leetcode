package playground.验证构造器执行顺序;

public class Son extends Parent {
    static {
        System.out.println("静态构造器：Son");
    }

    {
        System.out.println("实例初始化块：Son");
    }

    public Son() {
        System.out.println("实例构造器：Son");
    }
}
