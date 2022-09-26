package algorithm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ImageFile {
	String filepath;
	BufferedImage original;	
	BufferedImage processed;	
	public ImageFile() {}
	

	public void read(String path) throws IOException {
		filepath = path;
		switch(getFileType(filepath)) {
		case "jpg":
		case "bmp":
		case "JPG":
		case "BMP":
			original = ImageIO.read(new File(filepath));
			break;
		case "ppm":
		case "PPM":
			ReadPPM(filepath);
			break;
		default:
	
	}
	}
	public void save() throws IOException {
		ImageIO.write(processed, "BMP", new File("./output.bmp"));		
		ImageIO.write(ProcessImage.RGBtoGray(original), "JPG", new File("./output.jpg"));	
	}
//	BufferedImage precessedImage
	public void ReadPPM(String filename) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
        String magic = sc.next();
        int width = sc.nextInt();
        int height = sc.nextInt();
        int depth = sc.nextInt();
        int[][][] pixels;
        pixels = new int[height][width][3];
        
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                for (int k = 0; k < 3; k++) {
                    pixels[i][j][k] = sc.nextInt();
                }
            }
        }
        original = PPMToBuffer(pixels);
        

	}
	
	public String getFileType(String fileName) {
		String fe = "";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    fe = fileName.substring(i+1);
		}
		return fe;
	}
	

	public BufferedImage getBufferImage() {
		return original;
	}
	public void setProcessedImage(BufferedImage pb) {		
		processed = pb;
	}
	public BufferedImage getProcessedImage() {		
		return processed ;
	}
	
	public BufferedImage PPMToBuffer( int[][][] pix )
	{
	    int width  = pix.length;
	    int height = pix[0].length;
	    BufferedImage  temp = new BufferedImage( width,height, BufferedImage.TYPE_INT_RGB);	    
	    for( int i=0 ; i < width ; i++ ) {
	    	for( int j=0 ; j < height ; j++ ) {
	    		Color mycolor = new Color(pix[i][j][0], pix[i][j][1], pix[i][j][2]);
	    		int rgb = mycolor.getRGB();
	    		
	    		temp.setRGB(i,j ,rgb);
	    	}    
	    }
	    return temp;
	}
	public double getHeight() {
		return original.getHeight();
		
	}
	public double getWidth() {
		return original.getWidth();
		
	}

	public void clear() {
		 filepath="";
		 original=null;	
		 processed=null;
	}
	
}
