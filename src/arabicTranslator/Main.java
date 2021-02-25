package arabicTranslator;

/**
 * Main Class
 * Used to control the flow of the program.
 */
public class Main {
    IOManager ioManager = new IOManager();
    Translator translator = new Translator();

    public static void main(String[] args) {
        Main main = new Main();
        main.setNumber();
        main.translate();
        main.getNumber();
    }

    /**
     * Method to receive user input and assign it to translator.
     */
    public void setNumber(){
        ioManager.recieveInput();
        translator.setNumber(ioManager.getInputNumber());
    }

    /**
     * Method to start the translation process.
     */
    public void translate(){
        translator.process();
        ioManager.setOutputNumber(translator.getText());
    }

    /**
     * Method to display the result to the user in console.
     */
    public void getNumber(){
        ioManager.printOutput();
    }
}
