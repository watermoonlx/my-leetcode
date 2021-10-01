package playground.验证构造器执行顺序;

public class Parent extends Grandfather {
    static {
        System.out.println("静态构造器：Parent");
    }

    {
        System.out.println("实例初始化块：Parent");
    }

    public Parent() {
        System.out.println("实例构造器：Parent");
    }

}
