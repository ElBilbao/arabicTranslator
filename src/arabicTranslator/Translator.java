package arabicTranslator;

public class Translator {
    private String number;
    private String text = "";
    private String[] numberList = { "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
            "diez", "once", "doce", "trece", "catorce", "quince" };
    private String[] twentyList = {"veintiuno", "veintidos", "veintitres", "veinticuatro", "veinticinco", "veintiseis", "veintisiete", "veintiocho", "veintinueve"};
    private String[] tensList = { "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta",
            "noventa" };
    private String[] hundredsList = { "ciento", "docientos", "trecientos", "cuatrocientos", "quinientos", "seiscientos",
            "sietecientos", "ochocientos", "nuevecientos" };

    public void process() {
        int numberInt = Integer.parseInt(getNumber());
        if (numberInt <= 15) {
            setText(numberList[numberInt]);
        } else {
            if (getNumber().length() == 2) {
                translationTens(getNumber().substring(0, 2));
            } else if (getNumber().length() == 3) {
                translationHundreds(getNumber().substring(0, 3));
            } else if (getNumber().length() == 3) {
                translationHundreds(getNumber().substring(0, 3));
            }
        }
    }

    public String getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public void setNumber(String newnumber) {
        number = newnumber;
    }

    public void setText(String newnumber) {
        text += newnumber;
    }

    private void translationTens(String number) {
        int numberInt = Integer.parseInt(number);
        if (numberInt <= 15) {
            setText(numberList[numberInt]);
        } else if (number.charAt(1) == '0') {
            setText(tensList[Character.getNumericValue(number.charAt(0)) - 1]);
        } else if (number.charAt(0) == '2') {
            setText(twentyList[Character.getNumericValue(number.charAt(0)) - 1]);
        } else {
            setText(tensList[Character.getNumericValue(number.charAt(0)) - 1]);
            setText(" y ");
            setText(numberList[Character.getNumericValue(number.charAt(1))]);
        }
    }

    private void translationHundreds(String number) {
        if (number.charAt(1) == '0' && number.charAt(2) == '0') {
            if (number.charAt(0) == '1') {
                setText("cien");
            } else {
                setText(hundredsList[Character.getNumericValue(number.charAt(0)) - 1]);
            }
        } else {
            setText(hundredsList[Character.getNumericValue(number.charAt(0)) - 1]);
            translationTens(number.substring(1, 3));
        }
    }
}
