package ObrasciPonasanja.Memento;

class TextEditor {

    private TextWindow textWindow;

    private TextWindowState savedTextWindow;

    public TextEditor(TextWindow textWindow) {
        this.textWindow = textWindow;
    }


    public void hitSave() {
        savedTextWindow = this.textWindow.save();
    }

    public void hitUndo() {
        this.textWindow.restore(savedTextWindow);
    }

    public void write(String message){
        this.textWindow.addText(message);
    }

    public void print(){
        System.out.println(this.textWindow.printText());
    }
}

//OVO JE ORIGINATOR
class TextWindow {

    private StringBuilder currentText;

    public TextWindow() {
        this.currentText = new StringBuilder();
    }

    public TextWindowState save() {
        return new TextWindowState(currentText.toString());
    }

    public void restore(TextWindowState save) {
        currentText = new StringBuilder(save.getText());
    }

    public void addText(String text) {
        currentText.append(text);
    }

    public String printText(){
        return this.currentText.toString();
    }
}

//OVO JE MEMENTO
class TextWindowState {

    private String text;

    public TextWindowState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

public class MementoExample {
    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor(new TextWindow());
        textEditor.write("The Memento Design Pattern\n");
        textEditor.write("How to implement it in Java?\n");

        //Sacuva state texta
        textEditor.hitSave();

        //Doda jos jednu liniju texta
        textEditor.write("Buy milk and eggs before coming home\n");

        //Vraca na poslednje stanje texta
        textEditor.hitUndo();

        //Printa
        textEditor.print(); //.isEqualTo("The Memento Design Pattern\n
                                        // How to implement it in Java?\n");
    }
}
