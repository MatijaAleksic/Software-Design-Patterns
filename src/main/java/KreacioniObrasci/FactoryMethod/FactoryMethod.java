package KreacioniObrasci.FactoryMethod;

interface Creator {
    Product factoryMethod();
}
interface Product {
    String who();
}

class ConcreteCreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
class ConcreteCreatorB implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

class ConcreteProductA implements Product {
    @Override
    public String who() {
        return "Product A";
    }
}
class ConcreteProductB implements Product {
    @Override
    public String who() {
        return "Product B";
    }
}

public class FactoryMethod {

    private Creator[] creators;

    public FactoryMethod(Creator[] c) {
        super();
        this.creators = c;
    }

    public void createAndUseProducts(){
        System.out.println("Created Products:");
        for(Creator creator: creators){
            Product product = creator.factoryMethod();
            System.out.println(product.who());
        }

    }

    public static void main(String[] args) {
        Creator[] creators = new Creator[2];

        creators[0] = new ConcreteCreatorA();
        creators[1] = new ConcreteCreatorB();

        FactoryMethod test = new FactoryMethod(creators);
        test.createAndUseProducts();

    }
}


