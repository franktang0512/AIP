package algorithm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class GUIMaker {
	String filepath="";
	ImageFile imagefile;
	ProcessImage prcessimage;
	public GUIMaker(ImageFile im,ProcessImage pi) {
		imagefile = im;
		prcessimage = pi;
	}
	public void SelecFiletWindow(String hw) {
		
		JFrame File_Chooser_Frame = new JFrame("AIP61047115S");
        File_Chooser_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel File_Chooser_Panel = new JPanel();
        LayoutManager Layout_Manager = new FlowLayout();
        File_Chooser_Panel.setLayout(Layout_Manager);

        JButton Choose_Button = new JButton("Choose an Image File");
        final JLabel J_Label = new JLabel();
        Choose_Button.addActionListener(new ActionListener() {
            @Override
               public void actionPerformed(ActionEvent e) {
                   JFileChooser J_File_Chooser = new JFileChooser();
                   J_File_Chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                   int option = J_File_Chooser.showOpenDialog(File_Chooser_Frame);
                   if(option == JFileChooser.APPROVE_OPTION){
                       File file = J_File_Chooser.getSelectedFile();
                       J_Label.setText("Selected: " + file.getPath());
                       filepath = file.getPath();
                       File_Chooser_Frame.dispose();
                       try {
                    	   imagefile.read(filepath);
                       }catch (Exception e1) {
                    	   e1.printStackTrace();
                       }
                       
                       
                       if(hw.equals("hw1")) {
                    	   ShowDEMO();
                       }
                       if(hw.equals("hw2")) {
                    	   HW2withHW1();
                    	   
                       }
                       if(hw.equals("hw3")) {
                    	   HW3withHW1();
                    	   
                       }
                       
                       
                   }
                   else{
                   	J_Label.setText("Command Canceled");
                   }
               }
           });

	    File_Chooser_Panel.add(Choose_Button);
	    File_Chooser_Panel.add(J_Label);
	    File_Chooser_Frame.getContentPane().add(File_Chooser_Panel, BorderLayout.CENTER);
        File_Chooser_Frame.setSize(560, 200);
        File_Chooser_Frame.setLocationRelativeTo(null);
        File_Chooser_Frame.setVisible(true);
		
	}
	
	public void ShowDEMO() {
		JFrame frame = new JFrame("AIP61047115S");

		JOptionPane.showMessageDialog(frame, "Image formate: ."+imagefile.getFileType(imagefile.filepath)+"\nImage size:"+imagefile.getWidth()+"x"+imagefile.getHeight());
		JPanel panel = new JPanel(new GridLayout(2,3));
//		BufferedImage image  = ImageIO.read(new File(filepath));

	    JLabel label = new JLabel(new ImageIcon(imagefile.getBufferImage()));
	    JLabel label1 = new JLabel("                                    ➔➔➔➔➔➔➔➔");
	    
	    JLabel label2 = new JLabel(/*new ImageIcon(rotateCw(image))*/);
	    panel.add(label);
	    panel.add(label1);
	    panel.add(label2);
	    
	    
	    
		Button load = new Button("load");
		load.setPreferredSize(new Dimension(40, 40));
		Button convert = new Button("convert");
		convert.setPreferredSize(new Dimension(40, 40));
		Button save = new Button("save");
		save.setPreferredSize(new Dimension(40, 40));
		
	    panel.add(load);
	    
	    load.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		imagefile.clear();
	        		SelecFiletWindow("hw1");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	frame.dispose();	        	
	        }
	        
	    });
	    
	    convert.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 
	        	if(imagefile.getProcessedImage()==null) {
	        		imagefile.setProcessedImage(prcessimage.Rotate(imagefile.getBufferImage()));
	        	}else {
	        		imagefile.setProcessedImage(prcessimage.Rotate(imagefile.getProcessedImage()));
	        	}
	        	label2.setIcon(new ImageIcon(imagefile.getProcessedImage()));
	        	frame.repaint();	        	
	        }
	        
	    });
	    save.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	        		
	        	try {
	        		imagefile.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	
	        }
	        
	    });
	    
	    panel.add(convert);
	    panel.add(save);
	    
	    frame.getContentPane().add(panel); 
	    frame.setPreferredSize(new Dimension(1000, 800));
	    frame.pack();
	    frame.setVisible(true);	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	}

	
	public void HW2withHW1() {
		JFrame frame = new JFrame("AIP61047115S");

		JOptionPane.showMessageDialog(frame, "Image formate: ."+imagefile.getFileType(imagefile.filepath)+"\nImage size:"+imagefile.getWidth()+"x"+imagefile.getHeight());
		JPanel panel = new JPanel(new GridLayout(2,3));
//		BufferedImage image  = ImageIO.read(new File(filepath));

	    JLabel label = new JLabel(new ImageIcon(imagefile.getBufferImage()));
	    JLabel label1 = new JLabel();
	    
	    JLabel label2 = new JLabel(/*new ImageIcon(rotateCw(image))*/);
	    panel.add(label);
	    panel.add(label1);
	    panel.add(label2);
	    
	    
	    
		Button load = new Button("load");
		load.setPreferredSize(new Dimension(40, 40));
		
		JPanel panel_function = new JPanel(new GridLayout(3,1));
		
		
		Button convert = new Button("convert");
		convert.setPreferredSize(new Dimension(40, 40));

		JPanel panel_color = new JPanel(new GridLayout(1,4));
		Button gray = new Button("turn gray");
		
		Button red = new Button("turn red");

		Button green = new Button("turn green");

		Button blue = new Button("turn blue");
		panel_color.add(gray);
		panel_color.add(red);
		panel_color.add(green);
		panel_color.add(blue);
		
		Button histogram = new Button("histogram");
		convert.setPreferredSize(new Dimension(40, 40));		
		
		
		panel_function.add(convert);
		
		panel_function.add(panel_color);
		panel_function.add(histogram);
		
		
		Button save = new Button("save");
		save.setPreferredSize(new Dimension(40, 40));
		
	    panel.add(load);
	    
	    load.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		imagefile.clear();
	        		SelecFiletWindow("hw2");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	frame.dispose();	        	
	        }
	        
	    });
	    
	    convert.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 
	        	if(imagefile.getProcessedImage()==null) {
	        		imagefile.setProcessedImage(prcessimage.Rotate(imagefile.getBufferImage()));
	        		
	        	}else {
	        		imagefile.setProcessedImage(prcessimage.Rotate(imagefile.getProcessedImage()));
	        	}

	        	label2.setIcon(new ImageIcon(imagefile.getProcessedImage()));
	        	frame.repaint();	        	
	        }
	        
	        
	        
	        
	    });
	    gray.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 

	        	label1.setIcon(new ImageIcon(prcessimage.RGBtoGray(imagefile.getBufferImage())));
	        	frame.repaint();	        	
	        }
	        
	        
	    });
	    red.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 

	        	label1.setIcon(new ImageIcon(prcessimage.RGBtoR(imagefile.getBufferImage())));
	        	frame.repaint();	        	
	        }
	        
	        
	    });
	    green.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 

	        	label1.setIcon(new ImageIcon(prcessimage.RGBtoG(imagefile.getBufferImage())));
	        	frame.repaint();	        	
	        }
	        
	        
	    });
	    blue.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 

	        	label1.setIcon(new ImageIcon(prcessimage.RGBtoB(imagefile.getBufferImage())));
	        	frame.repaint();	        	
	        }
	        
	        
	    });
	    
	    histogram.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	
	        	makeBrightnessIntensityHistogram();
	        }	        
	    });
	    save.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	        		
	        	try {
	        		imagefile.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	        	
	        }	        
	    });
	    
	    panel.add(panel_function);
	    panel.add(save);
	    
	    frame.getContentPane().add(panel); 
	    frame.setPreferredSize(new Dimension(1000, 800));
	    frame.pack();
	    frame.setVisible(true);	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void makeBrightnessIntensityHistogram() {
		
		Histogram h = new Histogram();
		imagefile.getBufferImage();
		
        JFrame f = new JFrame("Histogram");

        JPanel histogram_panel = new JPanel(new GridLayout(1, 2));
        JPanel control_panel = new JPanel(new GridLayout(0, 1));
        histogram_panel.add(h.createChart(imagefile.getBufferImage(),255));
        histogram_panel.add(h.createChartPanel(imagefile.getBufferImage()));
        control_panel.add(h.createControlPanel());
        
        f.add(histogram_panel);
        f.add(control_panel, BorderLayout.SOUTH);
        f.setPreferredSize(new Dimension(1300, 400));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        		
	}
	public void HW3withHW1() {
		JFrame frame = new JFrame("AIP61047115S");

		JOptionPane.showMessageDialog(frame, "Image formate: ."+imagefile.getFileType(imagefile.filepath)+"\nImage size:"+imagefile.getWidth()+"x"+imagefile.getHeight());
		JPanel panel = new JPanel(new GridLayout(2,3));
//		BufferedImage image  = ImageIO.read(new File(filepath));

	    JLabel label = new JLabel(new ImageIcon(imagefile.getBufferImage()));
	    JLabel label1 = new JLabel();
	    
	    JLabel label2 = new JLabel(/*new ImageIcon(rotateCw(image))*/);
	    panel.add(label);
	    panel.add(label1);
	    panel.add(label2);
	    
	    
	    
		Button load = new Button("load");
		load.setPreferredSize(new Dimension(40, 40));
		
		JPanel panel_function = new JPanel(new GridLayout(4,1));
		
		
		Button convert = new Button("convert");
		convert.setPreferredSize(new Dimension(40, 40));

		JPanel panel_color = new JPanel(new GridLayout(1,4));
		Button gray = new Button("turn gray");
		
		Button red = new Button("turn red");

		Button green = new Button("turn green");

		Button blue = new Button("turn blue");
		panel_color.add(gray);
		panel_color.add(red);
		panel_color.add(green);
		panel_color.add(blue);
		
		Button histogram = new Button("histogram");	
		
		panel_function.add(convert);
		
		panel_function.add(panel_color);
		panel_function.add(histogram);
		
		JPanel panel_noise = new JPanel(new GridLayout(1,2));
		Button GaussianNoise = new Button("Gaussian Noise");
		Button PepperSaltNoise = new Button("Pepper-Salt Noise");
		panel_noise.add(GaussianNoise);
		panel_noise.add(PepperSaltNoise);
		panel_function.add(panel_noise);
		
		
		Button save = new Button("save");
		save.setPreferredSize(new Dimension(40, 40));
		
	    panel.add(load);
	    
	    load.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		imagefile.clear();
	        		SelecFiletWindow("hw3");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	frame.dispose();	        	
	        }
	        
	    });
	    
	    convert.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 
	        	if(imagefile.getProcessedImage()==null) {
	        		imagefile.setProcessedImage(prcessimage.Rotate(imagefile.getBufferImage()));
	        		
	        	}else {
	        		imagefile.setProcessedImage(prcessimage.Rotate(imagefile.getProcessedImage()));
	        	}

	        	label2.setIcon(new ImageIcon(imagefile.getProcessedImage()));
	        	frame.repaint();	        	
	        }
	        
	        
	        
	        
	    });
	    gray.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 

	        	label1.setIcon(new ImageIcon(prcessimage.RGBtoGray(imagefile.getBufferImage())));
	        	frame.repaint();	        	
	        }
	        
	        
	    });
	    red.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 

	        	label1.setIcon(new ImageIcon(prcessimage.RGBtoR(imagefile.getBufferImage())));
	        	frame.repaint();	        	
	        }
	        
	        
	    });
	    green.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 

	        	label1.setIcon(new ImageIcon(prcessimage.RGBtoG(imagefile.getBufferImage())));
	        	frame.repaint();	        	
	        }
	        
	        
	    });
	    blue.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	 

	        	label1.setIcon(new ImageIcon(prcessimage.RGBtoB(imagefile.getBufferImage())));
	        	frame.repaint();	        	
	        }
	        
	        
	    });
	    
	    histogram.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	
	        	makeBrightnessIntensityHistogram();
	        }	        
	    });
	    
	    GaussianNoise.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	
