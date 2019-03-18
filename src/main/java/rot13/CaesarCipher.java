package rot13;

public class CaesarCipher extends ROT13 {

    public CaesarCipher(int shift) {
        this.shift = Math.floorMod(shift, 26);
        this.deshift = 26 - shift;
    }
}
