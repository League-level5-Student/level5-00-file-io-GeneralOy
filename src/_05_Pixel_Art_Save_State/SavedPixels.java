package _05_Pixel_Art_Save_State;

public class SavedPixels implements java.io.Serializable {
	Pixel[][] pixelArray;

	public SavedPixels(Pixel[][] inArray) {
		this.pixelArray = inArray;
	}
}
