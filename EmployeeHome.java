import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class EmployeeHome extends JFrame implements ActionListener
{
	JLabel welcomeLabel, ebackGround;
	JButton manageEmployeeBtn, changePasswordBtn, viewDetailsBtn, logoutBtn, studentDetailsBtn, bookManageBtn;
	JPanel panel;
	String userId;
	//EmployeeLogin el;
	Font pixelPowerline;
	ImageIcon img, mbtnImg, ibtnImg, cbtnImg, lbtnImg, limg, simg, bimg;
	
	public EmployeeHome(String userId)
	{
		super("Employee Home");
		
		limg = new ImageIcon ("library.png");
		this.setIconImage (limg.getImage());
		this.userId = userId;
		//this.el = el;
		this.setSize(600,410);
		this.setLocation(300,150);
		this.setResizable (false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try
		{
			pixelPowerline = Font.createFont(Font.TRUETYPE_FONT, new File("pixelPowerline.ttf")).deriveFont(15f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont (Font.createFont(Font.TRUETYPE_FONT, new File ("pixelPowerline.ttf")));
		}
		catch(IOException | FontFormatException e){}
		
		panel = new JPanel();
		panel.setLayout(null);
		
		img = new ImageIcon ("elogin.jpg");
		mbtnImg = new ImageIcon ("rsz_manage.png");
		ibtnImg = new ImageIcon ("rsz_information.png");
		cbtnImg = new ImageIcon ("rsz_change.png");
		lbtnImg = new ImageIcon ("rsz_logout.png");
		simg = new ImageIcon ("rsz_student-information-system.png");
		bimg = new ImageIcon ("rsz_book.png");
		
		welcomeLabel = new JLabel("Welcome, "+userId);
		welcomeLabel.setBounds(410, 50, 400, 30);
		welcomeLabel.setFont (pixelPowerline);
		welcomeLabel.setForeground (Color.WHITE);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton(lbtnImg);
		logoutBtn.setBounds(550, 55, 24, 24);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		manageEmployeeBtn = new JButton("Manage Employee",mbtnImg);
		manageEmployeeBtn.setBounds(30, 90, 170, 35);
		manageEmployeeBtn.addActionListener(this);
		panel.add(manageEmployeeBtn);
		
		bookManageBtn = new JButton ("Manage Book",bimg);
		bookManageBtn.setBounds (30, 130, 170, 35);
		bookManageBtn.addActionListener (this);
		panel.add (bookManageBtn);
		
		studentDetailsBtn = new JButton ("Student Details",simg);
		studentDetailsBtn.setBounds (30, 170, 170, 35);
		studentDetailsBtn.addActionListener (this);
		panel.add (studentDetailsBtn);
		
		
		viewDetailsBtn = new JButton("My Information",ibtnImg);
		viewDetailsBtn.setBounds(30, 210, 170, 35);
		viewDetailsBtn.addActionListener(this);
		panel.add(viewDetailsBtn);
		
		changePasswordBtn = new JButton("Change Password",cbtnImg);
		changePasswordBtn.setBounds(30, 250, 170, 35);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		ebackGround = new JLabel (img,JLabel.CENTER);
		ebackGround.setBounds (0, 0, 600, 400);
		panel.add (ebackGround);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand ();
		
		if(text.equals(logoutBtn.getText()))
		{
			HomeWindow hw = new HomeWindow();
			hw.setVisible(true);
			this.setVisible(false);
		}
		else if (text.equals(manageEmployeeBtn.getText()))
		{
		
			ManageEmployee me = new ManageEmployee (userId);
			me.setVisible (true);
			this.setVisible (false);
		}
		else if (text.equals(bookManageBtn.getText()))
		{
			ManageBook mb = new ManageBook (userId);
			mb.setVisible (true);
			this.setVisible (false);
		}
		
	}
}