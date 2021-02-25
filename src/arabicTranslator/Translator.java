package arabicTranslator;

/**
 * Class that translates a given number into its textual form.
 */
public class Translator {
    private String number;
    private String text = "";
    private String[] numberList = { "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
            "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};
    private String[] twentyList = { "veintiuno", "veintidos", "veintitres", "veinticuatro", "veinticinco", "veintiseis",
            "veintisiete", "veintiocho", "veintinueve" };
    private String[] tensList = { "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta",
            "noventa" };
    private String[] hundredsList = { "ciento", "docientos", "trecientos", "cuatrocientos", "quinientos", "seiscientos",
            "sietecientos", "ochocientos", "nuevecientos" };

    /**
     * Method that evaluates and generates the textual form of the number
     */
    public void process() {
        int numberInt = Integer.parseInt(getNumber());
        if (numberInt <= 19) {
            setText(numberList[numberInt]);
        } else {
            if (getNumber().length() == 2) {
                translationTens(getNumber());
            } else if (getNumber().length() == 3) {
                translationHundreds(getNumber());
            } else if (getNumber().length() == 4) {
                translationThousands(getNumber());
            } else if (getNumber().length() == 5) {
                translationTens(getNumber().substring(0, 2));
                setText("mil ");
                translationHundreds(getNumber().substring(2, 5));
            } else {
                translationHundreds(getNumber().substring(0, 3));
                setText("mil ");
                translationHundreds(getNumber().substring(3, 6));
            }
        }
    }

    /**
     * Method to get the number being translated
     * @return String with the number being translated
     */
    public String getNumber() {
        return number;
    }

    /**
     * Method to get the textual version of the given number
     * @return String with the textual version of the given number
     */
    public String getText() {
        return text;
    }

    /**
     * Method that sets a new number
     * @param newnumber String with the new number
     */
    public void setNumber(String newnumber) {
        number = newnumber;
    }

    /**
     * Method to add a new number to the textual form
     * @param newnumber String with the new textual new element of the number
     */
    public void setText(String newnumber) {
        text += newnumber;
    }

    /**
     * Method that translates numbers in the tens place
     * @param number String with the number
     */
    private void translationTens(String number) {
        int numberInt = Integer.parseInt(number);
        if (!number.equals("00")) {
            if (numberInt <= 15) {
                setText(numberList[numberInt] + " ");
            } else if (number.charAt(1) == '0') {
                setText(tensList[Character.getNumericValue(number.charAt(0)) - 1] + " ");
            } else if (number.charAt(0) == '2') {
                setText(twentyList[Character.getNumericValue(number.charAt(1)) - 1] + " ");
            } else {
                setText(tensList[Character.getNumericValue(number.charAt(0)) - 1] + " ");
                setText("y ");
                setText(numberList[Character.getNumericValue(number.charAt(1))] + " ");
            }
        }

    }

    /**
     * Method that translates numbers in the hundreds place
     * @param number String with the number
     */
    private void translationHundreds(String number) {
        if (number.charAt(0) == '0') {
            translationTens(number.substring(1, 3));
        } else if (!number.equals("000")) {

            if (number.charAt(1) == '0' && number.charAt(2) == '0') {
                if (number.charAt(0) == '1') {
                    setText("cien ");
                } else {
                    setText(hundredsList[Character.getNumericValue(number.charAt(0)) - 1] + " ");
                }
            } else {
                setText(hundredsList[Character.getNumericValue(number.charAt(0)) - 1] + " ");
                translationTens(number.substring(1, 3));
            }
        }
    }

    /**
     * Method that translates numbers in the thousands place
     * @param number String with the number
     */
    private void translationThousands(String number) {
        if (number.charAt(0) == '1') {
            setText("mil ");
            translationHundreds(number.substring(1, 4));
        } else {
            translationTens(number.substring(0, 1));
            setText("mil ");
            translationHundreds(number.substring(1, 4));
        }
    }

}
