package rot13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.Function;

public class SonnetCrypt {
    private CaesarCipher caesarCipher;

    public SonnetCrypt(int shift) {
        caesarCipher = new CaesarCipher(shift);
    }

    public void encryptSonnet() {
        getFileContentsApplyFunctionSaveInNewFile("src/resource/sonnet18.txt", "src/resource/sonnet18.enc", caesarCipher::encrypt);
    }

    public void decryptSonnet() {
        getFileContentsApplyFunctionSaveInNewFile("src/resource/sonnet18.enc", "src/resource/decryptedSonnet18.txt", caesarCipher::decrypt);
    }

    private static void getFileContentsApplyFunctionSaveInNewFile(String sourcePathName, String destinationPathName, Function<String, String> function) {
        String fileContents = getStringFromFile(sourcePathName);
        String modifiedFileContents = function.apply(fileContents);
        writeStringToFile(destinationPathName, modifiedFileContents);
    }

    private static String getStringFromFile(String sourcePathName){
        File origFile = new File(sourcePathName);
        Scanner scanner = getScanner(origFile);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()).append('\n');
        }
        return stringBuilder.toString();
    }

    private static Scanner getScanner(File origFile) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(origFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scanner;
    }

    private static void writeStringToFile(String destinationPathName, String modifiedFileContents) {
        File destFile = createFile(destinationPathName);
        PrintWriter writer = getPrintWriter(destFile);
        writer.print(modifiedFileContents);
        writer.close();
    }

    private static PrintWriter getPrintWriter(File destFile) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(destFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return writer;
    }

    private static File createFile(String pathname) {
        File destFile = new File(pathname);
        try {
            destFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFile;
    }


}
