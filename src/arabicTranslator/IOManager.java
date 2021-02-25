package arabicTranslator;

import java.util.Scanner;

/**
 * Class that handles the Input and Output of the program.
 */
public class IOManager {
    public String inputNumber;
    public Scanner myObj = new Scanner(System.in);
    private String outputNumber;

    /**
     * Method that requests user input and checks for a valid input
     */
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

    /**
     * Method to display the results to the user in console.
     */
    public void printOutput() {
        System.out.println("---------------------[Resultados]---------------------");
        System.out.println("Forma numerica: " + getInputNumber());
        System.out.println("Forma escrita: " + getOutputNumber());
    }

    /**
     * Method to get the input number
     * @return String that contains the number given by the user.
     */
    public String getInputNumber() {
        return inputNumber;
    }

    /**
     * Method to set the input number
     * @param number String with the number to set
     */
    public void setInputNumber(String number) {
        inputNumber = number;
    }

    /**
     * Method to get the output number
     * @return String with the output number
     */
    public String getOutputNumber() {
        return outputNumber;
    }

    /**
     * Method to set the output number
     * @param number String with the output number
     */
    public void setOutputNumber(String number) {
        outputNumber = number;
    }

    /**
     * Method to validate that the given number is valid
     * A valid number is a number in 0-9999.
     * @param number String with a number
     * @return boolean as true if it is valid, else false.
     */
    private boolean validateInput(String number) {
        if (0 < number.length() && number.length() <= 4 && number.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }

    }

}
