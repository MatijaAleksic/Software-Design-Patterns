package StrukturalniObrasci.Adapter;

interface Movable {
    // returns speed in MPH
    double getSpeed();
}

class BugattiVeyron implements Movable {
    @Override
    public double getSpeed() {
        return 268;
    }
}

interface MovableAdapter {
    // returns speed in KM/H
    double getSpeed();
}

class MovableAdapterImpl implements MovableAdapter {

    private Movable luxuryCars = null;

    public MovableAdapterImpl(Movable luxuryCars){
        this.luxuryCars = luxuryCars;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCars.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}

public class Adapter {

    public static void main(String[] args) {
        Movable bugattiVeyron = new BugattiVeyron();
        MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);

        System.out.println("Bugati Veyron speed MPH : " + bugattiVeyron.getSpeed());
        System.out.println("Bugati Veyron speed KMPH : " + bugattiVeyronAdapter.getSpeed());
    }
}
