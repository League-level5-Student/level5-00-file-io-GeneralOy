package _02_File_Encrypt_Decrypt;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	public static void main(String[] args) {
		FileDecryptor mainDecryptor = new FileDecryptor();
	}

	public FileDecryptor() {
		String messageIn = LineReader();

		try {
			JOptionPane.showMessageDialog(null, Decrypt(messageIn));
			// Decrypt(messageIn);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String Decrypt(String encryptedMessage) throws Exception {
		String decryptedMessage = "";
		for (char ch : encryptedMessage.toCharArray()) {
			char[] encM = null;
			if (Character.isBmpCodePoint(ch)) {
				int numVal = (int) ch;
				// System.out.println(numVal);
				encM = Character.toChars(numVal);
				// System.out.println(encM[0]);
				if (numVal >= 33 && numVal <= 126) {
					// System.out.println("LLLLL");
					if (numVal - 10 <= 33) {
						encM = Character.toChars(numVal + 116 - 33);
						// System.out.println(encM);
						// System.out.println("test1");

					} else if (numVal - 10 >= 33 && numVal - 10 <= 127) {
						encM = Character.toChars(numVal - 10);
						// System.out.println(encM);
						// System.out.println("testtest2");
					}
				}
				// System.out.println(encM[0]);
				decryptedMessage = decryptedMessage + encM[0];
			} else {
				throw new Exception();
			}
		}

		// System.out.println(decryptedMessage);
		return decryptedMessage;

	}

// Read from a file one line at a time
	public String LineReader() {
		String out = "";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(/* fileName */"src/_02_File_Encrypt_Decrypt/TestFile"));

			line = br.readLine();
			while (line != null) {
				System.out.println(line);
				out = out + line + "\n";
				line = br.readLine();

			}
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(out);
		// Create a program that opens the file created by FileEncryptor and display
		// the decrypted message to the user in a JOptionPane.
		return out;
	}
}
