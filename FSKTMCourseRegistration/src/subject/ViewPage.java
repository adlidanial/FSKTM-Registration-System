package subject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import home.HomePage;
import update.UpdatePage;

public class ViewPage
{
		//declare variable
		private JLabel lblMatric, lblName, lblProgram;	//read only text
		private JTextField txtNoMatric, txtName, txtProgram;	//allows the editing
		private JButton btnUpdate;
		private String filepath =  System.getProperty("user.dir") + "\\src\\";
		public JFrame frmViewSubject;	//works like the main window
		private JTable tblRegisterSubject; //display data in table
		private SearchButtonHandler sbHandler;
		
		DefaultTableModel model;	//creating a table model
		//managed as an intersection of column and row
		Object[] column = {"Course Code", "Description", "Section"};
		Object[] row = new Object[4];
		
		public ViewPage()
		{
			//Design for the view subject frame
			frmViewSubject = new JFrame();
			frmViewSubject.setResizable(false);
			frmViewSubject.setTitle("FSKTM Course Registration");
			frmViewSubject.setBounds(100, 100, 630, 447);
			frmViewSubject.setLocationRelativeTo(null);
			frmViewSubject.getContentPane().setBackground(new Color(137, 207, 240));
			frmViewSubject.repaint();
			frmViewSubject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmViewSubject.getContentPane().setLayout(null);
			
			//Design for the header panel
			JPanel pnlHeader = new JPanel();
			pnlHeader.setLayout(null);
			pnlHeader.setBackground(SystemColor.menu);
			pnlHeader.setBounds(0, 0, 615, 69);
			frmViewSubject.getContentPane().add(pnlHeader);
			
			//Design for view register subject label
			JLabel lblRegister = new JLabel("View Register Subject");
			lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegister.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
			lblRegister.setBounds(0, 34, 615, 25);
			pnlHeader.add(lblRegister);
			
			//Design for course registration label
			JLabel lblCourseRegistration = new JLabel("Course Registration");
			lblCourseRegistration.setHorizontalAlignment(SwingConstants.CENTER);
			lblCourseRegistration.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
			lblCourseRegistration.setBounds(0, 8, 615, 25);
			pnlHeader.add(lblCourseRegistration);
			
			//Design for info panel
			JPanel panelInfo = new JPanel();
			panelInfo.setBounds(0, 68, 615, 88);
			panelInfo.setLayout(null);
			
			//Design for label panel
			JPanel panellbl = new JPanel();
			panellbl.setBounds(0, 0, 81, 87);
			panellbl.setLayout(new BorderLayout());
			
			//Design for label no. matric panel
			JPanel panellblNoMatric = new JPanel();
			panellblNoMatric.setBackground(new Color(135, 206, 250));
			panellblNoMatric.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			//Design for no. matric label
			lblMatric = new JLabel("No. Matric");						
			lblMatric.setBackground(new Color(135, 206, 250));
			panellblNoMatric.add(lblMatric);
			
			panellbl.add(panellblNoMatric, BorderLayout.NORTH);
			
			//Design for name label
			JPanel panellblName = new JPanel();
			panellblName.setBackground(new Color(135, 206, 250));
			panellblName.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			lblName = new JLabel("Name");
			panellblName.add(lblName);
			
			panellbl.add(panellblName, BorderLayout.CENTER);
			
			//Design for label program panel
			JPanel panellblProgram = new JPanel();
			panellblProgram.setBackground(new Color(135, 206, 250));
			panellblProgram.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			lblProgram = new JLabel("Programme");
			panellblProgram.add(lblProgram);
			
			panellbl.add(panellblProgram, BorderLayout.SOUTH);				
			panelInfo.add(panellbl);
			
			//Design for text panel
			JPanel paneltxt = new JPanel();
			paneltxt.setBounds(81, 0, 534, 87);
			paneltxt.setLayout(new BorderLayout());
			
			//Design for no. matric text panel
			JPanel paneltxtNoMatric = new JPanel();
			paneltxtNoMatric.setBackground(new Color(135, 206, 235));
			paneltxtNoMatric.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			txtNoMatric = new JTextField(10);		
			txtNoMatric.setEditable(false);
			paneltxtNoMatric.add(txtNoMatric);
				
			paneltxt.add(paneltxtNoMatric, BorderLayout.NORTH);
			
			//Design for name text panel
			JPanel paneltxtName = new JPanel();
			paneltxtName.setBackground(new Color(135, 206, 235));
			paneltxtName.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			txtName = new JTextField(40);
			txtName.setEditable(false);
			paneltxtName.add(txtName);
			
			paneltxt.add(paneltxtName, BorderLayout.CENTER);
			
			//Design for program text panel
			JPanel paneltxtProgram = new JPanel();
			paneltxtProgram.setBackground(new Color(135, 206, 250));
			paneltxtProgram.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			txtProgram = new JTextField(40);
			txtProgram.setEditable(false);
			paneltxtProgram.add(txtProgram);
			
			paneltxt.add(paneltxtProgram, BorderLayout.SOUTH);		
			panelInfo.add(paneltxt);
			frmViewSubject.getContentPane().add(panelInfo);		
			
			//Design for view panel
			JPanel ViewPanel = new JPanel();
			ViewPanel.setBounds(0, 155, 615, 255);
			ViewPanel.setLayout(null);
			
			//Design for body panel
			JPanel pnlBody = new JPanel();
			pnlBody.setBounds(0, 0, 615, 214);
			ViewPanel.add(pnlBody);
			pnlBody.setLayout(null);
			
			//Design for scroll pane
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 615, 214);
			pnlBody.add(scrollPane);
			
