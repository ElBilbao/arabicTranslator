package arabicTranslator;

public class Main {
    IOManager ioManager = new IOManager();
    Translator translator = new Translator();

    public static void main(String[] args) {
        Main main = new Main();
        main.setNumber();
        main.translate();
        main.getNumber();
    }

    public void setNumber(){
        ioManager.recieveInput();
        translator.setNumber(ioManager.getInputNumber());
    }

    public void translate(){
        translator.process();
        ioManager.setOutputNumber(translator.getText());
    }

    public void getNumber(){
        ioManager.printOutput();
    }
}
