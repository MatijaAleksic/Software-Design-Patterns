package ObrasciPonasanja.TemplateMethod;


import java.util.Hashtable;

class Computer{

    Hashtable<String, String> computerParts = new Hashtable<String, String>();

    public Computer(Hashtable<String, String> computerParts) {
        this.computerParts = computerParts;
    }

    public Hashtable<String, String> getComputerParts(){
        return this.computerParts;
    }
}

//TEMPLATE OBRAZAC JE OVO
abstract class ComputerBuilder {

    Hashtable<String, String> computerParts = new Hashtable<String, String>();

    public final Computer buildComputer() {
        addMotherboard();
        setupMotherboard();
        addProcessor();
        return new Computer(computerParts);
    }

    public abstract void addMotherboard();
    public abstract void setupMotherboard();
    public abstract void addProcessor();


}

class StandardComputerBuilder extends ComputerBuilder {

    @Override
    public void addMotherboard() {
        computerParts.put("Motherboard", "Standard Motherboard");
    }

    @Override
    public void setupMotherboard() {
        computerParts.put("Motherboard Status", "Screwing the standard motherboard to the case.");
        computerParts.put("Motherboard Status1", "Pluging in the power supply connectors.");
    }

    @Override
    public void addProcessor() {
        computerParts.put("Processor", "Standard Processor");
    }
}

class HighEndComputerBuilder extends ComputerBuilder {

    @Override
    public void addMotherboard() {
        computerParts.put("Motherboard", "High-end Motherboard");
    }

    @Override
    public void setupMotherboard() {
        computerParts.put("Motherboard Status", "Screwing the high-end motherboard to the case.");
        computerParts.put("Motherboard Status1", "Pluging in the power supply connectors.");
    }

    @Override
    public void addProcessor() {
        computerParts.put("Processor", "High-end Processor");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {

        System.out.println("Standard Computer Template Method \n -------------------------------------");
        Computer computer1 = new StandardComputerBuilder().buildComputer();
        Hashtable<String, String> parts1 = computer1.getComputerParts();
        parts1.forEach((k, v) -> System.out.println("Part : " + k + " Value : " + v));


        System.out.println("\nHigh End Computer Template Method \n -------------------------------------");
        Computer computer2 = new HighEndComputerBuilder().buildComputer();
        Hashtable<String, String> parts2 = computer2.getComputerParts();
        parts2.forEach((k, v) -> System.out.println("Part : " + k + " Value : " + v));
    }
}
