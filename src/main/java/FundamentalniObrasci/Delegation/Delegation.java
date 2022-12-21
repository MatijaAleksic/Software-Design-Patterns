package FundamentalniObrasci.Delegation;

interface Interfacee {
    void fun1();
    void fun2();
}
class A implements Interfacee {
    public void fun1() { System.out.println("A: doing f()"); }
    public void fun2() { System.out.println("A: doing g()"); }
}
class B implements Interfacee {
    public void fun1() { System.out.println("B: doing f()"); }
    public void fun2() { System.out.println("B: doing g()"); }
}

class C implements Interfacee {
    // delegation
    Interfacee i = new A();

    public void fun1() { i.fun1(); }
    public void fun2() { i.fun2(); }

    // normal attributes
    public void toA() { i = new A(); }
    public void toB() { i = new B(); }
}

public class Delegation {
    public static void main(String[] args) {
        C c = new C();

        c.fun1();
        c.fun2();

        c.toB();

        c.fun1();
        c.fun2();
    }
}