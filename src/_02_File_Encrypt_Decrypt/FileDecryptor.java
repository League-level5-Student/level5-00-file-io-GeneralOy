package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	public static void main(String[] args) {
		FileDecryptor mainDecryptor = new FileDecryptor();
	}
	public FileDecryptor() {
		String messageIn = LineReader();
		Decrypt(messageIn);
	}
	public String Decrypt(String encryptedMessage) {
		String decryptedMessage = "";
		
		
		
		System.out.println(decryptedMessage);
		return decryptedMessage;
		
	}
	//Read from a file one line at a time
	public String LineReader() {
		String line = "";
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_00_Intro_To_File_Input_and_Output/test.txt"));
				
				line = br.readLine();
				while(line != null){
					System.out.println(line);
					line = line + br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
			return line;
}
}
