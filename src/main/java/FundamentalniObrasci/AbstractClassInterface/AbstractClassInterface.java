package FundamentalniObrasci.AbstractClassInterface;


interface Interfacee{
    public void start();
    public void end();
}

abstract class AbstractClass implements Interfacee{
    public void start(){
        System.out.println("Abstract Class starts something!\n");
    }

    public void end(){
        System.out.println("Abstract Class ends something! \n");
    }
}

class ConcreteClassA extends AbstractClass{

    public void start(){
        System.out.println("ConcreteClassA starts something!\n");
    }

    public void end(){
        System.out.println("ConcreteClassA ends something! \n");
    }
}
class ConcreteClassB extends AbstractClass{

//    public void start(){
//        System.out.println("ConcreteClassB starts something!\n");
//    }
//
//    public void end(){
//        System.out.println("ConcreteClassB ends something! \n");
//    }
}

public class AbstractClassInterface {

    public static void main(String[] args) {
        AbstractClass temp = new ConcreteClassA();

        temp.start();
        temp.end();

        temp = new ConcreteClassB();
        temp.start();
        temp.end();



    }


}
