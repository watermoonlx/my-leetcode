package playground.验证构造器执行顺序;

public class Test {
    public static void main(String[] args) {
        System.out.println("Start");
        Son son = new Son();
        System.out.println("Done");
    }
}
