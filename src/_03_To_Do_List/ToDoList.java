package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	String fileSource;
	JFrame mFrame;
	JPanel mPanel;
	JButton addTask;
	JButton viewTasks;
	JButton removeTask;
	JButton saveList;
	JButton loadList;

	public static void main(String[] args) {

		ToDoList toDo = new ToDoList();
	}

	public ToDoList() {
		loadList();
		mFrame = new JFrame();
		mPanel = new JPanel();
		addTask = new JButton();
		viewTasks = new JButton();
		removeTask = new JButton();
		saveList = new JButton();
		loadList = new JButton();

		mFrame.add(mPanel);
		mPanel.add(addTask);
		mPanel.add(viewTasks);
		mPanel.add(removeTask);
		mPanel.add(saveList);
		mPanel.add(loadList);

		mFrame.setVisible(true);
		mPanel.setVisible(true);
		addTask.setText("Add Task");
		viewTasks.setText("View Tasks");
		removeTask.setText("Remove Task");
		saveList.setText("Save List");
		loadList.setText("Load List");
		mFrame.pack();

		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);

	}
	//CHECKLIST: 
	/**Create buttons, GUI*/
	/**Create methods for reading, writing lines, characters, etc.*/
	/*Actionlisteners*/
	/*MAYBE create methods for deleting specific lines*/
	/**/
	
	
	/**
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 */
	/*
	 * When add task is clicked: ask the user for a task and save it to an ARRAY LIST!!!!!!!!!!!!!!!
	 */
	/*
	 * When the view tasks button is clicked: show all the tasks in the list
	 */
	/*
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 */
	/*
	 * When the save list button is clicked: Save the list to a file
	 */
	/*
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 */
	/*
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addTask) {
			String inTask = JOptionPane.showInputDialog(
					"What task would you like to add? \nMake sure to spell the task name as it is listed, including punctuation and spaces. \nCapitalization does not matter.");
			addTask(inTask);
		}
		if (e.getSource() == viewTasks) {
			viewTasks();
		}
		if (e.getSource() == removeTask) {
			String remTask = JOptionPane.showInputDialog(
					"What task would you like to remove? \nMake sure to spell the task name as it is listed, including punctuation and spaces. \nCapitalization does not matter.");
		}
		if (e.getSource() == saveList) {

		}
		if (e.getSource() == loadList) {

		}

	}

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
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

	public String charReader() {
		String out = "";
		try {
			FileReader fr = new FileReader("src/_00_Intro_To_File_Input_and_Output/test.txt");
			int c = fr.read();
			while (c != -1) {
				System.out.print((char) c);
				out = out + (char) c;
				c = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;

	}

	public void writeToFile() {
		
	}

	public void chooseFile(String fileName) {

	}

	///////////////////////////////////////////////////////

	public void addTask(String taskName) {

	}

	public void viewTasks() {

	}

	public void removeTask(String fileName) {

	}

	public void saveList() {

	}

	public void loadList() {

	}
}
