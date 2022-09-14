package algorithm;

import java.awt.image.BufferedImage;

public class ProcessImage {

	public ProcessImage() {
		// TODO Auto-generated constructor stub
	}
	//rotate
	public BufferedImage Rotate( BufferedImage img )
	{
	    int         width  = img.getWidth();
	    int         height = img.getHeight();
	    BufferedImage  precessedImage = new BufferedImage( height, width, img.getType() );
	    
	    for( int i=0 ; i < width ; i++ )
	        for( int j=0 ; j < height ; j++ )
	        	precessedImage.setRGB( height-1-j, i, img.getRGB(i,j) );
	    
	    return precessedImage;
	}
	

}
