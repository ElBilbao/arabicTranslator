package arabicTranslator;

import java.util.Scanner;

public class IOManager {
    public String inputNumber;
    public Scanner myObj = new Scanner(System.in);
    private String outputNumber;

    public void recieveInput() {
        System.out.println("Please input the number: ");
        String number = myObj.nextLine();
        if (validateInput(number)) {
            setInputNumber(number);
        } else {
            System.out.println("Invalid input. Please try again./n");
            System.out.println("Only input numbers./n");
            System.out.println("1-6 digits./n");
            recieveInput();
        }
    }

    public void printOutput() {
        System.out.println("Numberic form: " + inputNumber);
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
        if (0 < number.length() && number.length() <= 6 && number.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }

    }

}
