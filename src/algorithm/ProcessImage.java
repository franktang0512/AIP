package algorithm;

import java.awt.Color;
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
	public int [] getBrightnessIntensity(BufferedImage img) {
		int [] temp = new int[256];
		for(int i =0;i<img.getWidth();i++) {
			for(int j =0;j<img.getHeight();j++) {				
				Color c = new Color(img.getRGB(i,j));
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				int x = (red+green+blue)/3;
				temp[x]++;
			}
		}
		
		for(int i :temp) {
			
			System.out.print(i);
			System.out.print(' ');

		}
		System.out.println();
		return temp;
	}
	public static BufferedImage RGBtoGray(BufferedImage img) {
		int []intensity = new int [255];
//		BufferedImage temp = new BufferedImage();
		BufferedImage grayIm=new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY); 
//		getBrightnessIntensity(img);
	    for(int i= 0 ; i < grayIm.getWidth() ; i++){  
	        for(int j = 0 ; j < grayIm.getHeight(); j++){  
	        int rgb = img.getRGB(i, j);  
	        
	        
	        Color c = new Color(img.getRGB(i,j));
//	        System.out.println("or("+img.getRGB(i, j)+",r:"+c.getRed()+",g:"+c.getGreen()+",b:"+c.getBlue());
	        grayIm.setRGB(i, j, rgb);  
	        c = new Color(grayIm.getRGB(i,j));
//	        System.out.println("pr("+grayIm.getRGB(i, j)+",r:"+c.getRed()+",g:"+c.getGreen()+",b:"+c.getBlue());
	        
	        }  
	    }  
//	    getBrightnessIntensity(grayIm);
		return grayIm;
	}
	public static BufferedImage  RGBtoR(BufferedImage img){
		int []intensity = new int [255];
//		BufferedImage temp = new BufferedImage();
		BufferedImage redIm=new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB); 
//		getBrightnessIntensity(img);
	    for(int i= 0 ; i < redIm.getWidth() ; i++){  
	        for(int j = 0 ; j < redIm.getHeight(); j++){  
	        int rgb = img.getRGB(i, j);  
	        int red = rgb & 0x00ff0000;

	        
	        Color c = new Color(img.getRGB(i,j));
//	        System.out.println("or("+img.getRGB(i, j)+",r:"+c.getRed()+",g:"+c.getGreen()+",b:"+c.getBlue());
	        redIm.setRGB(i, j, red);  
//	        c = new Color(redIm.getRGB(i,j));
//	        System.out.println("pr("+grayIm.getRGB(i, j)+",r:"+c.getRed()+",g:"+c.getGreen()+",b:"+c.getBlue());
	        
	        }  
	    }  
//	    getBrightnessIntensity(grayIm);
		return redIm;
	}
	public static BufferedImage  RGBtoG(BufferedImage img){
		int []intensity = new int [255];
//		BufferedImage temp = new BufferedImage();
		BufferedImage greenIm=new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB); 
//		getBrightnessIntensity(img);
	    for(int i= 0 ; i < greenIm.getWidth() ; i++){  
	        for(int j = 0 ; j < greenIm.getHeight(); j++){  
	        int rgb = img.getRGB(i, j);  
	        int green = (rgb) & 0x0000ff00;

	        
	        Color c = new Color(img.getRGB(i,j));
//	        System.out.println("or("+img.getRGB(i, j)+",r:"+c.getRed()+",g:"+c.getGreen()+",b:"+c.getBlue());
	        greenIm.setRGB(i, j, green);  
//	        c = new Color(redIm.getRGB(i,j));
//	        System.out.println("pr("+grayIm.getRGB(i, j)+",r:"+c.getRed()+",g:"+c.getGreen()+",b:"+c.getBlue());
	        
	        }  
	    }  
//	    getBrightnessIntensity(grayIm);
		return greenIm;	
		
		
		
        
        
	}
	public static BufferedImage  RGBtoB(BufferedImage img){
		int []intensity = new int [255];
//		BufferedImage temp = new BufferedImage();
		BufferedImage blueIm=new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB); 
//		getBrightnessIntensity(img);
	    for(int i= 0 ; i < blueIm.getWidth() ; i++){  
	        for(int j = 0 ; j < blueIm.getHeight(); j++){  
	        int rgb = img.getRGB(i, j);  
	        int  blue= (rgb) & 0x000000ff;

	        
	        Color c = new Color(img.getRGB(i,j));
//	        System.out.println("or("+img.getRGB(i, j)+",r:"+c.getRed()+",g:"+c.getGreen()+",b:"+c.getBlue());
	        blueIm.setRGB(i, j, blue);  
//	        c = new Color(redIm.getRGB(i,j));
//	        System.out.println("pr("+grayIm.getRGB(i, j)+",r:"+c.getRed()+",g:"+c.getGreen()+",b:"+c.getBlue());
	        
	        }  
	    }  
//	    getBrightnessIntensity(grayIm);
		return blueIm;	
		
		
	}
}
