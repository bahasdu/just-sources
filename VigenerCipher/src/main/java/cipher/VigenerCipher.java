/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author baha cipher.VigenerCipher
 */
public class VigenerCipher {

    public static String plaintext;
    public static String keyword;
    public static String encryptionResult;
    public static String decryptionResult;

    public static void main(String[] args) throws Exception {
        showMenu();
        encryptionResult = "";
        decryptionResult = "";
        int command;
        while (true) {
            command = getInt();
            if (command == 1) {
                promptPlaintextKeyword();
                encryptAlgorithm();
            } else if (command == 2) {
                promptEncryptionKeyword();
                decryptAlgorithm();
            } else if (command == 3) {
                break;
            } else {
                System.out.println("There is no such command");
            }
            showMenu();
        }
        System.out.println("Program has been finished");
    }

    public static void showMenu() {
        System.out.println("Enter Following commands:");
        System.out.println("1.ENCRYPT");
        System.out.println("2.DECRYPT");
        System.out.println("3.QUIT");
    }

    public static void promptPlaintextKeyword() {
        System.out.println("ENTER PLAINTEXT:");
        plaintext = (new Scanner(System.in)).nextLine();
        System.out.println("ENTER KEYWORD:");
        keyword = (new Scanner(System.in)).nextLine();
    }

    public static void encryptAlgorithm() {
        printTable();
        toLowerCase();
        encryptionResult="";
        for (int i = 0; i < plaintext.length(); i++) {
            char currentPlainChar = plaintext.charAt(i);
            char currentKeyChar = getKeywordCharByPlaintext(i);
            encryptionResult += getCharByKeywordAndPlaintext(currentKeyChar, currentPlainChar);
        }
        showEncryptionResult();
    }

    public static void decryptAlgorithm() {
        printTable();
        toLowerCase();
        decryptionResult="";
        for (int i = 0; i < encryptionResult.length(); i++) {
            char currentEncryptChar = encryptionResult.charAt(i);
            char currentKeyChar = getKeywordCharByPlaintext(i);
            decryptionResult += getCharByKeywordAndEncryption(currentKeyChar, currentEncryptChar);
        }
        showDecryptionResult();
    }

    public static char getKeywordCharByPlaintext(int index) {
        if (plaintext.length() <= keyword.length()) {
            return keyword.charAt(index);
        } else {
            return keyword.charAt(index % keyword.length());
        }
    }
    
    public static char getKeywordCharByEncryption(int index) {
        if (encryptionResult.length() <= keyword.length()) {
            return keyword.charAt(index);
        } else {
            return keyword.charAt(index % keyword.length());
        }
    }

    public static void checkString() {
        System.out.println(plaintext);
        for (int i = 0; i < plaintext.length(); i++) {
            System.out.print(getKeywordCharByPlaintext(i) + "");
        }
    }

    public static void printTable() {
        try {
            File file = new File("table");
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String line;
            while ((line = buffer.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static char getCharByKeywordAndPlaintext(char keywordChar, char plaintextChar) {
        int resultChar = keywordChar + getCharPositionIn1_26(plaintextChar);
        if (resultChar <= 122) {
            return (char) resultChar;
        } else {
            resultChar = 97 + resultChar % 123;
            return (char) resultChar;
        }
    }

    public static char getCharByKeywordAndEncryption(char keywordChar, char encryptChar) {
        int resultChar = encryptChar - getCharPositionIn1_26(keywordChar);
        if (resultChar > 96) {
            return (char) resultChar;
        } else {
            return (char) (resultChar + 26);
        }

    }

    public static String getKeyWord() {
        String temp = "";
        for (int i = 0; i < plaintext.length(); i++) {
            temp += getKeywordCharByPlaintext(i);
        }
        return temp;
    }

    public static int getCharPositionIn1_26(char c) {
        return c - 96;
    }

    public static void toLowerCase() {
        plaintext = plaintext.toLowerCase().replaceAll(" ", "");
        keyword = keyword.toLowerCase().replaceAll(" ", "");
    }

    private static void showEncryptionResult() {
        System.out.println("ENCRYPTION:");
        System.out.println("\tPLAINTEXT:\t" + plaintext.toUpperCase());
        System.out.println("\tKEYWORD:\t" + getKeyWord().toUpperCase());
        System.out.println("\tRESULT:\t\t" + encryptionResult.toUpperCase());
        System.out.println();
    }

    private static void showDecryptionResult() {
        System.out.println("DECRYPTION:");
        System.out.println("\tENCRYPTION:\t" + encryptionResult.toUpperCase());
        System.out.println("\tKEYWORD:\t" + getKeyWord().toUpperCase());
        System.out.println("\tRESULT:\t\t" + decryptionResult.toUpperCase());
        System.out.println();
    }

    private static void promptEncryptionKeyword() {
        System.out.println("ENTER ENCRYPTION:");
        encryptionResult = getLine();
                
        System.out.println("ENTER KEYWORD:");
        keyword = getLine();
    }


}
