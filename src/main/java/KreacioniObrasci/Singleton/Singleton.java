package KreacioniObrasci.Singleton;

public class Singleton {
    public static void main(String[] args) {

        //Pomocu ovoga jedino mozemo da dobijemo instancu Eager Singletona
        //Kada god nam treba instanca ovoga singletona samo pozovemo getInstance() metodu
        //Eager za razliku od lazy po pozivu odnosno kreiranju instancu postavi kao singleton
        System.out.println(EagerInitializedSingleton.getInstance());
        //Iz drugog printa mozemo da vidimo da je ista instanca kalse koja nam je potrebna
        System.out.println(EagerInitializedSingleton.getInstance());


        //Za razliku od Eagera Lazy tek kada se pozove metoda getInstance() tek onda pravi novu instancu singletona
        System.out.println(LazyInitializedSingleton.getInstance());
        //Iz drugog printa mozemo da vidimo da je ista instanca kalse koja nam je potrebna
        System.out.println(LazyInitializedSingleton.getInstance());

    }
}
