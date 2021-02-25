package arabicTranslator;

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
