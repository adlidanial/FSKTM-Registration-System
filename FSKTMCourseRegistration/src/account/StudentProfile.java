package account;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane; // using JOptionPane message, input dialog

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.EventQueue; // using EventQueue

import net.miginfocom.swing.MigLayout;

import java.io.FileWriter; // using FileWriter, FileReader, File, BufferReader, IOException, 
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Scanner; // using Scanner

import home.HomePage; // import from HomePage

public class StudentProfile implements ActionListener {

	public JFrame frmStudentProfile; // declaration instance name of JFrame
	private JPanel pnlHeader, pnlPhoto, pnlInformation; // declaration instance name of JPanel
	private JLabel lblPhoto, lblStudentProfile, lblCourseRegistration, lblStudName, lblColon_1, lblName, lblStudMatricNum; // declaration instance name of JLabel
	private JLabel lblColon_2, lblMatricNum, lblStudProgramme, lblColon_3, lblProgramme, lblStudPhoneNumber, lblColon_4; // declaration instance name of JLabel
	private JLabel lblPhoneNumber, lblStudChangePassword, lblColon_5, lblChangePassword; // declaration instance name of JLabel
	private JButton btnEditPhoneNumber, btnEditChangePassword, btnBack; // declaration instance name of JButton
	private EditPhoneNumberButtonHandler epnbHandler; // declaration instance name of EditPhoneNumberButtonHandler
	private EditChangePasswordButtonHandler ecpbHandler; // declaration instance name of EditChangePasswordButtonHandler
	private BackButtonHandler bbHandler; // declaration instance name of BackButtonHandler
	private String filepath =  System.getProperty("user.dir") + "\\src\\"; // initialize path into filepath
	
