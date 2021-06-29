package delete; //using package delete

import java.awt.EventQueue; //to using event queue class in package java.awt
//to using the design of BorderLayout, Color, Font
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

//to import the class of File,FileNotFoundException,FileWriter,IOException,PrintWriter, RandomAccessFile,BufferedReader,BufferedWriter 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

//to using import the design container of JFrame,JPanel,JButton,JList,JLabel,JOptionPane,DefaultListModel,JTable,JScrollPane
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;  //to import the swing constants in javax.swing
import javax.swing.table.DefaultTableModel; //to import the design container of default table model
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import home.HomePage; //to import package home to link the home page 

public class DeleteRegister { //declare delete register method in public class
	
	public JFrame frmCourseRegistration; //declare public variable of JFrame 
	
	//to link data file's place and declare private variable filename as filepath using datatype string 
	private String filepath =  System.getProperty("user.dir") + "\\src\\";
	private JTable tblRegisterSubject; //declare private variable of JTable 
	private JLabel lblMatricNum; //declare private variable of JLabel
	DefaultTableModel model; //declare variable defaultTable as a model
	
	//declare array of column about course which is have code, name and section 
	Object[] column = {"Course Code", "Course Name", "Section"}; 
	Object[] row = new Object[4]; //declare array of row with assign sizing index until 4
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { //declare main method
        
		EventQueue.invokeLater(new Runnable() { //declare event queue method to running swing component
			public void run() { //declare the part of to run the gui
				try // to tested the frame can execute or not
				{
					DeleteRegister window = new DeleteRegister(); //declare variable window in DeleteRegister
					window.frmCourseRegistration.setVisible(true);	//to show the frame	of course registration
				} 
				catch (Exception e) //block of code to handle error
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setMatricNumSession(String a) //declare public variable to set matric No. method  with declare parameter string a
	{
		lblMatricNum.setText(a); //declare label matric No. to set in text field
	}
	
	public void showRegisterSubject(String a)//declare public variable to show subj register method  with declare parameter string a to 
	{
		//condition try catch to handle executed part of show register in file
		try
		{	
			//declare label matric No. to set in text field
			lblMatricNum.setText(a); 
			//read the data in located file.txt
			BufferedReader br = new BufferedReader(new FileReader(filepath + "Records\\Subjects\\" + a +".txt")); 
			//declare variable word with datatype string
			String word = ""; 
			//assign row start with 1
			row[1] = ""; 
			
			//condition while to read the data located file.txt 
			while((word = br.readLine()) != null) 
			{
				//decare variable new word with spacing
				String newWord[] = word.split(" "); 
				row[0] = newWord[0]; //assign first new word in first row
			
				//condtion for to read  the second column to last second column
				for(int i = 1; i < newWord.length-1; i++)
					row[1] += newWord[i] + " ";
				
				row[2] = newWord[newWord.length-1];
				model.addRow(row);
				row[1] = "";
			}	
		}
		catch (Exception ex) //block to handle error
		{
			JOptionPane.showMessageDialog(frmCourseRegistration, "Something wrong here: " + ex);
			ex.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */ 
	public DeleteRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		//design frame
		frmCourseRegistration = new JFrame();
		frmCourseRegistration.setTitle("FSKTM Course Registration");
		frmCourseRegistration.setBounds(100, 100, 644, 345);
		frmCourseRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCourseRegistration.setLocationRelativeTo(null);
		frmCourseRegistration.getContentPane().setLayout(null);
		
		//design of JPanel,JLabel, JScrollPane, JTable, JButton 
		//design panel
		JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(SystemColor.menu);
		pnlHeader.setBounds(0, 0, 630, 62);
		frmCourseRegistration.getContentPane().add(pnlHeader);
		
		//design label remove
		JLabel lblRemoveRegisterSubject = new JLabel("Remove Register Subject");
		lblRemoveRegisterSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveRegisterSubject.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		lblRemoveRegisterSubject.setBounds(0, 34, 630, 25);
		pnlHeader.add(lblRemoveRegisterSubject);
		
		//design label regsiter
		JLabel lblCourseRegistration = new JLabel("Course Registration");
		lblCourseRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseRegistration.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblCourseRegistration.setBounds(0, 8, 630, 25);
		pnlHeader.add(lblCourseRegistration);
		
		//design panel
		JPanel panel = new JPanel();
		panel.setBounds(0, 60, 630, 248);
		panel.setBackground(new Color(135, 206, 235));
		frmCourseRegistration.getContentPane().add(panel);
		
		//design button delete
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(4, 36, 66));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(531, 213, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
			//to access the properties action event in button delete
			public void actionPerformed(ActionEvent e) {
				//condition if else to select row in table
				if(tblRegisterSubject.getSelectedRow() < 0)
					//pop up message will show if user not selected
					JOptionPane.showMessageDialog(frmCourseRegistration, "Please select a course before delete.");
				else 
				{	
					//condition try catch to read and delete the data in located file.txt
			        try
			        {
			        	//read the data as a br in located file.txt
						BufferedReader br = new BufferedReader(new FileReader(filepath + "\\Records\\Subjects\\" + lblMatricNum.getText() + ".txt"));
						//declare variable word and list with datatype string
						String word = "", list = "";
						//declare variable count assign 0 with datatype integer 
						int count = 0;
						//condtion while loop to read the data located in file.txt line by line 
						while((word = br.readLine())!= null) {
							//condition if to delete selected row in table
							if(tblRegisterSubject.getSelectedRow() != count) 
							{  
								list += word + "\n"; //read output by line
							} 
							count++; //increment count
						}
						br.close(); //exit file
						
						//write and replace data in the same file.txt
						FileWriter dump = new FileWriter(filepath + "\\Records\\Subjects\\" + lblMatricNum.getText() + ".txt"); 
						//rewrite the data
						dump.write(list);
						//close the file
						dump.close();
						model.setRowCount(0);
						//show the new deleted data
						showRegisterSubject(lblMatricNum.getText());
						//pop up message
						JOptionPane.showMessageDialog(frmCourseRegistration, "You have successful delete a selected course.");
			        }
			        catch(Exception e1){ //block handling error 
			            JOptionPane.showMessageDialog(null, "Something wrong here: " + e1);
			        }
				}
			}
			
		});
		panel.setLayout(null);
		
		//design scrollPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 610, 177);
		panel.add(scrollPane);
		
		//design table register
		tblRegisterSubject = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		tblRegisterSubject.setModel(model);
		scrollPane.setViewportView(tblRegisterSubject);
		panel.add(btnDelete);
		
		//design button back
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(4, 36, 66));
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			//to access the properties action event in button back
			public void actionPerformed(ActionEvent e) {			
				//condition try catch to handle executed file and to go home page
				try
        		{
        			HomePage home = new HomePage(); //to call home page in package home
        			//read the data in located file.txtas a fr1 
            		FileReader fr1 = new FileReader(filepath + "Records\\Students\\" + lblMatricNum.getText() +".txt");  
    				//replace in same file
            		BufferedReader br1 = new BufferedReader(fr1);
    				String line; //declare variable line with datatype string
    				int count = 0; //declare variable count with datatype integer and assign as 0
    				//condition while for read file br1
    				while ((line = br1.readLine()) != null) {
    					if(count == 0) //condition if to back homepage
    						home.setNameSession(line);

    					count++;
    				}
            		home.setMatricNumSession(lblMatricNum.getText()); //show the same matric No. in text field home page
            		home.frmHomePage.setVisible(true); //show the frame home page
            		frmCourseRegistration.setVisible(false); //close the frame course registration
        		}
        		catch(Exception ex) //block handle the error
        		{
        			System.out.println("An error occured."); //output message
					ex.printStackTrace();
        		}		
			}
		});
		btnBack.setBounds(10, 213, 89, 23);
		panel.add(btnBack);
		
		//design label matric No.
		lblMatricNum = new JLabel("");
		lblMatricNum.setVisible(false);
		lblMatricNum.setBounds(288, 218, 45, 13);
		panel.add(lblMatricNum);
		
	}
}
