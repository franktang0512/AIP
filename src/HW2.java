import javax.swing.JFrame;

import algorithm.GUIMaker;
import algorithm.Histogram;
import algorithm.ImageFile;
import algorithm.ProcessImage;

public class HW2 {

	public static void main(String[] args) {
		ProcessImage processimage = new ProcessImage(); 
		ImageFile imagefile = new ImageFile();
		GUIMaker gui = new GUIMaker(imagefile,processimage);		
		gui.SelecFiletWindow("hw2");	
		
	}
}
