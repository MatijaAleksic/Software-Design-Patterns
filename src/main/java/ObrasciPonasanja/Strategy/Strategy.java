package ObrasciPonasanja.Strategy;

import java.math.BigDecimal;

interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);
}

class EasterDiscounter implements Discounter {

    @Override
    public BigDecimal applyDiscount(final BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}

class ChristmasDiscounter implements Discounter {
    @Override
    public BigDecimal applyDiscount(final BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.9));
    }
}

class StrategyClass{

    private Discounter discounter;

    public StrategyClass() { }

    public BigDecimal calculateDiscount(BigDecimal temp){
        return discounter.applyDiscount(temp);
    }

    public Discounter getDiscounter() {
        return discounter;
    }

    public void setDiscounter(Discounter discounter) {
        this.discounter = discounter;
    }
}

public class Strategy {

    public static void main(String[] args) {

        StrategyClass strategy = new StrategyClass();

        strategy.setDiscounter(new EasterDiscounter());
        System.out.println(strategy.calculateDiscount(BigDecimal.valueOf(100))); //.isEqualByComparingTo(BigDecimal.valueOf(50));

        strategy.setDiscounter(new ChristmasDiscounter());
        System.out.println(strategy.calculateDiscount(BigDecimal.valueOf(100)));


    }
}
