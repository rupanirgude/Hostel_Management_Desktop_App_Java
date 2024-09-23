package proFinal;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import java.util.Date;

public class HostelLogin extends JFrame {
	private JTextField user;
	private JPasswordField pass;
	JLabel alertText;
	JLabel at;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HostelLogin frame = new HostelLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HostelLogin() {
		setResizable(false);
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		getContentPane().setLayout(null);
		alertText = new JLabel("");
		alertText.setBounds(106, 206, 177, 30);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblUsername.setBounds(188, 196, 118, 19);
		getContentPane().add(lblUsername);
		
		user = new JTextField();
		user.setBounds(318, 196, 145, 22);
		getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblNewLabel.setBounds(188, 257, 110, 21);
		getContentPane().add(lblNewLabel);
		
		pass = new JPasswordField();
		pass.setBounds(318, 256, 145, 22);
		getContentPane().add(pass);
		
		at = new JLabel("");
	     at.setBounds(174, 404, 305, 25);
	   getContentPane().add(at);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
                {	at.setText("");
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
                    //java.sql.Statement stmt=con.createStatement();
                    
            		int i=0;
            		
            		
            		
                    String query="Select * from username where BINARY username=? and BINARY password=?";
                    String m=user.getText();
                    String n=pass.getText();
                    //System.out.println("Success");
                    PreparedStatement ps=con.prepareStatement(query);
                    ps.setString(1,m);
                    ps.setString(2,n);
                    String a=user.getText();
                    String b=pass.getText();
                    System.out.println(a);
                    System.out.println(b);
                    at.setText("");
                    
                    ResultSet rs=ps.executeQuery();
                  
                   
                    if(rs.next())
                    {
                    	at.setText("");
                    	
                    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    	Date date = new Date();
                    	
                    	DateFormat time = new SimpleDateFormat("HH:mm:ss");
                    	Date time1 = new Date();
                       
                        PreparedStatement ps1 = con.prepareStatement("INSERT INTO `loginlog`(username,password,time,date) VALUES (?, ?, ?, ?)");
                       //dateFormat.format(date)
                        ps1.setString(1,m);
                        ps1.setString(2,n);
                        ps1.setString(3,time.format(time1));
                        ps1.setString(4,dateFormat.format(date));
                        ps1.executeUpdate();
                        //setVisible(false);
                        String a1=user.getText();
                        AfterLogin h=new AfterLogin(a);
                        h.setVisible(true);
                        user.setText("");
                        pass.setText("");
                        setVisible(false);
                    }
                    else if(pass.getText().equals("")&&user.getText().isEmpty()==false)
                    {	
                    	
                    	
                    	at.setText("Enter Password");
                    	at.setForeground(Color.red);
                    	at.setIcon(new ImageIcon("E:\\am.png"));
                        at.setFont(new Font("Russo One 13", Font.PLAIN, 14));
                    	
                    	
                  
                    }
                    else if(pass.getText().isEmpty()==false&&user.getText().isEmpty()==true)
                    {
                    	at.setText("");
                    	at.setText("Enter the Username");
                    	at.setIcon(new ImageIcon("E:\\am.png"));
                    	at.setForeground(Color.red);
                    	at.setFont(new Font("Russo One 13", Font.PLAIN, 14));
                    }
                    else if(pass.getText().isEmpty()==true&&user.getText().isEmpty()==true)
                    {
                    	at.setText("");
                    	at.setText("Enter the username and password");
                    	at.setForeground(Color.red);
                    	at.setIcon(new ImageIcon("E:\\am.png"));
                    	at.setFont(new Font("Russo One 13", Font.PLAIN, 14));
                    }
                    else
                    {
                    	at.setText("");
                    	at.setText("Username and password dont match");
                    	at.setForeground(Color.red);
                    	at.setIcon(new ImageIcon("E:\\am.png"));
                    	at.setFont(new Font("Russo One 13", Font.PLAIN, 14));
                    }
                }
                
			
               
                catch(Exception e2)
                {
                    System.out.println("Unsuccessful"+e2);
                }
            }
			
		});
		btnSubmit.setBounds(366, 300, 97, 25);
		getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(HostelLogin.class.getResource("/proFinal/avatar(1).png")));
		lblNewLabel_1.setBounds(148, 196, 28, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HostelLogin.class.getResource("/proFinal/lock.png")));
		label.setBounds(148, 252, 28, 22);
		getContentPane().add(label);
		
		JLabel lblHostelBuddy = new JLabel("Hostel Buddy");
		lblHostelBuddy.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblHostelBuddy.setForeground(Color.WHITE);
		lblHostelBuddy.setBounds(200, 70, 281, 51);
		getContentPane().add(lblHostelBuddy);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HostelLogin.class.getResource("/proFinal/abc.jpg")));
		label_1.setBounds(0, 0, 656, 478);
		getContentPane().add(label_1);
		
		
		
		
		
		
		
		
		
		JFrame jf=new JFrame();
	}
	}
