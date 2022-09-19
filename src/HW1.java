import algorithm.GUIMaker;
import algorithm.ImageFile;
import algorithm.ProcessImage;

public class HW1 {
	public static void main(String[] args) throws Exception {
		ProcessImage processimage = new ProcessImage(); 
		ImageFile imagefile = new ImageFile();
		GUIMaker gui = new GUIMaker(imagefile,processimage);		
		gui.SelecFiletWindow("hw1");
	}
}
