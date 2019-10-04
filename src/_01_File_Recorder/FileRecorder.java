package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {
		FileRecorder recorderMain = new FileRecorder();
	}

	public FileRecorder() {
		// String fileName = "";
		String UserInput = JOptionPane.showInputDialog("Enter Input Here");
		/*
		 * JFileChooser fileChoice = new JFileChooser(); int returnVal =
		 * fileChoice.showOpenDialog(null); if (returnVal ==
		 * JFileChooser.APPROVE_OPTION) { fileName =
		 * fileChoice.getSelectedFile().getAbsolutePath(); } /
		 **/

		/* if (!fileName.isEmpty()) {/ **/
		try {
			FileWriter fw = new FileWriter(/* fileName */"src/_01_File_Recorder/SavingDocument", true);

			fw.write("\n" + UserInput);

			fw.close();
			System.out.println("done writing");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* }/ **/
	}
	/** Create a program that takes a message from the user and saves it to a file.*/
}
