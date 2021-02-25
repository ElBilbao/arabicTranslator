package arabicTranslator;

import java.util.Scanner;

public class IOManager {
    public String inputNumber;
    public Scanner myObj = new Scanner(System.in);
    private String outputNumber;

    public void recieveInput() {
        System.out.print("Numero: ");
        String number = myObj.nextLine();
        if (validateInput(number)) {
            setInputNumber(number);
        } else {
            System.out.println("ERROR: Numero invalido");
            System.out.println("Solo se pueden introducir numeros de 0-9999.");
            recieveInput();
        }
    }

    public void printOutput() {
        System.out.println("---------------------[Resultados]---------------------");
        System.out.println("Forma numerica: " + getInputNumber());
        System.out.println("Forma escrita: " + getOutputNumber());
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String number) {
        inputNumber = number;
    }

    public String getOutputNumber() {
        return outputNumber;
    }

    public void setOutputNumber(String number) {
        outputNumber = number;
    }

    private boolean validateInput(String number) {
        if (0 < number.length() && number.length() <= 4 && number.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }

    }

}
