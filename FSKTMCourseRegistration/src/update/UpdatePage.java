package update;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import home.HomePage;

public class UpdatePage {

	public JFrame frmUpdatepage;
	private String filepath =  System.getProperty("user.dir") + "\\src\\";
	private JTable tblSubject;
	private JPanel pnlDisplay;
	private JLabel lblMatricNum;
	
	DefaultTableModel model;
	Object[] column = {"Course Code", "Course Name", "Section"};
	Object[] row = new Object[4];


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					UpdatePage window = new UpdatePage(); 
					window.frmUpdatepage.setVisible(true);					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showRegisterSubject(String a)
	{
		try
		{
			lblMatricNum.setText(a);
			//reads and display text in txt file 
			BufferedReader br = new BufferedReader(new FileReader(filepath + "Records\\Subjects\\" + a +".txt")); 
			String word = ""; 
			row[1] = "";
			while((word = br.readLine()) != null)  //to check the content in txt file and read until the end when there is data
			{
				String newWord[] = word.split(" ");     //use splitString to split between each character
				row[0] = newWord[0];
				for(int i = 1; i < newWord.length-1; i++)
					row[1] += newWord[i] + " ";
				
				row[2] = newWord[newWord.length-1];
				model.addRow(row);
				row[1] = "";
			}	
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null, "An error occured: " + ex); // show message error
			ex.printStackTrace();
		}
	}


	/**
	 * Create the application.
	 */
	public UpdatePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {        //the design for the Jframe
		frmUpdatepage = new JFrame();                    
		frmUpdatepage.setResizable(false);
		frmUpdatepage.setTitle("FSKTM Course Registration");
		frmUpdatepage.setBounds(100, 100, 855, 439);
		frmUpdatepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdatepage.setLocationRelativeTo(null);
		frmUpdatepage.getContentPane().setLayout(null);
		
		//The design for the panel Header
		JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(SystemColor.menu);
		pnlHeader.setBounds(0, 0, 839, 62);
		frmUpdatepage.getContentPane().add(pnlHeader);
		
		//The design for label update register subject
		JLabel lblUpdateRegisterSubject = new JLabel("Update Register Subject");
		lblUpdateRegisterSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateRegisterSubject.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		lblUpdateRegisterSubject.setBounds(0, 34, 839, 25);
		pnlHeader.add(lblUpdateRegisterSubject);
		
		//The design for label course registration
		JLabel lblCourseRegistration = new JLabel("Course Registration");
		lblCourseRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseRegistration.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblCourseRegistration.setBounds(0, 8, 839, 25);
		pnlHeader.add(lblCourseRegistration);
		
		//The design for panel body
		JPanel pnlBody = new JPanel();
		pnlBody.setBackground(new Color(135, 206, 235));
		pnlBody.setBounds(0, 62, 839, 340);
		frmUpdatepage.getContentPane().add(pnlBody);
		pnlBody.setLayout(null);
		
		pnlDisplay = new JPanel();
		pnlDisplay.setBounds(35, 24, 762, 292);
		pnlBody.add(pnlDisplay);
		pnlDisplay.setLayout(null);
		
		
		//to update the section using the button 
		JButton btnUpdateSection = new JButton("UPDATE SECTION");
		btnUpdateSection.setBackground(new Color(4, 36, 66));
		btnUpdateSection.setForeground(Color.WHITE);
		btnUpdateSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tblSubject.getSelectedRow() < 0)       //if a row from the table is selected, JoptionPanel will a show message 
					JOptionPane.showMessageDialog(frmUpdatepage, "Please select a course before update section.");
				else
				{
					try 
					{	
						//to enter a section and it will re-appeared as invalid when a wrong section is entered 
						String newsection = JOptionPane.showInputDialog("Please enter new section (1-3)");
						while(newsection.isEmpty())
							newsection = JOptionPane.showInputDialog("Please re-enter or fill new section (1-3)");
						
						while(Integer.parseInt(newsection) < 1 || Integer.parseInt(newsection) > 3)
							newsection = JOptionPane.showInputDialog("Invalid section.\nPlease re-enter or fill new section (1-3)");
						
						if(!newsection.isEmpty())  //when the right section is entered it will read and be replace in the txt file
						{
							//will read data from the located txt file 
							File myObj = new File(filepath + "Records\\Subjects\\" + lblMatricNum.getText() + ".txt");    
							BufferedReader myReader = new BufferedReader(new FileReader(myObj));
							String words = "", list = "", lists = "";
							int count = 0; 
							int rowCount = tblSubject.getRowCount();               //returns number of row 
							int row = tblSubject.getSelectedRow();                //returns the number of selected row 
							String codeCourse = tblSubject.getValueAt(row, 0).toString();     //returns value in cell's value and convert to string
							String nameCourse = tblSubject.getValueAt(row, 1).toString();
							
							while ((words = myReader.readLine()) != null)        //reads data from located txt file
							{
								if(count == tblSubject.getSelectedRow())       //if the count is the same as number of selected row
								{
									list = codeCourse + " " + nameCourse + newsection;
								}
								else
								{
									list = words;
								}
								
								if(count < rowCount - 1)
									list += "\n";
	
								lists += list;
								count++;
							}
							myReader.close();
							
							FileWriter myWriter = new FileWriter(myObj);    //to sent updated data from Jtable to txt file
							myWriter.write(lists);
							myWriter.close();
							model.setRowCount(0);
							showRegisterSubject(lblMatricNum.getText());
							JOptionPane.showMessageDialog(frmUpdatepage, "Your section has been updated.");	//display JoptionPanel that update is success
						}
				    } 
					catch (IOException ex) 
					{
						JOptionPane.showMessageDialog(null, "An error occured: " + ex); // show message error
				    }
					catch (NullPointerException  en) 
					{
						JOptionPane.showMessageDialog(frmUpdatepage, "Your have been cancel to update section.");   //display Jtable if the update is not sucessful
				    }
					catch(NumberFormatException nfe)
					{
						JOptionPane.showMessageDialog(frmUpdatepage, "You are not allow to insert character. Please try again.", "FSKTM Course Registration", JOptionPane.ERROR_MESSAGE); // display message box if user input is character
					}
				}
			}
		});
		//design for the JscrollPanel, Jtable and Button for back
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 762, 219);
		pnlDisplay.add(scrollPane);
		
		tblSubject = new JTable();
		tblSubject.setBackground(Color.WHITE);
		tblSubject.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		btnUpdateSection.setBounds(608, 257, 141, 23);
		pnlDisplay.add(btnUpdateSection);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		tblSubject.setModel(model);
		scrollPane.setViewportView(tblSubject);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(4, 36, 66));
		btnBack.setForeground(Color.WHITE);
		
		//Back button, to connect with other pages and txt files
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
        		{
        			HomePage home = new HomePage();
            		FileReader fr1 = new FileReader(filepath + "Records\\Students\\" + lblMatricNum.getText() +".txt");  
    				BufferedReader br1 = new BufferedReader(fr1);
    				String line;
    				int count = 0;
    				while ((line = br1.readLine()) != null) {
    					if(count == 0)
    						home.setNameSession(line);

    					count++;
    				}
            		home.setMatricNumSession(lblMatricNum.getText());
            		home.frmHomePage.setVisible(true);
            		frmUpdatepage.setVisible(false);
        		}
        		catch(Exception ex)
        		{
        			JOptionPane.showMessageDialog(null, "An error occured: " + ex); // show message error
					ex.printStackTrace();
        		}			
			}
		});
		btnBack.setBounds(10, 258, 85, 21);
		pnlDisplay.add(btnBack);
		
		lblMatricNum = new JLabel("");
		lblMatricNum.setEnabled(false);
		lblMatricNum.setVisible(false);
		lblMatricNum.setBounds(335, 244, 45, 13);
		pnlDisplay.add(lblMatricNum);

	}
}


