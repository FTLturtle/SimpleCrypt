package rot13;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SonnetCryptTest {

    @Test
    public void encryptSonnetTest1() {
        // Given
        SonnetCrypt sonnetCrypt = new SonnetCrypt(17);

        // When
        sonnetCrypt.encryptSonnet();

        // Then
        File origFile = new File("src/resource/sonnet18.txt");
        File destFile = new File("src/resource/sonnet18.enc");
        Scanner origScanner = SonnetCrypt.getScanner(origFile);
        Scanner destScanner = SonnetCrypt.getScanner(destFile);
        while (origScanner.hasNextLine()) {
            assertNotEquals(origScanner.nextLine(), destScanner.nextLine());
        }
    }

    @Test
    public void encryptSonnetTest2() {
        // Given
        SonnetCrypt sonnetCrypt = new SonnetCrypt(7);

        // When
        sonnetCrypt.encryptSonnet();

        // Then
        File origFile = new File("src/resource/sonnet18.txt");
        File destFile = new File("src/resource/sonnet18.enc");
        Scanner origScanner = SonnetCrypt.getScanner(origFile);
        Scanner destScanner = SonnetCrypt.getScanner(destFile);
        while (origScanner.hasNextLine()) {
            assertNotEquals(origScanner.nextLine(), destScanner.nextLine());
        }
    }

    @Test
    public void encryptSonnetTest3() {
        // Given
        SonnetCrypt sonnetCrypt = new SonnetCrypt(0);

        // When
        sonnetCrypt.encryptSonnet();

        // Then
        File origFile = new File("src/resource/sonnet18.txt");
        File destFile = new File("src/resource/sonnet18.enc");
        Scanner origScanner = SonnetCrypt.getScanner(origFile);
        Scanner destScanner = SonnetCrypt.getScanner(destFile);
        while (origScanner.hasNextLine()) {
            assertEquals(origScanner.nextLine(), destScanner.nextLine());
        }
    }

    @Test
    public void decryptSonnetTest1() {
        // Given
        SonnetCrypt sonnetCrypt = new SonnetCrypt(17);
        sonnetCrypt.encryptSonnet();

        // When
        sonnetCrypt.decryptSonnet();

        // Then
        File origFile = new File("src/resource/sonnet18.txt");
        File destFile = new File("src/resource/decryptedSonnet18.txt");
        Scanner origScanner = SonnetCrypt.getScanner(origFile);
        Scanner destScanner = SonnetCrypt.getScanner(destFile);
        while (origScanner.hasNextLine()) {
            assertEquals(origScanner.nextLine(), destScanner.nextLine());
        }
    }

    @Test
    public void decryptSonnetTest2() {
        // Given
        SonnetCrypt sonnetCrypt = new SonnetCrypt(24);
        sonnetCrypt.encryptSonnet();

        // When
        sonnetCrypt.decryptSonnet();

        // Then
        File origFile = new File("src/resource/sonnet18.txt");
        File destFile = new File("src/resource/decryptedSonnet18.txt");
        Scanner origScanner = SonnetCrypt.getScanner(origFile);
        Scanner destScanner = SonnetCrypt.getScanner(destFile);
        while (origScanner.hasNextLine()) {
            assertEquals(origScanner.nextLine(), destScanner.nextLine());
        }
    }

    @Test
    public void decryptSonnetTest3() {
        // Given
        SonnetCrypt sonnetCrypt = new SonnetCrypt(4);
        sonnetCrypt.encryptSonnet();

        // When
        sonnetCrypt.decryptSonnet();

        // Then
        File origFile = new File("src/resource/sonnet18.txt");
        File destFile = new File("src/resource/decryptedSonnet18.txt");
        Scanner origScanner = SonnetCrypt.getScanner(origFile);
        Scanner destScanner = SonnetCrypt.getScanner(destFile);
        while (origScanner.hasNextLine()) {
            assertEquals(origScanner.nextLine(), destScanner.nextLine());
        }
    }
}