//	        	makeGaussianNoiseHistogram();
	        	makeNoiseSettingGUI("Gaussian");
	        }	        
	    });
	    PepperSaltNoise.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	
//	        	makeGaussianNoiseHistogram();
	        	makeNoiseSettingGUI("Pepper");
	        }	        
	    });
	    
	    
	    save.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	        		
	        	try {
	        		imagefile.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	        	
	        }	        
	    });
	    
	    panel.add(panel_function);
	    panel.add(save);
	    
	    frame.getContentPane().add(panel); 
	    frame.setPreferredSize(new Dimension(1000, 800));
	    frame.pack();
	    frame.setVisible(true);	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void makeNoiseSettingGUI(String s) {
		String sds = "Set the Standard Deviation σ";
		String rates = "Set the rate r";
		String title ="";
		String toldsettext="";
		if(s.equals("Gaussian")) {
			title = sds;
			toldsettext ="σ";
		}else if(s.equals("Pepper")) {
			title = rates;
			toldsettext ="r(%)";
		}
		JFrame frame = new JFrame(title);
//	    frame.getContentPane().add(panel); 
		
		JPanel panel = new JPanel(new FlowLayout());
		double sd=0;
		
		JLabel settext = new JLabel("Please set "+toldsettext+":"); 
		
		JTextField sdtext = new JTextField(15);
		Button check = new Button("set");
		
		check.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {	        	
	        	try {
	        		double d = Double.parseDouble(sdtext.getText().toString());		        	
		        	
		    		if(s.equals("Gaussian")) {
		    			
		    			makeGaussianNoiseHistogram(d);
		    		}else if(s.equals("Pepper")) {
		    			if(d>=0.05&&d<=100) {
		    				makePepperSaultNoiseHistogram(d);
		    			}else {
		    				JOptionPane.showMessageDialog(frame, "Please set r between 0.05 and 100.\n Or you have to wait for it so long");
		    			}	    			
		    		}
		    		frame.dispose();
	        	}catch(Exception eee) {
	        		JOptionPane.showMessageDialog(frame, "R u idiot?\n type in numeric instead thanks");
	        	}
	        	        	
	        }	        
	    });
		panel.add(settext);
		panel.add(sdtext);
		panel.add(check);
		frame.add(panel);
	    frame.setPreferredSize(new Dimension(350, 100));
	    frame.pack();
	    frame.setVisible(true);	  
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public void makeGaussianNoiseHistogram(double standard){
		JFrame frame = new JFrame("Gaussian Noise");
//	    frame.getContentPane().add(panel); 
		JPanel gn = new JPanel(new GridLayout(2, 3));
		
		BufferedImage a = prcessimage.RGBtoGray(imagefile.getBufferImage());
		BufferedImage [] b = prcessimage.AddGuNoise(imagefile.getBufferImage(),standard);
		BufferedImage noed = b[0];
		BufferedImage pure_no = b[1];
//		BufferedImage pure_no_r = prcessimage.getPureNoise(a, noed);
		
		
		
	    JLabel origin_gray = new JLabel(new ImageIcon(a));
//	    JLabel gnoise = new JLabel(new ImageIcon(prcessimage.AddNoise(imagefile.getBufferImage(),standard)[1]));
	    
	    JLabel gnoise = new JLabel(new ImageIcon(pure_no));
	    JLabel ori_add_noise = new JLabel(new ImageIcon(noed));
	    
	    
	    
	    gn.add(origin_gray);
	    gn.add(gnoise);
	    gn.add(ori_add_noise);
	    
	    
	    
	    
	    Histogram h = new Histogram();
	    gn.add(h.createChart(a,100));
	    gn.add(h.createChart(pure_no,100));	    
	    gn.add(h.createChart(noed,100));
		
		frame.add(gn);
	    frame.setPreferredSize(new Dimension(800, 600));
	    frame.pack();
	    frame.setVisible(true);	    
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	

	public void makePepperSaultNoiseHistogram(double rate){
		JFrame frame = new JFrame("Pepper-Salt Noise");
//	    frame.getContentPane().add(panel); 
		JPanel gn = new JPanel(new GridLayout(2, 3));
		
		BufferedImage a = prcessimage.RGBtoGray(imagefile.getBufferImage());
		BufferedImage [] b = prcessimage.AddPSNoise(imagefile.getBufferImage(),rate);
		BufferedImage noed = b[0];
		BufferedImage pure_no = b[1];
//		BufferedImage pure_no_r = prcessimage.getPureNoise(a, noed);
		
		
		
	    JLabel origin_gray = new JLabel(new ImageIcon(a));
//	    JLabel gnoise = new JLabel(new ImageIcon(prcessimage.AddNoise(imagefile.getBufferImage(),standard)[1]));
	    
	    JLabel gnoise = new JLabel(new ImageIcon(pure_no));
	    JLabel ori_add_noise = new JLabel(new ImageIcon(noed));
	    
	    
	    
	    gn.add(origin_gray);
	    gn.add(gnoise);
	    gn.add(ori_add_noise);
	    
	    
	    
	    
	    Histogram h = new Histogram();
	    gn.add(h.createChart(a,100));
	    gn.add(h.createChart(pure_no,100));	    
	    gn.add(h.createChart(noed,100));
		
		frame.add(gn);
	    frame.setPreferredSize(new Dimension(800, 600));
	    frame.pack();
	    frame.setVisible(true);	    
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
}
