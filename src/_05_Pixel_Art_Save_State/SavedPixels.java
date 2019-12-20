package _05_Pixel_Art_Save_State;

import java.io.Serializable;

public class SavedPixels implements java.io.Serializable {
	public Pixel[][] pixelArray;
	public int windowWidth;
	public int windowHeight;
	public int pixelWidth;
	public int pixelHeight;
	public int rows;
	public int columns;
	
	String Test;
	public Pixel pix;
	public SavedPixels(Pixel[][] in, int wW, int wh, int pW, int pH, int r, int c) {
		this.pixelArray = in;
		this.windowWidth = wW;
		this.windowHeight = wh;
		this.pixelWidth = pW;
		this.pixelHeight = pH;
		this.rows = r;
		this.columns = c;

	}
}
