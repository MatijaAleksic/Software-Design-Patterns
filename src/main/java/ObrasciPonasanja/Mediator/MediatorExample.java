package ObrasciPonasanja.Mediator;

class Mediator {
    private Button button;
    private Fan fan;
    private PowerSupplier powerSupplier;

    public void press() {
        if (fan.isOn()) {
            fan.turnOff();
        } else {
            fan.turnOn();
        }
    }

    public void start() {
        powerSupplier.turnOn();
    }

    public void stop() {
        powerSupplier.turnOff();
    }


    public Mediator() {}

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public PowerSupplier getPowerSupplier() {
        return powerSupplier;
    }

    public void setPowerSupplier(PowerSupplier powerSupplier) {
        this.powerSupplier = powerSupplier;
    }
}

class PowerSupplier {
    public void turnOn() {
        // implementation
    }

    public void turnOff() {
        // implementation
    }
}

class Button {
    private Mediator mediator;

    public Button(Mediator med) {
        this.mediator = med;
    }

    public void press() {
        mediator.press();
    }
}

class Fan {
    private Mediator mediator;
    private boolean isOn = false;

    public Fan(Mediator mediator, boolean isOn) {
        this.isOn = isOn;
        this.mediator = mediator;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void turnOn() {
        mediator.start();
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
        mediator.stop();
    }
}

public class MediatorExample {

    public static void main(String[] args) {

        Mediator mediator = new Mediator();

        Button button = new Button(mediator);
        Fan fan = new Fan(mediator, false);
        PowerSupplier powerSupplier = new PowerSupplier();

        mediator.setButton(button);
        mediator.setPowerSupplier(powerSupplier);
        mediator.setFan(fan);

        //assertFalse(fan.isOn());
        System.out.println(fan.isOn());
        System.out.println(mediator.getFan().isOn());

        //assertTrue(fan.isOn());
        button.press();
        System.out.println(fan.isOn());
        System.out.println(mediator.getFan().isOn());

        //assertFalse(fan.isOn());
        button.press();
        System.out.println(fan.isOn());
        System.out.println(mediator.getFan().isOn());


    }
}
