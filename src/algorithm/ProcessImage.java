package algorithm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import java.util.Random;

public class ProcessImage {
	double core[][];
	float h_core[],v_core[];
	public ProcessImage() {
		
		//default core
		core = new double[5][5];
		//fill with 1, not gon /(core_size*core_size) because it gon tend to turn 0. thus, we will make it average later
		for(int i =0;i<core.length;i++) {
			for(int j =0; j<core.length;j++) {
				core[i][j]=1;
			}
		}
		h_core = new float[]{
				-1, 0, 0, 0, 1,
	 			 1, 0, 0, 0,-1,
	  			-1, 0, 0, 0, 1,
	  			 1, 0, 0, 0,-1,
	  			-1, 0, 0, 0, 1
	  			};

		v_core = new float[] {
				-1, 1,-1, 1,-1,
 			    0 ,0 , 0, 0, 0,
 			    0 ,0 , 0, 0, 0,
 			    0 ,0 , 0, 0, 0,
 			    1 ,-1, 1,-1, 1
 			    };
		
		
		
		
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

	public BufferedImage copy(BufferedImage img_) {
    	BufferedImage img = new BufferedImage(img_.getWidth(),img_.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
    	for(int i =0;i<img.getWidth();i++) {
    		for(int j =0;j<img.getHeight();j++) {
    			img.setRGB(i, j, img_.getRGB(i, j));
    		}	
    	}
    	return img;
	}
	public BufferedImage FixImageSize(BufferedImage ori) {		
		
		int exportWidth = (ori.getWidth()%2==1?ori.getWidth():ori.getWidth()-1) ;
		int exportHeight = (ori.getHeight()%2==1?ori.getHeight():ori.getHeight()-1) ;

		BufferedImage fixed = new BufferedImage(exportWidth, exportHeight, ori.getType());
		Graphics2D g2d = fixed.createGraphics();
		g2d.drawImage(ori,0,0,exportWidth,exportHeight,null);
		g2d.dispose();
		
		return fixed ;
	}

	public static int[] range(int n, double prob) {

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
		
	public BufferedImage Smooth(BufferedImage img, int core_size) {
			
		// we want this to return
		BufferedImage smooth_img = this.RGBtoGray(img);		
		//for temp use. this gon be compliemted with 0 on the each edge of itself depend on the size of the core
		BufferedImage pro_convo = new BufferedImage(smooth_img.getWidth()+core_size-1, smooth_img.getHeight()+core_size-1, BufferedImage.TYPE_BYTE_GRAY);
		//process to make compliemted imgage

		for(int i =0;i<pro_convo.getWidth();i++) {
			for(int j =0;j<pro_convo.getHeight();j++) {
				int zero =0;
				Color c = new Color(zero,zero,zero);
				//filled with 0s
				if((i>=0&&i<core_size/2)||
   				   (j>=0&&j<core_size/2)||
				   (i<=pro_convo.getWidth()-1&&i>pro_convo.getWidth()-(core_size/2))||
				   (j<=pro_convo.getHeight()-1&&j>pro_convo.getHeight()-(core_size/2))) {
					pro_convo.setRGB(i, j, c.getRGB());
					continue;
				}		
  				//fill the origin one
				if((i>(core_size/2))&&
						(j>(core_size/2))&&
						(i<pro_convo.getWidth()-(core_size/2))&&
						(j<pro_convo.getHeight()-(core_size/2))) {
//					System.out.print("(wxh)="+i+"x"+j+" ");
					pro_convo.setRGB(i, j, smooth_img.getRGB(i-(core_size/2), j-(core_size/2)));
				}	
//				System.out.println();
			}
		}
//		
//		for(int i =0;i<pro_convo.getWidth();i++) {
//			for(int j =0;j<pro_convo.getHeight();j++) {
//				System.out.print(pro_convo.getRGB(i, j));
//			}
//			System.out.println();
//		} 
//		System.out.println("(wxh)="+smooth_img.getWidth()+"x"+smooth_img.getHeight());
//		System.out.println("(wxh)="+pro_convo.getWidth()+"x"+pro_convo.getHeight());
		
		
		//make a kernel(core)

		//the for loop is is scaning the origin -> gray
		for(int i =0;i<smooth_img.getWidth();i++) {
			for(int j =0;j<smooth_img.getHeight();j++) {
				// for sum up
				double r = 0;
				//the for loop is scaning through core
				for(int k =0;k<core.length;k++) {
					for(int l =0;l<core.length;l++) {
//						System.out.println("(i+k, j+l)="+i+" "+k+" "+j+" "+l);
						int gray= pro_convo.getRGB(i+k, j+l)& 0xFF;
						//average here cuz it's big enough not to be turned 0
						r+=gray*core[k][l]/(core.length*core.length);							
					}
				}					
				int rr = (int)r;
//				if(rr>255||rr<0) {
//					rr =128;
//				}
				if(rr<0) {
					rr=0;
				}
				if(rr>255){
					rr=255;
				}
				Color c = new Color(rr,rr,rr);			
				smooth_img.setRGB(i, j, c.getRGB());
			}
		}	
		return smooth_img;
	}
	public BufferedImage detect_manual(BufferedImage img, int core_size) {
		BufferedImage smooth_img = this.RGBtoGray(img);		
		//for temp use. this gon be compliemted with 0 on the each edge of itself depend on the size of the core
		BufferedImage pro_convo = new BufferedImage(img.getWidth()+2*((int)(core_size/2)), img.getHeight()+2*((int)(core_size/2)), BufferedImage.TYPE_BYTE_GRAY);
		//process to make compliemted imgage
		int zero =0;
		for(int i =0;i<pro_convo.getWidth();i++) {
			for(int j =0;j<pro_convo.getHeight();j++) {
				//filled with 0s
				if(i>=0&&i<core_size/2) {
					Color c = new Color(zero,zero,zero);
					pro_convo.setRGB(i, j, c.getRGB());
					continue;
				}
				if(j>=0&&j<core_size/2) {
					Color c = new Color(zero,zero,zero);
					pro_convo.setRGB(i, j, c.getRGB());					
					continue;
				}
				
				if(i<=pro_convo.getWidth()-1&&i>pro_convo.getWidth()-(core_size/2)-1) {
					Color c = new Color(zero,zero,zero);
					pro_convo.setRGB(i, j, c.getRGB());
					continue;
				}
				if(j<=pro_convo.getHeight()-1&&j>pro_convo.getHeight()-(core_size/2)-1) {
					Color c = new Color(zero,zero,zero);
					pro_convo.setRGB(i, j, c.getRGB());					
					continue;
				}
  				//fill the origin one
				if(i>=(core_size/2)&&j>=(core_size/2)) {
					pro_convo.setRGB(i, j, smooth_img.getRGB(i-(core_size/2), j-(core_size/2)));
				}				
			}
		}

		//the for loop is is scaning the origin -> gray
		for(int i =1;i<smooth_img.getWidth();i++) {
			for(int j =1;j<smooth_img.getHeight();j++) {
				// for sum up
				double r = 0;
				//the for loop is scaning through core
				for(int k =0;k<core.length;k++) {
					for(int l =0;l<core.length;l++) {
						int gray= pro_convo.getRGB(i+k, j+l)& 0xFF;
						//average here cuz it's big enough not to be turned 0
						r+=gray*core[k][l]/(core.length*core.length);							
					}
				}					
				int rr = (int)r;
				if(rr>255||rr<0) {
					rr =128;
				}
				Color c = new Color(rr,rr,rr);			
				smooth_img.setRGB(i, j, c.getRGB());
			}
		}	
		return smooth_img;
	}
	//try to program in java package
    public BufferedImage detect(BufferedImage img_)
    {
    	BufferedImage img = copy(img_);
    	BufferedImage Gx, Gy;

    	int kernel_h_size =(int)Math.sqrt(h_core.length);
    	int kernel_v_size =(int)Math.sqrt(v_core.length);
        Kernel MatrixA = new Kernel(kernel_h_size, kernel_h_size, h_core);
        Kernel MatrixB = new Kernel(kernel_v_size, kernel_v_size, v_core);
        // Convolving the matrices. I hate math.
        ConvolveOp convolve1 = new ConvolveOp(MatrixA);
        ConvolveOp convolve2 = new ConvolveOp(MatrixB);
        
        Gx = convolve1.filter(img, null);
        Gy = convolve2.filter(img, null);
         

         for (int i=0; i<img.getWidth(); i++) {
            for (int j=0; j<img.getHeight(); j++) {
                double result=0;
	       	     int derp = Gx.getRGB(i,j);
	    	     int herp = Gy.getRGB(i,j);
	    	     result = Math.sqrt(Math.pow(derp, 2.0) + Math.pow(herp, 2.0));
                if(result < 20726564.99) {
                	int www= 0;
                    img.setRGB(i,j,new Color(www,www,www).getRGB());
                } else {
                	int bbb = 255;
                    img.setRGB(i,j,new Color(bbb,bbb,bbb).getRGB());
                }
            }
         }
       return img;
    }
    
    
    BufferedImage equalize(BufferedImage src){
        BufferedImage nImg = new BufferedImage(src.getWidth(), src.getHeight(),
                             BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = src.getRaster();
        WritableRaster er = nImg.getRaster();
        int totpix= wr.getWidth()*wr.getHeight();
        int[] histogram = new int[256];

        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                histogram[wr.getSample(x, y, 0)]++;
            }
        }

        int[] chistogram = new int[256];
        chistogram[0] = histogram[0];
        for(int i=1;i<256;i++){
            chistogram[i] = chistogram[i-1] + histogram[i];
        }
        int Hc =0;
        for(int i=0;i<chistogram.length;i++) {
        	if(chistogram[i]>0) {
        		Hc=chistogram[i];
        		break;
        	}
        }

        float[]  T= new float[256];
        for(int i=0;i<256;i++){
//            T[i] =  (float)((chistogram[i]*255.0)/(float)totpix);
            T[i] =  (float)(((chistogram[i]-Hc)*255.0)/(float)(totpix-Hc));
        }

        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                int nVal = (int) T[wr.getSample(x, y, 0)];
                er.setSample(x, y, 0, nVal);
            }
        }
        nImg.setData(er);
        return nImg;
    }
    
    
    
    
    public void setCore(double[][] coreseted) {
    	
    	
    	core =coreseted;
//		core = new double[core_size][core_size];
//		//fill with 1, not gon /(core_size*core_size) because it gon tend to turn 0. thus, we will make it average later
//		for(int i =0;i<core.length;i++) {
//			for(int j =0; j<core.length;j++) {
//				core[i][j]=1;
//			}
//		}
    }
    public int getCore() {
		return core.length;
    }
    
    public void setHCore(float [] hcore) {
		h_core = hcore;
    }
    public void setVCore(float [] vcore) {
		v_core = vcore;
    }
//    public int getHCore() {
//		return this.h_core;
//    }
    
    
    

	

}
