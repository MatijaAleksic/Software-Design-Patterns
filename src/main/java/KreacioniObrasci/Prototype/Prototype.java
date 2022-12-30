package KreacioniObrasci.Prototype;

import java.util.HashMap;
import java.util.Random;


@SuppressWarnings("serial")
class ResourceTypeNotSupported extends Exception {}

class Resource implements Cloneable {

    static private HashMap<ResourceType, Resource> registry =
            new HashMap<ResourceType, Resource>();
    static {
        registry.put(ResourceType.DB, new DBResource());
        registry.put(ResourceType.Net, new NetworkResource());
    }

    enum ResourceType {
        DB, Net
    }

    /**
     * Vraća novu instancu resursa korišćenjem <i>plitkog</i> kopiranja
     * @param type Tip resursa
     * @return Nova instanca zahtevanog tipa resursa.
     * @throws ResourceTypeNotSupported Unchecked izuzetak ukoliko tip nije registrovan
     *         jer je ovo znak programerske greške.
     */
    public static Resource getResource(ResourceType type) throws ResourceTypeNotSupported{
        Resource newResource = null;
        try {
            newResource = (Resource)((Resource)registry.get(type)).clone();
        } catch (CloneNotSupportedException e) {
            throw new ResourceTypeNotSupported();
        }
        return newResource;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone(); //"plitko" kopiranje!!!
    }

}

class NetworkResource extends Resource {

    protected static int initializationCounter = 0;
    protected int state = 0;

    public NetworkResource(){
        super();
        longRunningInitialization();
    }

    public static int getInitializationCounter(){
        return initializationCounter;
    }

    public static void resetCounter(){
        initializationCounter = 0;
    }

    protected void longRunningInitialization(){
        // ... inicijalizacija koja se dugo izvršava
        state = 2; //i rezultuje postavljanjem određenog stanja objekta
        initializationCounter++;
    }
}

class DBResource extends Resource {

    protected static int initializationCounter = 0;
    protected int state=0;

    public DBResource(){
        super();
        longRunningInitialization();
    }

    public static int getInitializationCounter(){
        return initializationCounter;
    }

    public static void resetCounter(){
        initializationCounter = 0;
    }

    protected void longRunningInitialization(){
        // ... inicijalizacija koja se dugo izvršava
        state = 2;  //i rezultuje postavljanjem određenog stanja objekta
        initializationCounter++;
    }

}



public class Prototype {

    public static void main(String[] args) throws ResourceTypeNotSupported {

        Random rand = new Random();

        DBResource.resetCounter();
        NetworkResource.resetCounter();

        System.out.println("Klasično instanciranje");
        for(int i=0; i<1000; i++){
            if( rand.nextInt()%2 == 0 ){
                @SuppressWarnings("unused")
                Resource r = new DBResource();
            }else{
                @SuppressWarnings("unused")
                Resource r = new NetworkResource();
            }
        }
        System.out.println("Broj poziva dugih inicijalizacija = " +
                (DBResource.getInitializationCounter()+
                        NetworkResource.getInitializationCounter()));

        DBResource.resetCounter();
        NetworkResource.resetCounter();

        System.out.println("Prototype instanciranje");
        for(int i=0; i<1000; i++){
            if( rand.nextInt()%2 == 0 ){
                @SuppressWarnings("unused")
                Resource r = (Resource) Resource.getResource(
                        Resource.ResourceType.DB);
            }else{
                @SuppressWarnings("unused")
                Resource r = (Resource) Resource.getResource(
                        Resource.ResourceType.Net);
            }
        }

        System.out.println("Broj poziva dugih inicijalizacija = " +
                (DBResource.getInitializationCounter()+
                        NetworkResource.getInitializationCounter()));

    }
}
