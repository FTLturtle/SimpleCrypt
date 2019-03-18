package rot13;

public class ROT13 {
    int shift;
    int deshift;

    ROT13(Character cs, Character cf) {
        if (!Character.isAlphabetic(cs) || !Character.isAlphabetic(cf)) {
            throw new IllegalArgumentException();
        }
        cs = Character.toLowerCase(cs);
        cf = Character.toLowerCase(cf);
        shift = ((cf - cs) + 26) % 26;
        deshift = 26 - shift;
    }

    ROT13() {
        shift = 13;
        deshift = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        return encrypt(text);
    }

    public String encrypt(String text) {
        return getShiftedString(text, shift);
    }

    public String decrypt(String text) {
        return getShiftedString(text, deshift);
    }

    private String getShiftedString(String text, int shiftAmount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            result.append(shiftCharacter(currChar, shiftAmount));
        }
        return result.toString();
    }

    private char shiftCharacter(char currChar, int shiftAmount) {
        char shiftChar;
        if (Character.isAlphabetic(currChar)) {
            if (Character.isUpperCase(currChar)) {
                shiftChar = (char) (((int) currChar + shiftAmount - 65) % 26 + 65);
            } else {
                shiftChar = (char) (((int) currChar + shiftAmount - 97) % 26 + 97);
            }
        } else {
            shiftChar = currChar;
        }
        return shiftChar;
    }

    public static String rotate(String s, Character c) {
        int indexOfChar = s.indexOf(c);
        if (indexOfChar != -1) {
            s = s.substring(indexOfChar) + s.substring(0, indexOfChar);
        }
        return s;
    }

}
