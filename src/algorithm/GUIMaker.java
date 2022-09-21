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
                       }catch (IOException e1) {
                    	   e1.printStackTrace();
                       }
                       
                       
                       if(hw.equals("hw1")) {
                    	   ShowDEMO();
                       }
                       if(hw.equals("hw2")) {
                    	   HW2withHW1();
                    	   
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
 
	
}
