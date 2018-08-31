import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class StudentHome extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton changePasswordBtn, logoutBtn;
	JPanel panel;
	String userId;
	
	public StudentHome(String userId)
	{
		super("Sample Management System - Customer Home Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
	}
}