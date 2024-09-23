package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AfterRegister extends JFrame {

	private JPanel pane1;
	private JTextField fname;
	private JTextField usn;
	private JTextField lname;
	private JTextField contact;
	private JLabel lblName_1;
	private JTextField pname;
	private JTextField plname;
	private JLabel lblContact;
	private JTextField pcontact;
	private JLabel lblRegister;
	private JLabel lblEmail;
	private JTextField email;
	private JButton btnSubmit;
	final JFrame frame=new JFrame("Close Window");
	private JTextField rno;
	private JLabel lblNewLabel_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterRegister frame = new AfterRegister();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AfterRegister() {
		setEnabled(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 715);
		pane1 = new JPanel();
		pane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane1);
		pane1.setLayout(null);
		
		
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/sas.png")));
		lblName.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblName.setBounds(14, 83, 97, 32);
		pane1.add(lblName);
		
		fname = new JTextField();
		fname.setBounds(178, 126, 160, 22);
		pane1.add(fname);
		fname.setColumns(10);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/id-card(1).png")));
		lblUsn.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblUsn.setBounds(472, 83, 97, 32);
		pane1.add(lblUsn);
		
		usn = new JTextField();
		usn.setBounds(470, 125, 152, 22);
		pane1.add(usn);
		usn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Course Id");
		lblNewLabel.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/edit.png")));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblNewLabel.setBounds(468, 168, 122, 32);
		pane1.add(lblNewLabel);
		
		lname = new JTextField();
		lname.setBounds(10, 126, 160, 22);
		pane1.add(lname);
		lname.setColumns(10);
		String cids[]=new String[] {"B.Tech","MBA","MCA"};
		JComboBox<String> cid = new JComboBox<String>(cids);
		cid.setBounds(471, 224, 98, 22);
		pane1.add(cid);
		
		JLabel lblPhoneNumber = new JLabel("Contact ");
		lblPhoneNumber.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/asa.png")));
		lblPhoneNumber.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblPhoneNumber.setBounds(3, 275, 105, 32);
		pane1.add(lblPhoneNumber);
		
		contact = new JTextField();
		contact.setBounds(7, 320, 160, 22);
		pane1.add(contact);
		contact.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("D.O.B");
		lblDateOfBirth.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/calendar.png")));
		lblDateOfBirth.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblDateOfBirth.setBounds(14, 179, 97, 32);
		pane1.add(lblDateOfBirth);
		
		JLabel lblParentsContact = new JLabel("Parents/Guardian Info :");
		lblParentsContact.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblParentsContact.setBounds(14, 438, 200, 16);
		pane1.add(lblParentsContact);
		
	
		
		JDateChooser dob = new JDateChooser();
		dob.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		dob.setBounds(9, 224, 143, 22);
		pane1.add(dob);
		
		lblName_1 = new JLabel("Name");
		lblName_1.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/sas.png")));
		lblName_1.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblName_1.setBounds(15, 488, 96, 32);
		pane1.add(lblName_1);
		
		pname = new JTextField();
		pname.setBounds(11, 533, 160, 22);
		pane1.add(pname);
		pname.setColumns(10);
		
		plname = new JTextField();
		plname.setBounds(190, 533, 160, 22);
		pane1.add(plname);
		plname.setColumns(10);
		
		lblContact = new JLabel("Contact");
		lblContact.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/asa.png")));
		lblContact.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblContact.setBounds(481, 490, 112, 32);
		pane1.add(lblContact);
		
		pcontact = new JTextField();
		pcontact.setBounds(487, 534, 143, 22);
		pane1.add(pcontact);
		pcontact.setColumns(10);
		
		lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblRegister.setBounds(313, 9, 211, 47);
		pane1.add(lblRegister);
		
		lblEmail = new JLabel("Email");
		lblEmail.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/qw.png")));
		lblEmail.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblEmail.setBounds(484, 283, 105, 34);
		pane1.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(481, 326, 160, 22);
		pane1.add(email);
		email.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			private Object frame;

			public void actionPerformed(ActionEvent arg0) {
				String a=email.getText();
				
				
				if(usn.getText().isEmpty()||fname.getText().isEmpty()||dob.getDateFormatString().isEmpty()||contact.getText().isEmpty()||email.getText().isEmpty()||pname.getText().isEmpty()||plname.getText().isEmpty()||rno.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"One or more fields are empty");
				}
				else if(a.indexOf("@gmail.com")==-1)
				{
					JOptionPane.showMessageDialog(null,"Invalid email,works only for gmail email ids");
				}
			
				else
				{	try
					{
					Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
                    PreparedStatement ps1 = con.prepareStatement("INSERT INTO `register`(FirstName,LastName,USN,DOB,CourseId,Contact,Email,PName,PLName,PContact,RoomNo) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?)");
                    String d1  = ((JTextField)dob.getDateEditor().getUiComponent()).getText();
                    ps1.setString(1,fname.getText());
                    ps1.setString(2, lname.getText());
                    ps1.setString(3,usn.getText());
                    ps1.setString(4,d1);
                  ps1.setString(5, (String) cid.getSelectedItem());
                    ps1.setString(6,contact.getText());
                    ps1.setString(7, email.getText());
                    ps1.setString(8, pname.getText());
                    ps1.setString(9, plname.getText());
                    ps1.setString(10,pcontact.getText());
                    ps1.setString(11, rno.getText());
                    ps1.executeUpdate();
            		System.out.println(d1);
            		PreparedStatement ps12 = con.prepareStatement("INSERT INTO `fees`(USN,Name,Fees,Paid,Balance) VALUES (?, ?, ?, ?,?)");
            		ps12.setString(1, usn.getText());
            		ps12.setString(2, fname.getText()+lname.getText());
            		ps12.setString(3, "60000");
            		ps12.setString(4, "0");
            		ps12.setString(5, "0");
            		ps12.executeUpdate();
            		//GoogleMail gm=new GoogleMail(email.getText(),rno.getText());
					AfterRegister ar=new AfterRegister();
					setVisible(false);
					
					//Date date = new Date(datePicker.getvalue().toEpochDay());
					}
					catch(Exception e)
				{
						System.out.println(e);
				}
				}
			}
		});
		btnSubmit.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnSubmit.setBounds(287, 612, 97, 25);
		pane1.add(btnSubmit);
		
		JLabel lblRoomNumber = new JLabel("Room No.");
		lblRoomNumber.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/room-key.png")));
		lblRoomNumber.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblRoomNumber.setBounds(11, 358, 112, 30);
		pane1.add(lblRoomNumber);
		
		rno = new JTextField();
		rno.setBounds(11, 398, 116, 22);
		pane1.add(rno);
		rno.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/checked.png")));
		label.setBounds(391, 608, 32, 32);
		pane1.add(label);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/back.png")));
		button.setBounds(2, 627, 44, 38);
		pane1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/house.png")));
		button_1.setBounds(1, 2, 44, 38);
		pane1.add(button_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AfterRegister.class.getResource("/images/ad.jpg")));
		label_1.setBounds(-3, 0, 728, 672);
		pane1.add(label_1);
		
	
		
	}
}
