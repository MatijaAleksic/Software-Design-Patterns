package ObrasciPonasanja.State;

class PackageContext {

    private PackageState state = new OrderedState();

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }

    public PackageState getState() {
        return state;
    }
    public void setState(PackageState state) {
        this.state = state;
    }
}

interface PackageState {
    void next(PackageContext pkg);
    void prev(PackageContext pkg);
    void printStatus();
}

class OrderedState implements PackageState {

    @Override
    public void next(PackageContext pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void prev(PackageContext pkg) {
        System.out.println("The package is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Package ordered, not delivered to the office yet.");
    }
}

class DeliveredState implements PackageState {

    @Override
    public void next(PackageContext pkg) {
        pkg.setState(new ReceivedState());
    }

    @Override
    public void prev(PackageContext pkg) {
        pkg.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package delivered to post office, not received yet.");
    }
}

class ReceivedState implements PackageState {

    @Override
    public void next(PackageContext pkg) {
        System.out.println("This package is already received by a client.");
    }

    @Override
    public void prev(PackageContext pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {

    }
}

public class State {

    public static void main(String[] args) {

        PackageContext pkg = new PackageContext();

        System.out.println(pkg.getState().getClass());  //instanceOf OrderedState);

        pkg.nextState();

        System.out.println(pkg.getState().getClass()); //instanceOf DeliveredState);

        pkg.nextState();

        System.out.println(pkg.getState().getClass()); //instanceOf ReceivedState);
    }
}