			//Design for register subject table
			tblRegisterSubject = new JTable();
			model = new DefaultTableModel();
			model.setColumnIdentifiers(column);
			tblRegisterSubject.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tblRegisterSubject.setModel(model);
			scrollPane.setViewportView(tblRegisterSubject);
			
			//Design for bottom panel
			JPanel panelBottom = new JPanel();
			panelBottom.setBounds(0, 213, 615, 44);
			panelBottom.setBackground(new Color(137, 207, 240));
			
			ViewPanel.add(panelBottom);		
			
			//Design for update button
			btnUpdate = new JButton("Update");
			btnUpdate.setBackground(new Color(4, 36, 66));
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UpdatePage update = new UpdatePage();	//connect to update page
					update.showRegisterSubject(txtNoMatric.getText()); //to show all the registered subjects
					update.frmUpdatepage.setVisible(true); //to makes the update page frame appear on the screen
					frmViewSubject.setVisible(false);	//view subject frame will become invisible, but the object will still exist
				}
			});
			
			//Design for back button
			JButton btnBack = new JButton("Back");
			btnBack.setBackground(new Color(4, 36, 66));
			btnBack.setForeground(Color.WHITE);
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try
	        		{
	        			HomePage home = new HomePage();	//bring back to home page
	        			//to read and display the text from txt file
	            		FileReader fr1 = new FileReader(filepath + "Records\\Students\\" + txtNoMatric.getText() +".txt");  
	    				BufferedReader br1 = new BufferedReader(fr1);
	    				String line;
	    				int count = 0;
	    				//will read the file until it has reached the end of file
	    				while ((line = br1.readLine()) != null) {
	    					
	    					if(count == 0)
	    						home.setNameSession(line);

	    					count++;
	    				}
	            		home.setMatricNumSession(txtNoMatric.getText());	//to get the text previously set by the setText
	            		home.frmHomePage.setVisible(true);	//to makes the home page frame appear on the screen
	            		frmViewSubject.setVisible(false);	//view subject frame will become invisible, but the object will still exist
	        		}
	        		catch(Exception ex)
	        		{
	        			JOptionPane.showMessageDialog(null, "An error occured: " + ex); // show message error
						ex.printStackTrace();
	        		}	
				}
			});
			panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelBottom.add(btnBack);
			panelBottom.add(btnUpdate);
			
			//Design for search button
			JButton btnSearch = new JButton("Search");
			btnSearch.setBackground(new Color(4, 36, 66));
			btnSearch.setForeground(Color.WHITE);
			sbHandler = new SearchButtonHandler(); 
			btnSearch.addActionListener(sbHandler);
			panelBottom.add(btnSearch);
			frmViewSubject.getContentPane().add(ViewPanel);
	
		}		
		
		private class SearchButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String searchCode = JOptionPane.showInputDialog("Please enter code course");	//ask user to enter the code course

				try 
				{	
					//checks if it is true or false
					while(searchCode.isEmpty())	//if false
					{
						searchCode = JOptionPane.showInputDialog("Please re-enter or fill code course");	//ask user to re-enter the code course
					}
					
					if(!searchCode.isEmpty())	//if true
					{
						// read relative path
						File myObj = new File(filepath + "Records\\Subjects\\" + txtNoMatric.getText() + ".txt");
						BufferedReader myReader = new BufferedReader(new FileReader(myObj));
						String words = "";
						boolean isFound = false;	//take the false values
						//will read the file until it has reached the end of file
						while ((words = myReader.readLine()) != null) 
						{
							String line[] = words.split(" ");
							//check whether the code course entered by the user is the same or not
							if(line[0].equals(searchCode))
							{
								JOptionPane.showMessageDialog(frmViewSubject, String.format("Code Course: %s\nThis course has been found in your register subject.", searchCode));
								isFound = true;	//successfully found the course code
								break;
							}
						}
						if(!isFound) //unsuccessfully found the course code
							JOptionPane.showMessageDialog(frmViewSubject, String.format("Code Course: %s\nThis course has not been found in your register subject.", searchCode));
							
						myReader.close();
					}
					
			    } 
				catch (IOException ex) 
				{
					JOptionPane.showMessageDialog(null, "An error occured: " + ex); // show message error
			    }
				catch (NullPointerException  en) 
				{
					JOptionPane.showMessageDialog(frmViewSubject, "Your have been cancel to search.");	//display the message if user clicks the cancel button to cancel the search
			    }
			}
		}
		
		//to set the current text that is to be read
		public void setMatricNumSession(String a)
		{
			txtNoMatric.setText(a);	
		}
		
		public void setNameSession(String a)
		{
			txtName.setText(a);
		}
		
		public void setProgrammeSession()
		{
			try
			{
				//to read and display the text from txt file
				BufferedReader br = new BufferedReader(new FileReader(filepath + "Records\\Students\\" + txtNoMatric.getText() + ".txt")); 
				String word = ""; 
				int count = 0;
				//will read the file until it has reached the end of file
				while((word = br.readLine()) != null)
				{
					if(count == 2)
					{
						txtProgram.setText(word);
					}
					count++;
				}	
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(null, "An error occured: " + ex); // show message error
				ex.printStackTrace();	//to handle exceptions and errors
			}

		}
		
		public void showRegisterSubject()
		{
			try
			{
				//to read and display the text from txt file
				BufferedReader br = new BufferedReader(new FileReader(filepath + "Records\\Subjects\\" + txtNoMatric.getText() +".txt")); 
				String word = ""; 
				row[1] = "";
				//will read the file until it has reached the end of file
				while((word = br.readLine()) != null)	
				{
					String newWord[] = word.split(" ");	//to split a String by whitespaces or tabs
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
				ex.printStackTrace();	//to handle exceptions and errors
			}
		}
		
		// launch the application
		public static void main(String [] args) throws IOException
		{
			ViewPage frame = new ViewPage();
			frame.frmViewSubject.setVisible(true);
		}
}