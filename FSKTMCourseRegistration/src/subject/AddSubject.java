package subject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import home.HomePage;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AddSubject implements ActionListener {

	//variable declaration
	public JFrame frmAddSubject;
	private JCheckBox chkFirstSub, chkSecondSub, chkThirdSub, chkFourthSub, chkFifthSub;
	private JRadioButton radFirstSubFirstSec, radFirstSubSecondSec, radFirstSubThirdSec;
	private JRadioButton radSecondSubFirstSec, radSecondSubSecondSec, radSecondSubThirdSec;
	private JRadioButton radThirdSubFirstSec, radThirdSubSecondSec, radThirdSubThirdSec;
	private JRadioButton radFourthSubFirstSec, radFourthSubSecondSec, radFourthSubThirdSec;
	private JRadioButton radFifthSubFirstSec, radFifthSubSecondSec, radFifthSubThirdSec;
	private ButtonGroup bgFirstSub, bgSecondSub, bgThirdSub, bgFourthSub, bgFifthSub;
	private JButton btnAdd, btnBack;
	private JPanel pnlHeader;
	private JLabel lblRegister, lblCourseRegistration, lblSocial;

	private JLabel lblPrincipleOf, lblManagement, lblDatabase, lblArtificialIntelligence, lblComputerEthicsAnd, lblJavaProgramming, lblMatricNum;
	private JTable tblRegisterSubject;
	private String filepath =  System.getProperty("user.dir") + "\\src\\"; //location of the file

	//creating a table
	DefaultTableModel model;
	Object[] column = {"Course Code", "Course Name", "Section"};
	Object[] row = new Object[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSubject window = new AddSubject();
					window.frmAddSubject.setVisible(true); //to show the frame			 			
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Something error here: " + e);
					e.printStackTrace();
				}
				
			}
		});
	}
	
	// function to set new value at label
	public void setMatricNumSession(String a)
	{
		lblMatricNum.setText(a);
	}
	
	// function to add column from 3 parameters in each row
	private void setRow(String a, String b, int c)
	{
		row[0] = a;
		row[1] = b;
		row[2] = c;
		model.addRow(row);
	}
	
	// function to remove all selected from checkbox and radio button
	private void removeSelected()
	{
		chkFirstSub.setSelected(false);
		chkSecondSub.setSelected(false);
		chkThirdSub.setSelected(false); 
		chkFourthSub.setSelected(false); 
		chkFifthSub.setSelected(false);
		bgFirstSub.clearSelection();
		bgSecondSub.clearSelection();
		bgThirdSub.clearSelection();
		bgFourthSub.clearSelection();
		bgFifthSub.clearSelection();
	}
	
	// function to disable all radio button
	private void setDisable()
	{
		radFirstSubFirstSec.setEnabled(false);
		radFirstSubSecondSec.setEnabled(false);
		radFirstSubThirdSec.setEnabled(false);
		radSecondSubFirstSec.setEnabled(false);
		radSecondSubSecondSec.setEnabled(false);
		radSecondSubThirdSec.setEnabled(false);
		radThirdSubFirstSec.setEnabled(false);
		radThirdSubSecondSec.setEnabled(false);
		radThirdSubThirdSec.setEnabled(false);
		radFourthSubFirstSec.setEnabled(false);
		radFourthSubSecondSec.setEnabled(false);
		radFourthSubThirdSec.setEnabled(false);
		radFifthSubFirstSec.setEnabled(false);
		radFifthSubSecondSec.setEnabled(false);
		radFifthSubThirdSec.setEnabled(false);
	}

	/**
	 * Create the application.
	 */
	public AddSubject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//design for add subject frame
		frmAddSubject = new JFrame();
		frmAddSubject.setResizable(false);
		frmAddSubject.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frmAddSubject.getContentPane().setBackground(new Color(137, 207, 240));	
		frmAddSubject.setBackground(new Color(255, 255, 255));
		frmAddSubject.setTitle("FSKTM Course Registration");
		frmAddSubject.setBounds(100, 100, 726, 594);
		frmAddSubject.setLocationRelativeTo(null);
        frmAddSubject.getContentPane().setLayout(null);
		frmAddSubject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//design for first subject checkbox
        chkFirstSub = new JCheckBox("BIT20803");
        chkFirstSub.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(chkFirstSub.isSelected())
        		{
        			radFirstSubFirstSec.setEnabled(true);
        			radFirstSubSecondSec.setEnabled(true);
        			radFirstSubThirdSec.setEnabled(true);
        		}
        		else
        		{
        			radFirstSubFirstSec.setEnabled(false);
        			radFirstSubSecondSec.setEnabled(false);
        			radFirstSubThirdSec.setEnabled(false);
        		}  		
        	}
        });
        chkFirstSub.setBackground(new Color(137, 207, 240));
        chkFirstSub.setFont(new Font("Tahoma", Font.PLAIN, 15));
        chkFirstSub.setSize(196, 20);
        chkFirstSub.setLocation(10, 80);
        frmAddSubject.getContentPane().add(chkFirstSub);
        
        //design for first subject section one radio button
        radFirstSubFirstSec = new JRadioButton("Section 1");
        radFirstSubFirstSec.setEnabled(false);
        radFirstSubFirstSec.setBackground(new Color(137, 207, 240));
        radFirstSubFirstSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radFirstSubFirstSec.setSize(100, 30);
        radFirstSubFirstSec.setLocation(242, 75);
        frmAddSubject.getContentPane().add(radFirstSubFirstSec);
  
        //design for first subject section two radio button
        radFirstSubSecondSec = new JRadioButton("Section 2");
        radFirstSubSecondSec.setEnabled(false);
        radFirstSubSecondSec.setBackground(new Color(137, 207, 240));
        radFirstSubSecondSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radFirstSubSecondSec.setSelected(false);
        radFirstSubSecondSec.setSize(100, 20);
        radFirstSubSecondSec.setLocation(242, 108);
        frmAddSubject.getContentPane().add(radFirstSubSecondSec);
        
        //design for first subject section three radio button
        radFirstSubThirdSec = new JRadioButton("Section 3");
        radFirstSubThirdSec.setEnabled(false);
        radFirstSubThirdSec.setBackground(new Color(137, 207, 240));
        radFirstSubThirdSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radFirstSubThirdSec.setSelected(false);
        radFirstSubThirdSec.setSize(100, 20);
        radFirstSubThirdSec.setLocation(242, 133);
        frmAddSubject.getContentPane().add(radFirstSubThirdSec);
        
        bgFirstSub = new ButtonGroup();
        bgFirstSub.add(radFirstSubFirstSec);
        bgFirstSub.add(radFirstSubSecondSec);
        bgFirstSub.add(radFirstSubThirdSec);
        
        //design for second subject checkbox
        chkSecondSub = new JCheckBox("BIT20903");
        chkSecondSub.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(chkSecondSub.isSelected())
        		{
        			radSecondSubFirstSec.setEnabled(true);
        			radSecondSubSecondSec.setEnabled(true);
        			radSecondSubThirdSec.setEnabled(true);
        		}
        		else
        		{
        			radSecondSubFirstSec.setEnabled(false);
        			radSecondSubSecondSec.setEnabled(false);
        			radSecondSubThirdSec.setEnabled(false);
        		}  	
        	}
        });
        chkSecondSub.setBackground(new Color(137, 207, 240));
        chkSecondSub.setFont(new Font("Tahoma", Font.PLAIN, 15));
        chkSecondSub.setSize(230, 20);
        chkSecondSub.setLocation(10, 177);
        frmAddSubject.getContentPane().add(chkSecondSub);
        
        //design for second subject section one radio button
        radSecondSubFirstSec = new JRadioButton("Section 1");
        radSecondSubFirstSec.setEnabled(false);
        radSecondSubFirstSec.setBackground(new Color(137, 207, 240));
        radSecondSubFirstSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radSecondSubFirstSec.setSize(100, 30);
        radSecondSubFirstSec.setLocation(242, 172);
        frmAddSubject.getContentPane().add(radSecondSubFirstSec);
  
        //design for second subject section two radio button
        radSecondSubSecondSec = new JRadioButton("Section 2");
        radSecondSubSecondSec.setEnabled(false);
        radSecondSubSecondSec.setBackground(new Color(137, 207, 240));
        radSecondSubSecondSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radSecondSubSecondSec.setSelected(false);
        radSecondSubSecondSec.setSize(100, 20);
        radSecondSubSecondSec.setLocation(242, 205);
        frmAddSubject.getContentPane().add(radSecondSubSecondSec);
        
        //design for second subject section three radio button
        radSecondSubThirdSec = new JRadioButton("Section 3");
        radSecondSubThirdSec.setEnabled(false);
        radSecondSubThirdSec.setBackground(new Color(137, 207, 240));
        radSecondSubThirdSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radSecondSubThirdSec.setSelected(false);
        radSecondSubThirdSec.setSize(100, 20);
        radSecondSubThirdSec.setLocation(242, 230);
        frmAddSubject.getContentPane().add(radSecondSubThirdSec);
        
        bgSecondSub = new ButtonGroup();
        bgSecondSub.add(radSecondSubFirstSec);
        bgSecondSub.add(radSecondSubSecondSec);
        bgSecondSub.add(radSecondSubThirdSec);
        
        //design for third subject checkbox
        chkThirdSub = new JCheckBox("BIT21002");
        chkThirdSub.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {      		
        		if(chkThirdSub.isSelected())
        		{
        			radThirdSubFirstSec.setEnabled(true);
        			radThirdSubSecondSec.setEnabled(true);
        			radThirdSubThirdSec.setEnabled(true);
        		}
        		else
        		{
        			radThirdSubFirstSec.setEnabled(false);
        			radThirdSubSecondSec.setEnabled(false);
        			radThirdSubThirdSec.setEnabled(false);
        		}  	

        	}
        });
        chkThirdSub.setBackground(new Color(137, 207, 240));
        chkThirdSub.setFont(new Font("Tahoma", Font.PLAIN, 15));
        chkThirdSub.setSize(230, 20);
        chkThirdSub.setLocation(10, 269);
        frmAddSubject.getContentPane().add(chkThirdSub);
        
        //design for third subject section one radio button
        radThirdSubFirstSec = new JRadioButton("Section 1");
        radThirdSubFirstSec.setEnabled(false);
        radThirdSubFirstSec.setBackground(new Color(137, 207, 240));
        radThirdSubFirstSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radThirdSubFirstSec.setSize(100, 30);
        radThirdSubFirstSec.setLocation(242, 264);
        frmAddSubject.getContentPane().add(radThirdSubFirstSec);
  
        //design for third subject section two radio button
        radThirdSubSecondSec = new JRadioButton("Section 2");
        radThirdSubSecondSec.setEnabled(false);
        radThirdSubSecondSec.setBackground(new Color(137, 207, 240));
        radThirdSubSecondSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radThirdSubSecondSec.setSelected(false);
        radThirdSubSecondSec.setSize(100, 20);
        radThirdSubSecondSec.setLocation(242, 297);
        frmAddSubject.getContentPane().add(radThirdSubSecondSec);
        
        //design for third subject section three radio button
        radThirdSubThirdSec = new JRadioButton("Section 3");
        radThirdSubThirdSec.setEnabled(false);
        radThirdSubThirdSec.setBackground(new Color(137, 207, 240));
        radThirdSubThirdSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radThirdSubThirdSec.setSelected(false);
        radThirdSubThirdSec.setSize(100, 20);
        radThirdSubThirdSec.setLocation(242, 320);
        frmAddSubject.getContentPane().add(radThirdSubThirdSec);
        
        bgThirdSub = new ButtonGroup();
        bgThirdSub.add(radThirdSubFirstSec);
        bgThirdSub.add(radThirdSubSecondSec);
        bgThirdSub.add(radThirdSubThirdSec);
        
        //design for add button
        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Arial", Font.PLAIN, 15));
        btnAdd.setBackground(new Color(4, 36, 66));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setSize(696, 33);
        btnAdd.setLocation(6, 362);
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(!chkFirstSub.isSelected() && !chkSecondSub.isSelected() && !chkThirdSub.isSelected() && !chkFourthSub.isSelected() && !chkFifthSub.isSelected())
        		{
        			//if user do not select the course, JOptionPanel will show message
        			JOptionPane.showMessageDialog(frmAddSubject, "You must select at least 1 course before add.", 
        					"FSKTM Course Registration", JOptionPane.ERROR_MESSAGE);
        		}
        		else
        		{
        			//declare variable
	        		String subject="", code, list, lists = "";
	        		Boolean isComplete = true;
	        		int section;
	        		try 
	        		{	//link to the file where contain user record subject information	  
	        			File myDelete = new File(filepath + "Records\\Subjects\\" + lblMatricNum.getText() +".txt");
	        			if(!myDelete.createNewFile()) //create a new file
	        			{
	        				myDelete.delete(); 
	        				model.setRowCount(0);
	        			}
	        			
						if (chkFirstSub.isSelected()) //when user select the subject it will input in txt file
		        		{	
		        			code = "BIT20803";
		        			subject = "DATABASE SYSTEM";
		        			
		        			
		        			if (radFirstSubFirstSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 1;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else if (radFirstSubSecondSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 2;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else if (radFirstSubThirdSec.isSelected())  // when user select the section it will input in txt file
		        			{
		        				section = 3;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else
		        				isComplete = false;	
		        			
						}
		        		
		        		if (chkSecondSub.isSelected())  //when user select the subject it will input in txt file
		        		{
		        			code = "BIT20903";
		        			subject = "ARTIFICIAL INTELLIGENCE";
		        			radSecondSubFirstSec.setEnabled(true);
		        			radSecondSubSecondSec.setEnabled(true);
		        			radSecondSubThirdSec.setEnabled(true);

		        			if (radSecondSubFirstSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 1;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list; 
		        			}
		        			else if (radSecondSubSecondSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 2;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else if (radSecondSubThirdSec.isSelected())  // when user select the section it will input in txt file
		        			{
		        				section = 3;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else
		        				isComplete = false;		        			
	        			}
		        		
		        		if (chkThirdSub.isSelected()) //when user select the subject it will input in txt file    
		        		{
		        			code = "BIT21002";
		        			subject = "COMPUTER, ETHICS AND SOCIAL";
		        			radThirdSubFirstSec.setEnabled(true);
		        			radThirdSubSecondSec.setEnabled(true);
		        			radThirdSubThirdSec.setEnabled(true);
		        			
		        			if (radThirdSubFirstSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 1;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else if (radThirdSubSecondSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 2;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else if (radThirdSubThirdSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 3;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else
		        				isComplete = false;	        			}
		        		
		        		if (chkFourthSub.isSelected()) //when user select the subject it will input in txt file    
		        		{
		        			code = "BIT33803";
		        			subject = "JAVA PROGRAMMING";
		        			radFourthSubFirstSec.setEnabled(true);
		        			radFourthSubSecondSec.setEnabled(true);
		        			radFourthSubThirdSec.setEnabled(true);
		        			
		        			if (radFourthSubFirstSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 1;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;	
		        			}
		        			else if (radFourthSubSecondSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 2;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else if (radFourthSubThirdSec.isSelected())  // when user select the section it will input in txt file
		        			{
		        				section = 3;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else
		        				isComplete = false;	        			}
		        		
		        		if (chkFifthSub.isSelected())  //when user select the subject it will input in txt file  
		        		{
		        			code = "BPK20502";
		        			subject = "PRINCIPLE OF MANAGEMENT";
		        			radFifthSubFirstSec.setEnabled(true);
		        			radFifthSubSecondSec.setEnabled(true);
		        			radFifthSubThirdSec.setEnabled(true);
		        			
		        			if (radFifthSubFirstSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 1;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;	        				
		        			}
		        			else if (radFifthSubSecondSec.isSelected()) // when user select the section it will input in txt file
		        			{
		        				section = 2;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else if (radFifthSubThirdSec.isSelected())  // when user select the section it will input in txt file
		        			{
		        				section = 3;
		        				setRow(code, subject, section);		        				
		    					list = code + " " + subject +" "+ section +"\n";
			        			lists += list;
		        			}
		        			else
		        				isComplete = false;
	        			}
		        		
		        		if(!isComplete)
		        		{
		        			model.setRowCount(0);
	        				JOptionPane.showMessageDialog(frmAddSubject, "Please choose a section", "FSKTM Course Registration", JOptionPane.INFORMATION_MESSAGE);
		        		}
		        		else
		        		{
		        			//to send input data to txt file
			        		FileWriter myWriter = new FileWriter(filepath + "Records\\Subjects\\" + lblMatricNum.getText() +".txt");
	    					myWriter.write(lists);
			        		myWriter.close();
			        		//display JOptionPane message that add subject process is success
			        		JOptionPane.showMessageDialog(frmAddSubject, "You have successful add subject.");
		        		}
		        		setDisable(); // set disable for all radio button
		        		removeSelected(); // remove all check at checkbox and radio button
	        		}
	        		catch (Exception ex){
	        			JOptionPane.showMessageDialog(frmAddSubject, "Something wrong here:"+ex);
	        			ex.printStackTrace();
	        		}
        		}
        	}
        	
        });
        frmAddSubject.getContentPane().add(btnAdd);
        // design back button
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
        btnBack.setBackground(new Color(4, 36, 66));
        btnBack.setForeground(Color.WHITE);
        btnBack.setSize(100, 20);
        btnBack.setLocation(6, 527);
        btnBack.addActionListener(new ActionListener() {
        	//back button to connect with other pages and txt file
        	public void actionPerformed(ActionEvent e) {
        		try
        		{
        			HomePage home = new HomePage();
            		FileReader fr1 = new FileReader(filepath + "Records\\Students\\" + lblMatricNum.getText() +".txt");  
    				BufferedReader br = new BufferedReader(fr1);
    				String line;
    				int count = 0;
    				while ((line = br.readLine()) != null) {
    					
    					if(count == 0)
    						home.setNameSession(line);

    					count++;
    				}
            		home.setMatricNumSession(lblMatricNum.getText());
            		// back to home page and hide the add page
            		home.frmHomePage.setVisible(true);
            		frmAddSubject.setVisible(false);
        		}
        		catch(Exception ex)
        		{
        			JOptionPane.showMessageDialog(frmAddSubject, "Something wrong here:"+ex);
					ex.printStackTrace();
        		}	
        	}
    	});
        frmAddSubject.getContentPane().add(btnBack);
        
        //design header panel
        pnlHeader = new JPanel();
        pnlHeader.setLayout(null);
        pnlHeader.setBackground(SystemColor.menu);
        pnlHeader.setBounds(0, 0, 712, 69);
        frmAddSubject.getContentPane().add(pnlHeader);
        
        //design register label
        lblRegister = new JLabel("Register");
        lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegister.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
        lblRegister.setBounds(0, 34, 712, 25);
        pnlHeader.add(lblRegister);
        
        //design course register label
        lblCourseRegistration = new JLabel("Course Registration");
        lblCourseRegistration.setHorizontalAlignment(SwingConstants.CENTER);
        lblCourseRegistration.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
        lblCourseRegistration.setBounds(0, 8, 712, 25);
        pnlHeader.add(lblCourseRegistration);
        
        //design subject database system label
        lblDatabase = new JLabel("DATABASE SYSTEM");
        lblDatabase.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDatabase.setBounds(32, 106, 171, 13);
        frmAddSubject.getContentPane().add(lblDatabase);
        
        //design subject artificial intelligence label 
        lblArtificialIntelligence = new JLabel("ARTIFICIAL INTELLIGENCE");
        lblArtificialIntelligence.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblArtificialIntelligence.setBounds(32, 203, 208, 13);
        frmAddSubject.getContentPane().add(lblArtificialIntelligence);
        
        //design subject computer, ethic label
        lblComputerEthicsAnd = new JLabel("COMPUTER, ETHICS AND");
        lblComputerEthicsAnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblComputerEthicsAnd.setBounds(32, 295, 208, 13);
        frmAddSubject.getContentPane().add(lblComputerEthicsAnd);
        
        //design for social label
        lblSocial = new JLabel("SOCIAL");
        lblSocial.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSocial.setBounds(32, 315, 208, 13);
        frmAddSubject.getContentPane().add(lblSocial);
        
        //design for fourth subject checkbox
        chkFourthSub = new JCheckBox("BIT33803");
        chkFourthSub.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(chkFourthSub.isSelected())
        		{
        			radFourthSubFirstSec.setEnabled(true);
        			radFourthSubSecondSec.setEnabled(true);
        			radFourthSubThirdSec.setEnabled(true);
        		}
        		else
        		{
        			radFourthSubFirstSec.setEnabled(false);
        			radFourthSubSecondSec.setEnabled(false);
        			radFourthSubThirdSec.setEnabled(false);
        		}  
        	}
        });
        chkFourthSub.setFont(new Font("Tahoma", Font.PLAIN, 15));
        chkFourthSub.setBackground(new Color(137, 207, 240));
        chkFourthSub.setBounds(370, 81, 196, 20);
        frmAddSubject.getContentPane().add(chkFourthSub);
        
        //design subject java programming label
        lblJavaProgramming = new JLabel("JAVA PROGRAMMING");
        lblJavaProgramming.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblJavaProgramming.setBounds(391, 108, 171, 13);
        frmAddSubject.getContentPane().add(lblJavaProgramming);
        
        //design fourth subject section two radio button
        radFourthSubSecondSec = new JRadioButton("Section 2");
        radFourthSubSecondSec.setEnabled(false);
        radFourthSubSecondSec.setSelected(false);
        radFourthSubSecondSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radFourthSubSecondSec.setBackground(new Color(137, 207, 240));
        radFourthSubSecondSec.setBounds(568, 109, 100, 20);
        frmAddSubject.getContentPane().add(radFourthSubSecondSec);
        
        //design fourth subject section three radio button
        radFourthSubThirdSec = new JRadioButton("Section 3");
        radFourthSubThirdSec.setEnabled(false);
        radFourthSubThirdSec.setSelected(false);
        radFourthSubThirdSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radFourthSubThirdSec.setBackground(new Color(137, 207, 240));
        radFourthSubThirdSec.setBounds(568, 134, 100, 20);
        frmAddSubject.getContentPane().add(radFourthSubThirdSec);
        
        //design fourth subject section one radio button
        radFourthSubFirstSec = new JRadioButton("Section 1");
        radFourthSubFirstSec.setEnabled(false);
        radFourthSubFirstSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radFourthSubFirstSec.setBackground(new Color(137, 207, 240));
        radFourthSubFirstSec.setBounds(568, 75, 100, 30);
        frmAddSubject.getContentPane().add(radFourthSubFirstSec);
        
        bgFourthSub = new ButtonGroup();
        bgFourthSub.add(radFourthSubFirstSec);
        bgFourthSub.add(radFourthSubSecondSec);
        bgFourthSub.add(radFourthSubThirdSec);
        
        //design fifth subject checkbox
        chkFifthSub = new JCheckBox("BPK20502");
        chkFifthSub.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		if(chkFifthSub.isSelected())
        		{
        			radFifthSubFirstSec.setEnabled(true);
        			radFifthSubSecondSec.setEnabled(true);
        			radFifthSubThirdSec.setEnabled(true);
        		}
        		else
        		{
        			radFifthSubFirstSec.setEnabled(false);
        			radFifthSubSecondSec.setEnabled(false);
        			radFifthSubThirdSec.setEnabled(false);
        		}  
        	}
        });
        chkFifthSub.setFont(new Font("Tahoma", Font.PLAIN, 15));
        chkFifthSub.setBackground(new Color(137, 207, 240));
        chkFifthSub.setBounds(370, 178, 196, 20);
        frmAddSubject.getContentPane().add(chkFifthSub);
        
        //design for subject principle of label
        lblPrincipleOf = new JLabel("PRINCIPLE OF");
        lblPrincipleOf.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrincipleOf.setBounds(391, 205, 171, 13);
        frmAddSubject.getContentPane().add(lblPrincipleOf);
        
        //design fifth subject section one radio button
        radFifthSubFirstSec = new JRadioButton("Section 1");
        radFifthSubFirstSec.setEnabled(false);
        radFifthSubFirstSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radFifthSubFirstSec.setBackground(new Color(137, 207, 240));
        radFifthSubFirstSec.setBounds(568, 172, 100, 30);
        frmAddSubject.getContentPane().add(radFifthSubFirstSec);
        
        //design fifth subject section two radio button
        radFifthSubSecondSec = new JRadioButton("Section 2");
        radFifthSubSecondSec.setEnabled(false);
        radFifthSubSecondSec.setSelected(false);
        radFifthSubSecondSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radFifthSubSecondSec.setBackground(new Color(137, 207, 240));
        radFifthSubSecondSec.setBounds(568, 206, 100, 20);
        frmAddSubject.getContentPane().add(radFifthSubSecondSec);
        
        //design fifth subject section three radio button
        radFifthSubThirdSec = new JRadioButton("Section 3");
        radFifthSubThirdSec.setEnabled(false);
        radFifthSubThirdSec.setSelected(false);
        radFifthSubThirdSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radFifthSubThirdSec.setBackground(new Color(137, 207, 240));
        radFifthSubThirdSec.setBounds(568, 231, 100, 20);
        frmAddSubject.getContentPane().add(radFifthSubThirdSec);
        
        bgFifthSub = new ButtonGroup();
        bgFifthSub.add(radFifthSubFirstSec);
        bgFifthSub.add(radFifthSubSecondSec);
        bgFifthSub.add(radFifthSubThirdSec);
        
        //design management label
        lblManagement = new JLabel("MANAGEMENT");
        lblManagement.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblManagement.setBounds(391, 226, 152, 13);
        frmAddSubject.getContentPane().add(lblManagement);
        
        //design for matric number label
        lblMatricNum = new JLabel("");
        lblMatricNum.setBounds(466, 303, 45, 13);
        lblMatricNum.setVisible(false);
        frmAddSubject.getContentPane().add(lblMatricNum);
        
        //design for JScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 405, 696, 114);
        frmAddSubject.getContentPane().add(scrollPane);
        
        //JTable for display
        tblRegisterSubject = new JTable();
        tblRegisterSubject.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		boolean isEdit = tblRegisterSubject.isEditing();
        		if(isEdit == false) // user not allowed to edit in table
        			JOptionPane.showMessageDialog(frmAddSubject, "You cannot edit here.", "FSKTM Course Registration", JOptionPane.WARNING_MESSAGE);
        	}
        });
        model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		tblRegisterSubject.setModel(model);
        scrollPane.setViewportView(tblRegisterSubject);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}