	// the program start execute on main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // update GUI if any changes
			public void run() {
				try // handle exception if runtime error occur
				{
					StudentProfile studprof = new StudentProfile(); // declaration instance name of StudentProfile
					studprof.frmStudentProfile.setVisible(true); // show the current frame
				} 
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "Something wrong here: " + e); // display runtime error message
				}
			}
		});
	}
	
	private class EditPhoneNumberButtonHandler implements ActionListener // create class for edit phone button handler
	{
		public void actionPerformed(ActionEvent e) // execute if click the button
		{
			String inpPhoneNum = JOptionPane.showInputDialog("Please enter new phone number"); // show input dialog to user

			try // start handle exception
			{	
				while(inpPhoneNum.isEmpty()) // verify if input from user is empty
					inpPhoneNum = JOptionPane.showInputDialog("Please re-enter or fill new phone number"); // ask again input dialog to user
				
				if(!inpPhoneNum.isEmpty()) // verify if input from user is not empty 
				{
					File myObj = new File(filepath + "Records\\Students\\" + lblMatricNum.getText() + ".txt"); // locate the txt file from the path
					BufferedReader  myReader = new BufferedReader(new FileReader(myObj)); // read text from input stream
					String words = "", list = ""; // declare two variable in String
					int count = 0; // declare one variable in Integer
					while ((words = myReader.readLine()) != null) // loop to get line by line from txt file
					{
						if(count == 3) // if value is found
							words = inpPhoneNum; // replace new value
						
						list += words + "\r\n"; // concatenate new and old value
						count++; // increment the value
					}
					myReader.close(); // close the read text
					
					FileWriter myWriter = new FileWriter(filepath + "Records\\Students\\" + lblMatricNum.getText() + ".txt"); // start write character data into txt file
					myWriter.write(list); // write the value into txt file
					myWriter.close(); // close the write character into txt file
					
					lblPhoneNumber.setText(inpPhoneNum); // change new value into label
					JOptionPane.showMessageDialog(frmStudentProfile, "Your phone number has been update."); // show message dialog
				}
				
		    } 
			catch (IOException ex) // catch ioexception
			{
				JOptionPane.showMessageDialog(frmStudentProfile, "Error on: " + ex); // show message dialog error exception
		    }
			catch (NullPointerException en) // catch nullpointerexception if value return is null
			{
				JOptionPane.showMessageDialog(frmStudentProfile, "Your have been cancel to update phone number."); // show message dialog
		    }
		}
	}
	
	private class EditChangePasswordButtonHandler implements ActionListener // create class for edit password button handler
	{ 
		public void actionPerformed(ActionEvent e) // execute if click the button
		{
			String inpPassword = JOptionPane.showInputDialog("Please enter a new password"); // show input dialog to user

			try // start handle exception
			{	
				while(inpPassword.isEmpty()) // verify if input from user is empty
					inpPassword = JOptionPane.showInputDialog("Please re-enter or fill new password"); // ask again input dialog to user

				if(!inpPassword.isEmpty()) // verify if input from user is not empty 
				{
					FileReader fr = new FileReader(filepath + "Records\\login.txt"); // locate the txt file from the path
					BufferedReader br = new BufferedReader(fr); // read text from input stream
					String line, user, lists = ""; // declare two variable in String
		            while ((line = br.readLine()) != null) { // loop to get line by line from txt file
		                user = line.substring(0,8); // substring start index 0 until 8
		                if (user.equals(lblMatricNum.getText())) // check if similar value from two variables
		                	line = user + " " + inpPassword; // concatenate multiple variable in string      	

		                lists += line + "\r\n"; // concatenate multiple variable in string 
		            }
		            br.close(); // close the read text
					
					FileWriter myWriter = new FileWriter(filepath + "Records\\login.txt"); // start write character data into txt file
					myWriter.write(lists); // write the value into txt file
					myWriter.close(); // close the write character into txt file
					
					lblChangePassword.setText(inpPassword); // change new value into label
					JOptionPane.showMessageDialog(frmStudentProfile, "Your password has been update."); // show message dialog
				}
				
		    } 
			catch (IOException ex) // start handling on IOException
			{
			    System.out.println("Error on: " + ex); // show error code
		    }
			catch (NullPointerException en) // start handling on NullPointerException
			{
				JOptionPane.showMessageDialog(frmStudentProfile, "Your have been cancel to update password."); // show message dialog
		    }
		}
	}
	
	private class BackButtonHandler implements ActionListener // create class for back button handler
	{
		public void actionPerformed(ActionEvent e) // execute if click the button
		{			
			try // start handle exception
    		{
    			HomePage home = new HomePage(); // create instanse name of HomePage
        		FileReader fr1 = new FileReader(filepath + "Records\\Students\\" + lblMatricNum.getText() +".txt"); // locate the txt file from the path
				BufferedReader br1 = new BufferedReader(fr1); // read text from input stream
				String line; // declaration of variable in string
				int count = 0; // declare one variable in Integer
				while ((line = br1.readLine()) != null) { // loop to get line by line from txt file
					if(count == 0) //check if similar value with 0
						home.setNameSession(line); // call function with parameter of line

					count++; // increment of count
				}
        		home.setMatricNumSession(lblMatricNum.getText()); // call function with value inside paramater
        		home.frmHomePage.setVisible(true); // display frame HomePage
        		frmStudentProfile.setVisible(false); // hide frame StudentProfile
    		}
    		catch(Exception ex) // catch handling Exception
    		{
    			JOptionPane.showMessageDialog(null, "An error occured: " + ex); // show message error
    		}		
		}
	}
	
	public void setMatricNumSession(String a) // create function setMatricNumSession with one parameter
	{
		try // start handle exception
		{
			lblMatricNum.setText(a); // set new value on label
			File myObj = new File(filepath + "Records\\Students\\" + a + ".txt"); // locate the txt file from the path
			Scanner myReader = new Scanner(myObj); // read the character data from txt file
			Boolean name = false, matricnum = false, programme = false, phonenum = false; // initialization four variables with false
			while (myReader.hasNextLine()) // loop to get line by line from txt file
			{
				String data = myReader.nextLine(); // store value each of new line

				if(!name) // check if false then execute
				{
					lblName.setText(data); // set new value at label
					name = true; // set variable as true
				}
				else if(!matricnum) // check if false then execute
				{
					lblMatricNum.setText(data); // set new value at label
					matricnum = true; // set variable as true
				}
				else if(!programme) // check if false then execute
				{
					lblProgramme.setText(data); // set new value at label
					programme = true; // set variable as true
				}
				else if(!phonenum) // check if false then execute
				{
					lblPhoneNumber.setText(data); // set new value at label
					phonenum = true; // set variable as true
				}
			}
			myReader.close(); // close the read txt file
			
			FileReader fr = new FileReader(filepath + "Records\\login.txt"); // locate the txt file from the path
			BufferedReader br = new BufferedReader(fr); // read the character data from txt file
			String line, user, pasd; // declaration of three variables
            while ((line = br.readLine()) != null) { // loop to get line by line from txt file
                user = line.substring(0,8); // use substring to get a certain limit word
                pasd = line.substring(9); // use substring to get a certain limit word
                if (user.equals(lblMatricNum.getText())) { // if value is similar from label
                	lblChangePassword.setText(pasd); // change to a new value at label
                    break; // exit block execute
                }
            }
            br.close(); // close the read txt file
		}
		catch (Exception ex) // handling exception
		{
			JOptionPane.showMessageDialog(null, "An error occured: " + ex); // show message error
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	/**
	 * Date: 17/06/2021
	 * Author: Adli
	 * Description: Create the application.
	 */
	public StudentProfile() {
		initialize();
	}

	/**
	 * Date: 17/06/2021
	 * Author: Adli
	 * Description: Initialize the contents of the frame.
	 */
	private void initialize() { // first form to show after execute
		frmStudentProfile = new JFrame();
		frmStudentProfile.setTitle("FSKTM Course Registration");
		frmStudentProfile.setResizable(false);
		frmStudentProfile.getContentPane().setBackground(new Color(137, 207, 240));
		frmStudentProfile.getContentPane().setLayout(null);
		frmStudentProfile.setBounds(100, 100, 886, 407);
		frmStudentProfile.setLocationRelativeTo(null);
		panelHeader(); // call function panelHeader to load a title
		panelPhoto(); // call function panelPhoto to show image
		panelInformation(); // call function panelInformation to show details student
		footer(); // call function footer to show some button at the footer layout
		frmStudentProfile.repaint();
		frmStudentProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void panelHeader() // function panelHeader to load a title
	{
		pnlHeader = new JPanel();
		pnlHeader.setBackground(UIManager.getColor("Button.background"));
		pnlHeader.setBounds(0, 0, 872, 69);
		frmStudentProfile.getContentPane().add(pnlHeader);
		pnlHeader.setLayout(null);
		
		lblStudentProfile = new JLabel("Student Profile");
		lblStudentProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentProfile.setBounds(0, 34, 872, 25);
		lblStudentProfile.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		pnlHeader.add(lblStudentProfile);
		
		lblCourseRegistration = new JLabel("Course Registration");
		lblCourseRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseRegistration.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblCourseRegistration.setBounds(0, 8, 872, 25);
		pnlHeader.add(lblCourseRegistration);
	}
	
	private void panelPhoto() // function panelPhoto to show image
	{
		pnlPhoto = new JPanel();
		pnlPhoto.setBounds(10, 85, 163, 209);
		frmStudentProfile.getContentPane().add(pnlPhoto);
		pnlPhoto.setLayout(null);
		
		lblPhoto = new JLabel("");
		lblPhoto.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoto.setIcon(new ImageIcon(filepath + "account\\stud-profile.jpg"));
		lblPhoto.setBounds(0, 0, 168, 209);
		pnlPhoto.add(lblPhoto);
	}
	
	private void panelInformation() // function panelInformation to show details student
	{
		pnlInformation = new JPanel();
		pnlInformation.setBackground(SystemColor.menu);
		pnlInformation.setBounds(196, 85, 666, 209);
		frmStudentProfile.getContentPane().add(pnlInformation);
		pnlInformation.setLayout(new MigLayout("", "[197px][][197px][]", "[41px][41px][41px][41px][]"));
		
		lblStudName = new JLabel("Name");
		lblStudName.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudName.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlInformation.add(lblStudName, "cell 0 0,grow");
		
		lblColon_1 = new JLabel(":");
		pnlInformation.add(lblColon_1, "cell 1 0");
		
		lblName = new JLabel("");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlInformation.add(lblName, "cell 2 0,grow");
		
		lblStudMatricNum = new JLabel("Matric No.");
		lblStudMatricNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudMatricNum.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlInformation.add(lblStudMatricNum, "cell 0 1,grow");
		
		lblColon_2 = new JLabel(":");
		pnlInformation.add(lblColon_2, "cell 1 1");
		
		lblMatricNum = new JLabel("");
		lblMatricNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlInformation.add(lblMatricNum, "cell 2 1");
		
		lblStudProgramme = new JLabel("Programme");
		lblStudProgramme.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudProgramme.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlInformation.add(lblStudProgramme, "cell 0 2");
		
		lblColon_3 = new JLabel(":");
		pnlInformation.add(lblColon_3, "cell 1 2");
		
		lblProgramme = new JLabel("");
		lblProgramme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlInformation.add(lblProgramme, "cell 2 2");
		
		lblStudPhoneNumber = new JLabel("Phone Number");
		lblStudPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlInformation.add(lblStudPhoneNumber, "cell 0 3");
		
		lblColon_4 = new JLabel(":");
		pnlInformation.add(lblColon_4, "cell 1 3");
		
		lblPhoneNumber = new JLabel("");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlInformation.add(lblPhoneNumber, "cell 2 3");
		
		btnEditPhoneNumber = new JButton("Edit");
		epnbHandler = new EditPhoneNumberButtonHandler();
		btnEditPhoneNumber.addActionListener(epnbHandler);
		btnEditPhoneNumber.setBackground(new Color(4, 36, 66));
		btnEditPhoneNumber.setForeground(Color.WHITE);
		pnlInformation.add(btnEditPhoneNumber, "cell 3 3");
		
		lblStudChangePassword = new JLabel("Change Password");
		lblStudChangePassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudChangePassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlInformation.add(lblStudChangePassword, "cell 0 4");
		
		lblColon_5 = new JLabel(":");
		pnlInformation.add(lblColon_5, "cell 1 4");
		
		lblChangePassword = new JLabel("");
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlInformation.add(lblChangePassword, "cell 2 4");
		
		btnEditChangePassword = new JButton("Edit");
		ecpbHandler = new EditChangePasswordButtonHandler();
		btnEditChangePassword.addActionListener(ecpbHandler);
		btnEditChangePassword.setBackground(new Color(4, 36, 66));
		btnEditChangePassword.setForeground(Color.WHITE);
		pnlInformation.add(btnEditChangePassword, "cell 3 4");
	}
	
	private void footer() // call function footer to show some button at the footer layout
	{
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(4, 36, 66));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(10, 328, 85, 26);
		bbHandler = new BackButtonHandler();
		btnBack.addActionListener(bbHandler);
		frmStudentProfile.getContentPane().add(btnBack);
	}
}
