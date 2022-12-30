package KreacioniObrasci.AbstractFactory;

abstract class Creator {
    public Product1 createProduct1() {
        return null;
    }

    public Product2 createProduct2(){
        return null;
    }
}

interface Product1 {
    void methodP11();
}
interface Product2 {
    void methodP21();
    void methodP22();
}

class Product1ImplA implements Product1{
    @Override
    public void methodP11() {
        System.out.println("Product1 implementation A methodP11");
    }
}
class Product1ImplB implements Product1{
    @Override
    public void methodP11() {
        System.out.println("Product1 implementation B methodP11");
    }
}
class Product2ImplA implements Product2{

    @Override
    public void methodP21() {
        System.out.println("Product2 implementation A methodP21");
    }

    @Override
    public void methodP22() {
        System.out.println("Product2 implementation A methodP22");
    }
}
class Product2ImplB implements Product2{

    @Override
    public void methodP21() {
        System.out.println("Product2 implementation B methodP21");
    }

    @Override
    public void methodP22() {
        System.out.println("Product2 implementation B methodP22");
    }
}


class ConcreteCreatorA extends Creator{
    @Override
    public Product1 createProduct1() {
        return new Product1ImplA();
    }
    @Override
    public Product2 createProduct2(){
        return new Product2ImplA();
    }
}
class ConcreteCreatorB extends Creator{
    @Override
    public Product1 createProduct1() {
        return new Product1ImplB();
    }
    @Override
    public Product2 createProduct2(){
        return new Product2ImplB();
    }
}


public class AbstractFactory {

    private Creator[] creators;

    public AbstractFactory(Creator[] c) {
        super();
        this.creators = c;
    }

    public void createAndUseProducts(){
        System.out.println("Created Products:\n");
        for(Creator creator: creators){
            System.out.println("=======" + creator.getClass()+ "=========");
            Product1 product1 = creator.createProduct1();
            Product2 product2 = creator.createProduct2();

            product1.methodP11();
            product2.methodP21();
            product2.methodP22();
            System.out.println("====================================\n");
        }

    }

    public static void main(String[] args) {
        Creator[] creators = new Creator[2];

        creators[0] = new ConcreteCreatorA();
        creators[1] = new ConcreteCreatorB();

        AbstractFactory test = new AbstractFactory(creators);
        test.createAndUseProducts();

    }
}
