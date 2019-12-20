package _05_Pixel_Art_Save_State;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JPanel;

public class GridPanel extends JPanel {

	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	public int rows;
	public int cols;

	/** 1. Create a 2D array of pixels. Do not initialize it yet. */
	Pixel[][] pixelArray;

	private Color color;

	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;

		this.setPixelWidth(windowWidth / cols);
		this.setPixelHeight(windowHeight / rows);

		color = Color.BLACK;

		setPreferredSize(new Dimension(windowWidth, windowHeight));

		/** 2. Initialize the pixel array using the rows and cols variables. */
		pixelArray = new Pixel[this.rows][this.cols];

		/** 3. Iterate through the array and initialize each element to a new pixel. */
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				System.out.println(i + "," + j);
				pixelArray[j][i] = new Pixel(j, i);
			}
		}

	}

	public void setColor(Color c) {
		color = c;
	}

	public void clickPixel(int mouseX, int mouseY) {
		pixelArray[mouseX / (windowHeight / rows)][mouseY / (windowWidth / cols)].color = this.color;
		/**
		 * 5. Use the mouseX and mouseY variables to change the color // of the pixel
		 * that was clicked. *HINT* Use the pixel's dimensions.
		 */
	}

	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				g.setColor(pixelArray[j][i].color);
				g.fillRect(j * (windowHeight / rows), i * (windowWidth / cols), windowWidth / cols,
						windowHeight / rows);
				g.setColor(Color.BLACK);
				g.drawRect(j * (windowHeight / rows), i * (windowWidth / cols), windowWidth / cols,
						windowHeight / rows);
			}
		}
		/**
		 * 4. Iterate through the array. // For every pixel in the list, fill in a
		 * rectangle using the pixel's color. // Then, use drawRect to add a grid
		 * pattern to your display.
		 */

	}

	public int getPixelWidth() {
		return pixelWidth;
	}

	public void setPixelWidth(int pixelWidth) {
		this.pixelWidth = pixelWidth;
	}

	public int getPixelHeight() {
		return pixelHeight;
	}

	public void setPixelHeight(int pixelHeight) {
		this.pixelHeight = pixelHeight;
	}
}
