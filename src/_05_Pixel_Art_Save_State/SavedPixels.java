package _05_Pixel_Art_Save_State;

import java.io.Serializable;

public class SavedPixels implements java.io.Serializable {
	public Pixel[][] pixelArray;
	String Test;
	public Pixel pix;
	public SavedPixels(/**/Pixel in/*String test/**/) {
		this.pix = in;
		//this.Test = test;

	}
}
