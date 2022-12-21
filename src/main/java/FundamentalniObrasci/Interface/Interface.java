package FundamentalniObrasci.Interface;

interface Messenger {
    public void sendMessage(String receiver, String text);
}

class MailMessenger implements Messenger {

    public void sendMessage(String receiver, String text) {
        //Do some operation
        System.out.println("Poslata poruka od strane MailMessanger");
    }

}

class PrintMessenger implements Messenger {

    public void sendMessage(String receiver, String text) {

        // Just print to stdout
        System.out.println("A message is sent to " + receiver + ":");
        System.out.println(text);
    }

}

class Delegator{
    Messenger delegate = null;

    public void toMailMessenger(){
        this.delegate = new MailMessenger();
    }

    public void toPrintMessenger(){
        this.delegate = new PrintMessenger();
    }

    public void sendMessage(String reciever, String message){
        this.delegate.sendMessage(reciever, message);
    }
}

public class Interface {
    public static void main(String args[]) {

        String reciever = "Pero";
        String message = "Ove je poruka koja se salje!";


        //Koristimo delegator kao primer kako se moze koristiit
        Delegator del = new Delegator();

        //Delegator nije default namesten pa vraca gresku!
        try{
            del.sendMessage(reciever, message);

        }catch(Exception e){
            System.out.println("Delegator je vrednosti null sto ne moze da slje poruku!");
        }

        //Delegator se stavlja kao Mail Messenger i salje poruku
        del.toMailMessenger();
        del.sendMessage(reciever, message);

        //Delegator se stavlja kao Print Messenger i salje poruku
        del.toPrintMessenger();
        del.sendMessage(reciever, message);

    }
}
