package _05_Pixel_Art_Save_State;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import _04_Serialization.SaveData;

public class PixelArtMaker implements MouseListener, Serializable, ActionListener {
	private static final String DATA_FILE = "src/_05_Pixel_Art_Save_State/pixelsave.dat";
	private JFrame window;
	private GridInputPanel gip;
	private GridPanel gp;
	ColorSelectionPanel csp;
	private JButton saveButton;
	public boolean loaded = false;

	public void start() {
		gip = new GridInputPanel(this);
		window = new JFrame("Pixel Art");
		window.setLayout(new FlowLayout());
		window.setResizable(false);

		window.add(gip);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public void submitGridData(int w, int h, int r, int c) {
		gp = new GridPanel(w, h, r, c);
		csp = new ColorSelectionPanel();
		window.remove(gip);
		window.add(gp);
		window.add(csp);
		gp.repaint();
		gp.addMouseListener(this);
		saveButton = new JButton();
		saveButton.setText("Save Image");
		saveButton.addActionListener(this);
		window.add(saveButton);
		window.pack();
	}

	public static void main(String[] args) {
		new PixelArtMaker().start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gp.setColor(csp.getSelectedColor());
		System.out.println(csp.getSelectedColor());
		gp.clickPixel(e.getX(), e.getY());
		gp.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private static void save(/**/SavedPixels pixIn/**/ /* String data/ **/) {
		try /**/ (FileOutputStream fos = new FileOutputStream(DATA_FILE);
				ObjectOutputStream oos = new ObjectOutputStream(fos))/**/ {
			oos.writeObject(pixIn);
			System.out.println("success 1");
			fos.close();

			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fail 1");
		}
	}

	private static SavedPixels load() {
		try {
			FileInputStream fis = new FileInputStream(DATA_FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println("success 2");
			return (SavedPixels) ois.readObject();
		} catch (IOException e) {
			System.out.println("fail 2");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("fail 2.1");
			return null;
		}
	}

	public void loadFromSave(SavedPixels sav) {
		loaded = true;
		submitGridData(sav.windowWidth, sav.windowHeight, sav.rows, sav.columns);
		this.gp.pixelArray = sav.pixelArray;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Save Image")) {
			int opt = JOptionPane.showConfirmDialog(null, "Are you sure? Doing this will delete the previous save. \nSelect 'Yes' to continue. \nSelect 'No' to close program. \nSelect 'Cancel' to return to work.");
			if (opt == 0) {
				//YES
				Pixel[][] inArr = gp.pixelArray;
				save(new SavedPixels(inArr, gp.getWidth(), gp.getHeight(), gp.getPixelWidth(), gp.getPixelHeight(),
						gp.rows, gp.cols));
			} else if (opt == 1) {
				//NO
				System.exit(0);
			} else if (opt == 2) {
				//CANCEL
			}
		}

	}
}
