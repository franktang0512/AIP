package algorithm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

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

//	public static BufferedImage MakeGussianWhiteNoise(double variance, int length, int width ){
//		
//		return null;
//	}
	
	
	public BufferedImage FixImageSize(BufferedImage ori) {		
		
		int exportWidth = (ori.getWidth()%2==1?ori.getWidth():ori.getWidth()-1) ;
		int exportHeight = (ori.getHeight()%2==1?ori.getHeight():ori.getHeight()-1) ;

		BufferedImage fixed = new BufferedImage(exportWidth, exportHeight, ori.getType());
		Graphics2D g2d = fixed.createGraphics();
		g2d.drawImage(ori,0,0,exportWidth,exportHeight,null);
		g2d.dispose();
		
		return fixed ;
	}
//	public BufferedImage getPureNoise(BufferedImage img,BufferedImage noised_imag) {
//		
//		BufferedImage pure_noise =new BufferedImage(noised_imag.getWidth(), noised_imag.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
//		for(int i =0;i<pure_noise.getWidth();i++) {
//			for(int j =0;j<pure_noise.getHeight();j++) {
//				
//				
//				
//				
//				
//				
//                int color = noised_imag.getRGB(i, j);
//                int color2 =img.getRGB(i, j);
//                int gray1,gray2;
//                int r = (color >> 16) & 0xff ;
//                int g = (color >> 8) & 0xff ;
//                int b = color & 0xff ;
//                gray1 = ( int ) (0.3 * r + 0.59 * g + 0.11 * b);
//		        Color c = new Color(gray1, gray1, gray1);
//		        gray1 = c.getRGB();		
//		        
//		        r = (color2 >> 16) & 0xff ;
//                g = (color2 >> 8) & 0xff ;
//                b = color2 & 0xff ;
//                gray2 = ( int ) (0.3 * r + 0.59 * g + 0.11 * b);
//		        c = new Color(gray2, gray2, gray2);
//		        gray2 = c.getRGB();	
//		        
//		        
//		        
//
//                
//				pure_noise.setRGB(i,j,(gray1-gray2));
//				
//			}
//			
//		} 
//			
//		
//		
//		return pure_noise;
//	}
	public static int[] range(int n, double prob) {

		
//		prob = 1/prob;
//		double res = ((100 * prob)/10);
		double res = 200/prob;		
		int[]array = new int[(int)res];
		array[0]= 1;
		array[1]=255;
		
		for (int i = 2 ; i <= res - 2; i++)
		{
			array[i] = n;
		}
	    int rnd = new Random().nextInt(array.length);
	    int result[] = new int[] {array[rnd],(n==array[rnd]?0:1)};
	    return result;
	}
	
	
	public BufferedImage[] AddPSNoise(BufferedImage img,double rate) {
		int grayscale =256;
		BufferedImage noised = RGBtoGray(FixImageSize(img));
		BufferedImage pure_noise =new BufferedImage(noised.getWidth(), noised.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
		Random random = new Random();
		
		double salt = 0.05, pepper = 0.05; 
		for(int i=0; i<pure_noise.getWidth(); i++){
	         
            for(int j=0; j<pure_noise.getHeight(); j++){
	               Color c = new Color(128,128,128);		               
	               pure_noise.setRGB(i,j,c.getRGB());
            }
        }
		
		for(int i=0; i<noised.getWidth(); i++){
	         
            for(int j=0; j<noised.getHeight(); j++){
            
               Color c = new Color(noised.getRGB(i, j));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
               int []rgb = range(red+green+blue,rate);
               Color newColor = new Color(rgb[0],rgb[0],rgb[0]);
               noised.setRGB(i,j,newColor.getRGB());
               if(rgb[1]==1) {
            	   
            	   pure_noise.setRGB(i,j,newColor.getRGB());
               }
//               
               
            }
         }		
		BufferedImage[] result = new BufferedImage[] {noised,pure_noise};		
		return result;
	}
	
	public BufferedImage[] AddGuNoise(BufferedImage img,double standard) {
		int grayscale =256;
		BufferedImage noised = RGBtoGray(FixImageSize(img));
		BufferedImage pure_noise =new BufferedImage(noised.getWidth(), noised.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
		for(int i =0;i<img.getHeight()-1;i++) {
			for(int j =0;j+1<img.getWidth()-2;j+=2) {
//				if(j>img.getWidth())
				double  r1,r2;
				double z1,z2;
//				r1 = 
						
				Random random = new Random();
				
				r1 =random.nextDouble();
				r2 =random.nextDouble();
				
				z1 = (standard* Math.cos(2*Math.PI*r2)*Math.sqrt((-2) *Math.log(r1)));
				z2 = (standard* Math.sin(2*Math.PI*r2)*Math.sqrt((-2) *Math.log(r1)));

				double gray1;//= noised.getRGB(j, i);
				
				
                int color = noised.getRGB(j, i);
                int r = (color >> 16) & 0xff ;
                int g = (color >> 8) & 0xff ;
                int b = color & 0xff ;
                gray1 = ( int ) (0.3 * r + 0.59 * g + 0.11 * b);			
				
				double gray2;//= noised.getRGB(j+1, i);
				
	             color = noised.getRGB(j+1, i);
	             r = (color >> 16) & 0xff ;
	             g = (color >> 8) & 0xff ;
	             b = color & 0xff ;
				
	             gray2 = ( int ) (0.3 * r + 0.59 * g + 0.11 * b);
				
				
				int pix1 = (int)(gray1+z1);
				int pix2 = (int)(gray2+z2);
				
				
				
				if(pix1<0) {
					pix1=0;					
				}else if(pix1>grayscale -1) {
					pix1=grayscale -1;
				}
				
				
				if(pix2<0) {
					pix2=0;					
				}else if(pix2>grayscale -1) {
					pix2=grayscale -1;
				}
				
				
		        Color c = new Color(pix1, pix1, pix1);
		        pix1 = c.getRGB();				
				noised.setRGB(j, i,pix1);
				
				c = new Color(pix2, pix2, pix2);
		        pix2 = c.getRGB();					
		        noised.setRGB(j+1, i,pix2);	        
		        
		        
		        z1= (z1+128<0?0:(z1+128>255?255:z1+128));
		        int z11 = (int)z1;
		        c = new Color(z11, z11, z11);
		        pure_noise.setRGB(j,i,c.getRGB());
		        
		        
		        z2= (z2+128<0?0:(z2+128>255?255:z2+128));
		        int z22 = (int)z2;
		        c = new Color(z22, z22, z22);	        
		        
		        pure_noise.setRGB(j+1,i,c.getRGB());
			}			
		}		
		BufferedImage[] result = new BufferedImage[] {noised,pure_noise};		
		return result;
	}
	
	
	
	
	

}
