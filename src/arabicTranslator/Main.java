package arabicTranslator;
import IOManager;

public class Main {
    IOManager ioManager = new IOManager();

    public static void main(String[] args) {
        Main translator = new Main();
        translator.setNumber();
    }

    public void setNumber(){
        ioManager.recieveInput();
        ioManager.printOutput();
    }
}
