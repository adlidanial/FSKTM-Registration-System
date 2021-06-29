package login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import subject.AddSubject;
import home.HomePage;

public class LoginPage {

	//variable declaration
	public JFrame frmCourseRegistration;
	private JTextField txtMatricNum;
	private JButton btnLogin;
	private JPasswordField txtPassword;
	private String filepath =  System.getProperty("user.dir") + "\\src\\"; //location of the file
	private JPanel pnlHeader;
	private JLabel lblCourseRegistration;
	private JPanel pnlBody;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					LoginPage window = new LoginPage();
					window.frmCourseRegistration.setVisible(true); //to show the frame 
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


	public LoginPage() {
		initialize(); //call initialize method, automatic will run since it inside constructor
	}

	private void initialize() {
		//design the frame to specific style
		frmCourseRegistration = new JFrame();
		frmCourseRegistration.setResizable(false);
		frmCourseRegistration.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frmCourseRegistration.getContentPane().setBackground(new Color(137, 207, 240));
		frmCourseRegistration.setBackground(new Color(255, 255, 255));
		frmCourseRegistration.setTitle("FSKTM Course Registration");
		frmCourseRegistration.setBounds(100, 100, 450, 261);
		frmCourseRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCourseRegistration.setLocationRelativeTo(null);
		frmCourseRegistration.getContentPane().setLayout(null);
		
		//add header in the frame
		pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(SystemColor.menu);
		pnlHeader.setBounds(0, 0, 436, 44);
		frmCourseRegistration.getContentPane().add(pnlHeader);
		
		//label to show system name
		lblCourseRegistration = new JLabel("Course Registration");
		lblCourseRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseRegistration.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblCourseRegistration.setBounds(10, 10, 416, 25);
		pnlHeader.add(lblCourseRegistration);
		
		//body of the frame
		pnlBody = new JPanel();
		pnlBody.setBackground(new Color(137, 207, 240));
		pnlBody.setBounds(0, 73, 436, 151);
		frmCourseRegistration.getContentPane().add(pnlBody);
		pnlBody.setLayout(new MigLayout("", "[][62.00][][][][][][][45.00,grow]", "[][][][32.00][]"));
		
		//label show text
		JLabel lblNewLabel = new JLabel("Matric Number : ");
		pnlBody.add(lblNewLabel, "cell 3 0,alignx center");
		
		//get user's matric number in text field
		txtMatricNum = new JTextField();
		pnlBody.add(txtMatricNum, "cell 6 0");
		txtMatricNum.setColumns(10);
		
		//label show text
		JLabel lblPassword = new JLabel("Password : ");
		pnlBody.add(lblPassword, "cell 3 2");
		
		//get user's password in text field
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		pnlBody.add(txtPassword, "cell 6 2");
		
		//login button to click
		btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(4, 36, 66));
		btnLogin.setForeground(Color.WHITE);
		pnlBody.add(btnLogin, "cell 5 4");
		//login button action after click
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//link to the file where it contain user login information
					FileReader fr = new FileReader(filepath+"Records\\login.txt");
					BufferedReader br = new BufferedReader(fr);
					//declare variable
					String line,user,pasd;
					//declare a variable boolean as false
					boolean isLoginSuccess = false;
					//check each line of string in the file, keep searching until the last line of string
		            while ((line = br.readLine()) != null) {
		                user = line.substring(0,8); //start from position 0 to 8 characters are user's matric number
		                pasd = line.substring(9);//start from position 9 and above characters are user's password
		                //compare the string user input and information in file
		                if (user.equals(txtMatricNum.getText()) && pasd.equals(txtPassword.getText())) {
		                	HomePage home = new HomePage();
		                	AddSubject add = new AddSubject();
		                    isLoginSuccess = true; 
		                    FileReader fr1 = new FileReader(filepath+"Records\\Students\\" + user + ".txt");  
							BufferedReader br1 = new BufferedReader(fr1);
							//search to get information of the student in another file
							int count = 0;
							while ((line = br1.readLine()) != null) {
								
								if(count == 0)
									home.setNameSession(line);

								count++;
							}
							br1.close();
							add.setMatricNumSession(user);
		                    home.setMatricNumSession(user);
		                    //if the matric and password match the go to home page, hide login page
		                    frmCourseRegistration.setVisible(false);
							home.frmHomePage.setVisible(true);
		                    break;
		                }
		            }
		            //if not match show error message
		            if (!isLoginSuccess) {
		            	JOptionPane.showMessageDialog(null, "Invalid matric number or password.");
		            }
		            br.close();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(frmCourseRegistration, "Something is wrong: File not Found!", "FSKTM Course Registration", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frmCourseRegistration, "Something is wrong: " + e, "FSKTM Course Registration", JOptionPane.ERROR_MESSAGE);
					System.out.println("An error occured.");
					e.printStackTrace();
				}
			}
		});
	}
}

