package home;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import account.StudentProfile;
import delete.DeleteRegister;
import login.LoginPage;
import subject.AddSubject;
import subject.ViewPage;
import update.UpdatePage;

public class HomePage {

	//declare variable
	public JFrame frmHomePage;
	private AccountButtonHandler abHandler;
	private DeleteButtonHandler dbHandler;
	private LogoutButtonHandler lbHandler;
	private AddButtonHandler addbHandler;
	private ViewButtonHandler vbHandler;
	private UpdateButtonHandler ubHandler;
	private JLabel lblStudName;
	private JLabel lblStudMatricNum;

	//go to student profile when my account button clicked
	private class AccountButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			StudentProfile studprof = new StudentProfile();
			studprof.setMatricNumSession(lblStudMatricNum.getText());
			studprof.frmStudentProfile.setVisible(true);
			frmHomePage.setVisible(false);
		}
	}
	
	//go to delete page when delete button clicked
	private class DeleteButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DeleteRegister delreg = new DeleteRegister();
			delreg.setMatricNumSession(lblStudMatricNum.getText());
			delreg.showRegisterSubject(lblStudMatricNum.getText());
			delreg.frmCourseRegistration.setVisible(true);
			frmHomePage.setVisible(false);
		}
	}
	
	//show message and go to login page when button clicked
	private class LogoutButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "You have been Logout.\nThank you and\nhave a nice day.");
			LoginPage obj = new LoginPage();
			frmHomePage.setVisible(false);
			obj.frmCourseRegistration.setVisible(true);
		}
	}
	
	//go to add page when button clicked
	private class AddButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			AddSubject add = new AddSubject();
			add.setMatricNumSession(lblStudMatricNum.getText());
			add.frmAddSubject.setVisible(true);
			frmHomePage.setVisible(false);
		}
	}
	
	//go to update page when button clicked
	private class UpdateButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			UpdatePage update = new UpdatePage();
			update.showRegisterSubject(lblStudMatricNum.getText());
			update.frmUpdatepage.setVisible(true);
			frmHomePage.setVisible(false);
		}
	}
	
	//go to view page when button clicked
	private class ViewButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
				ViewPage view = new ViewPage();
				view.setMatricNumSession(lblStudMatricNum.getText());
				view.setNameSession(lblStudName.getText());
				view.setProgrammeSession();
				view.showRegisterSubject();
				view.frmViewSubject.setVisible(true);
				frmHomePage.setVisible(false);
		}
	}
	
	public void setMatricNumSession(String a)
	{
		lblStudMatricNum.setText(a); //get user's matric number from login
	}
	
	public void setNameSession(String a)
	{
		lblStudName.setText(a); //get user's name from login
	}
	
	public String getMatricNumSession()
	{
		return lblStudMatricNum.getText(); //method to send user's matric to other page
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					HomePage window = new HomePage();
					LoginPage login = new LoginPage();
					window.frmHomePage.setVisible(true); //show home page frame
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public HomePage() {
		initialize();
	}

	private void initialize() {
		//design the frame
		frmHomePage = new JFrame();
		frmHomePage.setResizable(false);
		frmHomePage.setTitle("FSKTM Course Registration");
		frmHomePage.setBounds(100, 100, 579, 340);
		frmHomePage.setLocationRelativeTo(null);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		//design the header
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(UIManager.getColor("Button.background"));
		pnlHeader.setBounds(0, 0, 565, 42);
		frmHomePage.getContentPane().add(pnlHeader);
		pnlHeader.setLayout(null);
		
		//design the title name
		JLabel lblTitle = new JLabel("Course Registration");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblTitle.setBounds(0, 10, 564, 25);
		pnlHeader.add(lblTitle);
		
		//design the body
		JPanel pnlBody = new JPanel();
		pnlBody.setBackground(new Color(137, 207, 240));
		pnlBody.setBounds(0, 40, 565, 263);
		frmHomePage.getContentPane().add(pnlBody);
		pnlBody.setLayout(null);
		
		//design add button
		JButton btnAdd = new JButton("Register");
		btnAdd.setBackground(new Color(4, 36, 66));
		btnAdd.setForeground(Color.WHITE);
		addbHandler = new AddButtonHandler();
		btnAdd.addActionListener(addbHandler);
		btnAdd.setBounds(116, 95, 120, 23);
		pnlBody.add(btnAdd);
		
		//design delete button
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(4, 36, 66));
		btnDelete.setForeground(Color.WHITE);
		dbHandler = new DeleteButtonHandler();
		btnDelete.addActionListener(dbHandler);
		btnDelete.setBounds(309, 95, 115, 23);
		pnlBody.add(btnDelete);
		
		//design update button
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(4, 36, 66));
		btnUpdate.setForeground(Color.WHITE);
		ubHandler = new UpdateButtonHandler();
		btnUpdate.addActionListener(ubHandler); 
		btnUpdate.setBounds(116, 198, 120, 23);
		pnlBody.add(btnUpdate);
		
		//design view button
		JButton btnView = new JButton("View");
		btnView.setBackground(new Color(4, 36, 66));
		btnView.setForeground(Color.WHITE);
		vbHandler = new ViewButtonHandler();
		btnView.addActionListener(vbHandler);
		btnView.setBounds(116, 146, 120, 23);
		pnlBody.add(btnView);
		
		//design my account button
		JButton btnAccount = new JButton("My Account");
		btnAccount.setBackground(new Color(4, 36, 66));
		btnAccount.setForeground(Color.WHITE);
		abHandler = new AccountButtonHandler();
		btnAccount.addActionListener(abHandler);
		btnAccount.setBounds(309, 146, 115, 23);
		pnlBody.add(btnAccount);
		
		//design logout button
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(4, 36, 66));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBounds(309, 198, 115, 23);
		lbHandler = new LogoutButtonHandler();
		btnLogout.addActionListener(lbHandler);
		pnlBody.add(btnLogout);
		
		JLabel lblName = new JLabel("Student Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(88, 9, 111, 23);
		pnlBody.add(lblName);
		
		//to display student information
		lblStudName = new JLabel("");
		lblStudName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudName.setBounds(206, 9, 359, 25);
		pnlBody.add(lblStudName);
		
		JLabel lblMatricNum = new JLabel("Matric Number:");
		lblMatricNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatricNum.setBounds(88, 42, 111, 23);
		pnlBody.add(lblMatricNum);
		
		lblStudMatricNum = new JLabel("");
		lblStudMatricNum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudMatricNum.setBounds(206, 42, 359, 25);
		pnlBody.add(lblStudMatricNum);
	}
}