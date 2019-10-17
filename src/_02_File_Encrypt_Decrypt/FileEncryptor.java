package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JOptionPane;

public class FileEncryptor {
	public static void main(String[] args) {
		FileEncryptor encryptor = new FileEncryptor();
	}

	public FileEncryptor() {
		String userIn = "";
		try {
		userIn = JOptionPane.showInputDialog("Input message to encrypt here. \nNOTE: This action will delete any previous text.");
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(!userIn.isEmpty()) {
		String encryptedMessage = encrypt(userIn);
		FileRecorder(encryptedMessage);
		}

	}

	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public String encrypt(String input) {
		String encryptedInput = "";
		int i = 0;
		for (char ch : input.toCharArray()) {
			char addit;
			char[] encC = null;
			try {
				if (Character.isBmpCodePoint(ch)) {
					int numVal = (int) ch;
					// System.out.println(numVal);
					encC = Character.toChars(numVal);

					if (numVal >= 33 && numVal <= 126) {
						if (numVal + 10 >= 126) {
							encC = Character.toChars(numVal - 116 + 33);
							// System.out.println(encC);
							// System.out.println("test1");

						} else if (numVal + 10 <= 126 && numVal + 10 >= 33) {
							encC = Character.toChars(numVal + 10);
							// System.out.println(encC);
							// System.out.println("testtest2");
						}
					}

					encryptedInput = encryptedInput + encC[0];
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(encryptedInput);
		return encryptedInput;

	}

	public void FileRecorder(String UserInput) {
		try {
			FileWriter fw = new FileWriter(/* fileName */"src/_02_File_Encrypt_Decrypt/TestFile");

			fw.write(UserInput);

			fw.close();
			System.out.println("done writing");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* }/ **/
	}
}
