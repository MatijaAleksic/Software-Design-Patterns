package ObrasciPonasanja.Command;

class Light {
    public void turnOn( ) {
        System.out.println("Light is on ");
    }
    public void turnOff( ) {
        System.out.println("Light is off");
    }
}

interface Command {
    void execute ( );
}

class LightOnCommand implements Command {
    private Light myLight;
    public LightOnCommand ( Light L) {
        myLight  =  L;
    }
    public void execute( ) {
        myLight . turnOn( );
    }
}
class LightOffCommand implements Command {
    private Light myLight;
    public LightOffCommand ( Light L) {
        myLight  =  L;
    }
    public void execute( ) {
        myLight . turnOff( );
    }
}

class Switch {

    private Command UpCommand, DownCommand;

    public Switch( Command Up, Command Down) {
        UpCommand = Up; // concrete Command registers itself with the invoker
        DownCommand = Down;
    }
    void flipUp( ) { // invoker calls back concrete Command, which executes the Command on the receiver
        UpCommand . execute ( ) ;
    }
    void flipDown( ) {
        DownCommand . execute ( );
    }
}


public class CommandExample {

    public static void main(String[] args) {

        Light  testLight = new Light( );

        LightOnCommand testLOC = new LightOnCommand(testLight);
        LightOffCommand testLFC = new LightOffCommand(testLight);

        Switch testSwitch = new Switch( testLOC,testLFC);
        testSwitch.flipUp( );
        testSwitch.flipDown( );

    }
}
