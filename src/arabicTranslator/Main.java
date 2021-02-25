package arabicTranslator;

public class Main {
    IOManager ioManager = new IOManager();
    Translator translator = new Translator();

    public static void main(String[] args) {
        Main main = new Main();
        main.setNumber();
        main.translate();
    }

    public void setNumber(){
        ioManager.recieveInput();
        translator.setNumber(ioManager.getInputNumber());
        ioManager.printOutput();
    }

    public void translate(){
        translator.process();
        System.out.println(translator.getText());
    }
}
