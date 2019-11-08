package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	// String[] tasksList;
	ArrayList<String> taskList = new ArrayList<String>();

	public static void main(String[] args) {
		ToDoList toDo = new ToDoList();
	}

	public ToDoList() {
		autoLoad();
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
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);

	}
	// CHECKLIST:
	/** Create buttons, GUI */
	/** Create methods for reading, writing lines, characters, etc. */
	/** Actionlisteners */
	/** create methods for deleting specific lines */
	/* Automatically load last saved file */
	/**/

	/**
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 */
	/**
	 * When add task is clicked: ask the user for a task and save it to an ARRAY
	 * LIST!!!!!!!!!!!!!!!
	 */
	/**
	 * When the view tasks button is clicked: show all the tasks in the list
	 */
	/**
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 */
	/**
	 * When the save list button is clicked: Save the list to a file
	 */
	/**
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 */
	/**
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
			removeTask();
		}
		if (e.getSource() == saveList) {
			saveList();
		}
		if (e.getSource() == loadList) {
			loadList();
		}
		updateAutoLoad();
	}

	public void FileReader(String source) {
		taskList.clear();
		// String out = "";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(source));

			line = br.readLine();
			while (line != null) {
				System.out.println(line);
				if (!line.isEmpty()) {
					taskList.add(line);
				}
				line = br.readLine();

			}
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return out;
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

	public void writeToFile(String source) {
		try {
			FileWriter fw = new FileWriter(source);
			for (String task : taskList) {
				fw.write("\n" + task);
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void chooseFile() {
		// Using a file chooser
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			this.fileSource = jfc.getSelectedFile().getAbsolutePath();
		}
	}

	///////////////////////////////////////////////////////

	public void addTask(String taskName) {
		if (!taskName.isEmpty()) {
			taskList.add(taskName);
		}
		System.out.println(taskList);
	}

	public void viewTasks() {
		String displayTasks = "";
		int n = 1;
		for (String task : taskList) {
			displayTasks = displayTasks + n + ". " + task + "\n";
			n++;
		}
		JOptionPane.showMessageDialog(mFrame, displayTasks);
	}

	public void removeTask() {
		String taskStr = JOptionPane
				.showInputDialog("Which task would you like to remove? \nPlease enter the number of the desired task.");
		int taskNum = Integer.parseInt(taskStr) - 1;
		if (taskNum >= taskList.size() || taskNum <= 0) {
			JOptionPane.showMessageDialog(mFrame, "That isn't a task, sorry.");
		} else {
			taskList.remove(taskNum);
		}
	}

	public void loadList() {
		int choice = JOptionPane.showConfirmDialog(mFrame,
				"Warning: This will override any unsaved tasks\nAre you sure you want to do this?");
		if (choice == 0) {
			// yes
			chooseFile();
			FileReader(fileSource);

		} else if (choice == 1) {
			// no

		} else if (choice == 2) {
			// cancel

		} else {

		}
	}

	public void saveList() {
		int choice = JOptionPane.showConfirmDialog(mFrame,
				"Warning: This will override any previous text in the file chosen!\nAre you sure you want to do this?");
		if (choice == 0) {
			// yes
			if (fileSource.isEmpty()) {
				JOptionPane.showMessageDialog(mFrame, "Please choose a file to save to!");
				chooseFile();
				writeToFile(fileSource);
			} else if (!fileSource.isEmpty()) {
				writeToFile(fileSource);
			}
			// System.out.println(choice);

		} else if (choice == 1) {
			// no
			// System.out.println(choice);

		} else if (choice == 2) {
			// cancel
			// System.out.println(choice);

		} else {

		}

	}

	public void updateAutoLoad() {
		try {
			FileWriter fw = new FileWriter("src/_03_To_Do_List/AutoloadText");
			fw.write(fileSource);

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void autoLoad() {
		String out = "";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(/* fileName */"src/_03_To_Do_List/AutoloadText"));

			line = br.readLine();
			while (line != null) {
				System.out.println(line);
				out = out + line;
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
		System.out.println(out);
		fileSource = out;
		FileReader(fileSource);
	}
}
