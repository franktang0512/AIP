import algorithm.GUIMaker;
import algorithm.ImageFile;
import algorithm.ProcessImage;

public class HW3 {

	public static void main(String[] args) {
		ProcessImage processimage = new ProcessImage(); 
		ImageFile imagefile = new ImageFile();
		GUIMaker gui = new GUIMaker(imagefile,processimage);		
		gui.SelecFiletWindow("hw3");	
	}

}
