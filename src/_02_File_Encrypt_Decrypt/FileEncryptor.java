package _02_File_Encrypt_Decrypt;

import java.util.Base64;

import javax.swing.JOptionPane;

public class FileEncryptor {
	public static void main(String[] args) {
		FileEncryptor encryptor = new FileEncryptor();
	}

	public FileEncryptor() {
		String userIn = JOptionPane.showInputDialog("Input message to encrypt here");
		encrypt(userIn);
	}

	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public String encrypt(String input) {
		String encryptedInput = "";
		for (char ch : input.toCharArray()) {
			// System.out.println(c);
			char addit;
			char[] encC = null;
			System.out.println(Character.getNumericValue(ch) + 10);
			//System.out.println(Character.toChars(Character.getNumericValue(ch) + 10));
			/**Conversion BACK to chars isn't working*/
			/*if (Character.getNumericValue(ch) >= 33 && Character.getNumericValue(ch) <= 126) {
				if (Character.getNumericValue(ch) + 10 >= 126) {
					encC = Character.toChars(Character.getNumericValue(ch) - 116);
					System.out.println(Character.toChars(Character.getNumericValue(ch) - 116));
					System.out.println("test");

				} else if (Character.getNumericValue(ch) + 10 <= 126 && Character.getNumericValue(ch) + 10 >= 33) {
					encC = Character.toChars(Character.getNumericValue(ch) + 10);
					System.out.println(Character.toChars(Character.getNumericValue(ch) + 10));
					System.out.println("testtest");
				}
			}*/

			int numVal = Character.getNumericValue(ch);
			encryptedInput = encryptedInput + encC;
		}
		System.out.println(encryptedInput);
		return encryptedInput;

	}
}

/*
 * class Utilities { /* This basic encryption scheme is called single-byte xor.
 * It takes a single // byte and uses exclusive-or on every character in the
 * String. / public static String encrypt(byte[] plaintext, byte key) { for (int
 * i = 0; i < plaintext.length; i++) { plaintext[i] = (byte) (plaintext[i] ^
 * key); } return Base64.getEncoder().encodeToString(plaintext); }
 * 
 * public static String decrypt(String cyphertext, byte key) { byte[] b =
 * Base64.getDecoder().decode(cyphertext); for (int i = 0; i < b.length; i++) {
 * b[i] = (byte) (b[i] ^ key); } return new String(b); } }
 */